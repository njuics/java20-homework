package hulubattle.game.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GameTest {
    private Game game;
    private AutoCloseable closeable;

    @Mock
    private GameDelegate delegate;


    @Captor
    private ArgumentCaptor<CombatLog> captor;

    @Before
    public void setup() throws URISyntaxException, IOException {
        closeable = MockitoAnnotations.openMocks(this);
        game = new Game();
        game.setDelegate(delegate);
        game.setUp();
    }

    @After
    public void clean() throws Exception {
        closeable.close();
    }

    @Test(expected = Test.None.class)
    public void testCreate() throws URISyntaxException, IOException {
        new Game();
    }

    @Test
    public void testSetUp() {
        verify(delegate, times(4)).sendLog(captor.capture());

        assertEquals("SET", captor.getValue().type);

        verify(delegate).sendLog(captor.capture(), any(CombatLog.class));
        assertEquals(CombatLog.info("A"), captor.getValue());
    }

    @Test
    public void testWrongLogType() {
        game.consume(CombatLog.destroy(1));
        verify(delegate, times(5)).sendLog(captor.capture());

        assertEquals("ERROR", captor.getValue().type);
    }

    @Test
    public void testIllegalSrc() {
        game.consume(CombatLog.move(4, 3, 5));
        game.consume(CombatLog.move(2, 6, 5));
        verify(delegate, times(6)).sendLog(captor.capture());

        assertEquals("ERROR", captor.getValue().type);
    }

    @Test
    public void testIllegalMove() {
        game.consume(CombatLog.move(0, -1, 10));
        game.consume(CombatLog.move(0, 3, 6));
        game.consume(CombatLog.move(0, 3, 7));

        verify(delegate, times(7)).sendLog(captor.capture());

        assertEquals("ERROR", captor.getValue().type);
    }

    @Test
    public void testIllegalDest() {
        game.consume(CombatLog.cast(0, 4, 0));
        game.consume(CombatLog.cast(0, 3, 3));

        verify(delegate, times(6)).sendLog(captor.capture());

        assertEquals("ERROR", captor.getValue().type);
    }

    @Test
    public void testIllegalCast() {
        game.consume(CombatLog.cast(0, 3, 1));
        game.consume(CombatLog.cast(0, 1, 0));
        game.consume(CombatLog.cast(0, 2, 0));

        verify(delegate, times(7)).sendLog(captor.capture());

        assertEquals("ERROR", captor.getValue().type);
    }

    @Test
    public void testMove() {
        game.consume(CombatLog.move(0, 3, 3));
        verify(delegate, times(5)).sendLog(captor.capture());

        assertEquals(CombatLog.move(0, 3, 3), captor.getValue());
    }

    @Test
    public void testCast() {
        game.consume(CombatLog.cast(0, 3, 0));
        verify(delegate, times(6)).sendLog(captor.capture());

        assertEquals(CombatLog.hurt(3, 50), captor.getValue());
    }

    @Test
    public void testDestroy() {
        game.consume(CombatLog.cast(0, 3, 0));
        game.consume(CombatLog.skip(1));
        game.consume(CombatLog.cast(0, 3, 0));

        verify(delegate, times(10)).sendLog(captor.capture());

        assertEquals(CombatLog.destroy(3), captor.getValue());
    }

    @Test
    public void testEnd() {
        game.consume(CombatLog.cast(0, 3, 0));
        game.consume(CombatLog.skip(1));
        game.consume(CombatLog.cast(0, 3, 0));
        game.consume(CombatLog.skip(1));
        game.consume(CombatLog.move(1, 5, 4));
        game.consume(CombatLog.cast(1, 2, 1));
        game.consume(CombatLog.skip(1));
        game.consume(CombatLog.cast(1, 2, 1));
        game.consume(CombatLog.skip(1));
        game.consume(CombatLog.cast(1, 2, 1));
        game.consume(CombatLog.skip(1));
        game.consume(CombatLog.cast(1, 2, 1));
        game.consume(CombatLog.skip(1));

        verify(delegate, times(2)).sendLog(captor.capture(), any(CombatLog.class));

        assertEquals(CombatLog.info("游戏胜利"), captor.getValue());
    }
}
