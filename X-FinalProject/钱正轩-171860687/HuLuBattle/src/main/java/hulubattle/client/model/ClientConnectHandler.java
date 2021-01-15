package hulubattle.client.model;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

import hulubattle.game.model.LogConsumer;
import hulubattle.server.BattleTask;
import hulubattle.server.ReadHandler;

/**
 * 用于处理客户端的连接，连接完成后为其注册 read 事件的 handler
 */
public class ClientConnectHandler implements CompletionHandler<Void, AsynchronousSocketChannel> {
    private LogConsumer consumer;

    /**
     * 构造器
     *
     * @param consumer 处理读取到的 log 的对象
     */
    public ClientConnectHandler(LogConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void completed(Void result, AsynchronousSocketChannel attachment) {
        ByteBuffer buffer = ByteBuffer.allocate(BattleTask.BUFFER_SIZE);
        ReadHandler handler = new ReadHandler(attachment, buffer);
        handler.setConsumer(consumer);
        attachment.read(buffer, null, handler);
    }

    @Override
    public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
        // do-nothing
    }
}
