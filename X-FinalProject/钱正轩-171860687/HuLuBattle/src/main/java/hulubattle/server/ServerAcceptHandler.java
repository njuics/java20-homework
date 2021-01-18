package hulubattle.server;

import java.io.IOException;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
 * 用于处理监听事件的对象
 */
public class ServerAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Void> {
    private AsynchronousServerSocketChannel server;
    private Set<AsynchronousSocketChannel> channels = new HashSet<>();
    private ExecutorService battleServicePool;

    /**
     * 构造函数
     *
     * @param server            server socket
     * @param battleServicePool 对战用线程池
     */
    public ServerAcceptHandler(AsynchronousServerSocketChannel server, ExecutorService battleServicePool) {
        this.server = server;
        this.battleServicePool = battleServicePool;
    }

    @Override
    public void completed(AsynchronousSocketChannel result, Void attachment) {
        channels.add(result);
        if (channels.size() == 2) {
            Iterator<AsynchronousSocketChannel> it = channels.iterator();
            AsynchronousSocketChannel a = it.next();
            AsynchronousSocketChannel b = it.next();
            try {
                BattleTask handler = new BattleTask(a, b);
                battleServicePool.submit(handler);
            } catch (Exception e) {
                try {
                    a.close();
                    b.close();
                } catch (IOException f) {
                    // do nothing
                }
            }
            channels.clear();
        }
        server.accept(attachment, this);
    }

    @Override
    public void failed(Throwable exc, Void attachment) {
        // do nothing
    }
}
