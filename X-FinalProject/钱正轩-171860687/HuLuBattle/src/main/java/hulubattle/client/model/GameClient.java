package hulubattle.client.model;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import hulubattle.game.model.CombatLog;
import hulubattle.game.model.LogConsumer;
import hulubattle.server.BattleTask;
import hulubattle.server.GameServer;
import hulubattle.server.WriteHelper;

/**
 * Client，维护一个 channel 与 server 通信
 */
public class GameClient implements AutoCloseable {
    private ExecutorService groupThreadPool = Executors.newCachedThreadPool();
    private AsynchronousChannelGroup group;
    private LogConsumer consumer;
    private ByteBuffer buffer = ByteBuffer.allocate(BattleTask.BUFFER_SIZE);
    private final AsynchronousSocketChannel clientSocket;

    /**
     * 构造器
     *
     * @param consumer 处理读取到的 log 的对象
     * @throws IOException 打开连接失败
     */
    public GameClient(LogConsumer consumer) throws IOException {
        this.consumer = consumer;
        group = AsynchronousChannelGroup.withThreadPool(groupThreadPool);
        clientSocket = AsynchronousSocketChannel.open(group);
    }

    /**
     * 与 server 连接
     */
    public void connect() {
        clientSocket.connect(GameServer.SERVER_ADDR, clientSocket, new ClientConnectHandler(consumer));
    }

    /**
     * 向 server 发送 log
     *
     * @param log 日志对象
     */
    public void write(CombatLog log) {
        byte[] bytes = WriteHelper.format(log);
        buffer.clear();
        buffer.put(bytes);
        buffer.flip();
        Future<Integer> i = clientSocket.write(buffer);
        try {
            i.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        clientSocket.close();
    }
}
