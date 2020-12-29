package hulubattle.client;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import hulubattle.client.model.GameClient;
import hulubattle.game.model.CombatLog;
import hulubattle.game.model.LogConsumer;
import hulubattle.server.GameServer;

public class ClientTest {
    private GameServer server;
    private GameClient clientA;
    private GameClient clientB;
    private AutoCloseable closeable;

    @Mock
    private LogConsumer consumerA;

    @Mock
    private LogConsumer consumerB;

    @Captor
    private ArgumentCaptor<CombatLog> captor;

    @Before
    public void setup() throws IOException {
        closeable = MockitoAnnotations.openMocks(this);
        server = new GameServer();
        clientA = new GameClient(consumerA);
        clientB = new GameClient(consumerB);

        server.accept();
        clientA.connect();
        clientB.connect();
    }

    @Test
    public void testGameStart() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        verify(consumerA, times(5)).consume(captor.capture());
        assertEquals("SET", captor.getValue().type);
    }

    @Test
    public void testWrite() throws InterruptedException {
        clientA.write(CombatLog.destroy(0));
        TimeUnit.SECONDS.sleep(2);
        verify(consumerA, times(6)).consume(captor.capture());
        assertEquals("ERROR", captor.getValue().type);
    }

    @After
    public void clean() throws Exception {
        clientA.close();
        clientB.close();
        server.close();
        closeable.close();
    }
}
