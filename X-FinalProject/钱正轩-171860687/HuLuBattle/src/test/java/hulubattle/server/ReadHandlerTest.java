package hulubattle.server;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import hulubattle.game.model.CombatLog;
import hulubattle.game.model.LogConsumer;

public class ReadHandlerTest {

    private AutoCloseable closeable;

    @Mock
    private LogConsumer consumer;

    @Mock
    private AsynchronousSocketChannel socket;

    private ByteBuffer buffer;
    private ReadHandler handler;
    private static Gson gson = new Gson();

    @Before
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        buffer = ByteBuffer.allocate(BattleTask.BUFFER_SIZE);
        handler = new ReadHandler(socket, buffer);
        handler.setConsumer(consumer);
    }

    @Test
    public void testReadCompleted() {
        byte[] bytes = gson.toJson(CombatLog.move(0, 1, 1)).getBytes(StandardCharsets.UTF_8);
        buffer.put(bytes);
        handler.completed(bytes.length, null);
        verify(consumer, times(1)).consume(CombatLog.move(0, 1, 1));
        verify(socket, times(1)).read(buffer, null, handler);
    }

    @Test(expected = Test.None.class)
    public void testReadFailed() throws IOException {
        handler.failed(null, null);
        verify(socket, times(1)).close();
    }

    @Test
    public void testSocketClosed() throws IOException {
        handler.completed(-1, null);
        verify(socket, times(1)).close();
    }

    @Test
    public void testThrows() throws IOException {
        doThrow(IOException.class).when(socket).close();
        handler.completed(-1, null);
        handler.failed(null, null);
        verify(socket, times(2)).close();
    }

    @After
    public void clean() throws Exception {
        closeable.close();
    }
}
