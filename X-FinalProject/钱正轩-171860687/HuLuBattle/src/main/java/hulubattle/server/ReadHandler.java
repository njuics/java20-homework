package hulubattle.server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;

import com.google.gson.Gson;

import hulubattle.game.model.CombatLog;
import hulubattle.game.model.LogConsumer;

/**
 * 用于处理异步读事件，将读到的字节解码为字符串后转换为 CombatLog 对象交由 Consumer 进一步处理，可以用在 server 端或是
 * client 端
 */
public class ReadHandler implements CompletionHandler<Integer, Void> {
    private static Gson gson = new Gson();
    private AsynchronousSocketChannel socket;
    private ByteBuffer buffer;
    private Optional<LogConsumer> consumer = Optional.empty();

    /**
     * 构造器
     *
     * @param socket channel
     * @param buffer 调用 read 时传入的 buffer
     */
    public ReadHandler(AsynchronousSocketChannel socket, ByteBuffer buffer) {
        this.socket = socket;
        this.buffer = buffer;
    }

    /**
     * 设置 consumer 对象
     *
     * @param consumer consumer
     */
    public void setConsumer(LogConsumer consumer) {
        this.consumer = Optional.ofNullable(consumer);
    }

    @Override
    public void completed(Integer result, Void attachment) {
        if (result == -1) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        buffer.flip();
        byte[] contexts = new byte[BattleTask.BUFFER_SIZE];
        buffer.get(contexts, 0, result);
        buffer.clear();
        String str = new String(contexts, 0, result, StandardCharsets.UTF_8);
        Arrays.asList(str.split(WriteHelper.DELIM)).forEach(s -> {
            if (s.length() > 0) {
                CombatLog log = gson.fromJson(s, CombatLog.class);
                consumer.ifPresent(c -> c.consume(log));
            }
        });
        socket.read(buffer, null, this);
    }

    @Override
    public void failed(Throwable exc, Void attachment) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}