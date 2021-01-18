package hulubattle.server;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

import hulubattle.game.model.CombatLog;
import hulubattle.game.model.Game;
import hulubattle.game.model.GameDelegate;

/**
 * 用于维护一场对战的 Runnable 对象，可以提交至线程池运行
 */
public class BattleTask implements Runnable, GameDelegate {
    public static final int BUFFER_SIZE = 1024;

    private AsynchronousSocketChannel socketA;
    private AsynchronousSocketChannel socketB;
    private ByteBuffer bufferA = ByteBuffer.allocate(BUFFER_SIZE);
    private ByteBuffer bufferB = ByteBuffer.allocate(BUFFER_SIZE);

    private Game game;
    private boolean flag = true;

    /**
     * 构造器
     *
     * @param a 选手 a 的 channel
     * @param b 选手 b 的 channel
     * @throws URISyntaxException 初始化 Game 时配置文件路径错误
     * @throws IOException        初始化 Game 对象时配置文件读取错误
     */
    public BattleTask(AsynchronousSocketChannel a, AsynchronousSocketChannel b) throws URISyntaxException, IOException {
        socketA = a;
        socketB = b;
        game = new Game();
        game.setDelegate(this);
    }

    @Override
    public void run() {
        game.setUp();
        ByteBuffer a = ByteBuffer.allocate(BUFFER_SIZE);
        ByteBuffer b = ByteBuffer.allocate(BUFFER_SIZE);
        ReadHandler handlerA = new ReadHandler(socketA, a);
        ReadHandler handlerB = new ReadHandler(socketB, b);
        handlerA.setConsumer(game);
        handlerB.setConsumer(game);

        socketA.read(a, null, handlerA);
        socketB.read(b, null, handlerB);

        while (flag && !Thread.currentThread().isInterrupted() && socketA.isOpen() && socketB.isOpen()) {
            // waiting
        }

        try {
            if (socketA.isOpen()) {
                socketA.close();
            }
            if (socketB.isOpen()) {
                socketB.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendLog(CombatLog log) {
        send(log, log);
    }

    @Override
    public void sendLog(CombatLog msgA, CombatLog msgB) {
        send(msgA, msgB);
    }

    private void send(CombatLog logA, CombatLog logB) {
        byte[] a = WriteHelper.format(logA);
        byte[] b = WriteHelper.format(logB);
        send(a, bufferA, socketA);
        send(b, bufferB, socketB);
    }

    private void send(byte[] bytes, ByteBuffer buffer, AsynchronousSocketChannel socket) {
        buffer.clear();
        buffer.put(bytes);
        buffer.flip();

        Future<Integer> i = socket.write(buffer);
        try {
            i.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
