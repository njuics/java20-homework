package hulubattle.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * server，维护一个 socket channel 和一个用于对战的线程池
 */
public class GameServer implements AutoCloseable {
    public static final InetSocketAddress SERVER_ADDR = new InetSocketAddress("127.0.0.1", 10080);
    private ExecutorService groupThreadPool = Executors.newCachedThreadPool();
    private ExecutorService battleServicePool = Executors.newCachedThreadPool();
    private AsynchronousChannelGroup group;
    private final AsynchronousServerSocketChannel serverSocket;

    /**
     * 初始化 socket
     *
     * @throws IOException IO 错
     */
    public GameServer() throws IOException {
        group = AsynchronousChannelGroup.withThreadPool(groupThreadPool);
        serverSocket = AsynchronousServerSocketChannel.open(group);
        serverSocket.setOption(StandardSocketOptions.SO_REUSEADDR, true);
        serverSocket.bind(SERVER_ADDR);
    }

    /**
     * 为 socket 配置监听的处理对象，调用后 client 可进行连接
     */
    public void accept() {
        serverSocket.accept(null, new ServerAcceptHandler(serverSocket, battleServicePool));
    }

    @Override
    public void close() throws Exception {
        battleServicePool.shutdown();
        battleServicePool.awaitTermination(2, TimeUnit.SECONDS);
        serverSocket.close();
    }
}
