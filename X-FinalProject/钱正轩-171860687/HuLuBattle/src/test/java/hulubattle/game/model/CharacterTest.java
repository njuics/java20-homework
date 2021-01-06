package hulubattle.game.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InOrder;

import hulubattle.game.data.AbstractCharacterData;
import hulubattle.game.data.DataSupplier;
import hulubattle.game.data.JsonDataSupplier;
import hulubattle.game.data.SimpleCharacterData;
import hulubattle.game.model.AbstractCharacter.CharacterHurtHandler;
import hulubattle.game.model.AbstractCharacter.CharacterMoveHandler;

public class CharacterTest {
    private static String characterJson = "[{\"id\":1,\"name\":\"枪兵\",\"hp\":100,\"def\":20,\"mobility\":2,\"skillList\":[1]},{\"id\":2,\"name\":\"骑兵\",\"hp\":100,\"def\":10,\"mobility\":3,\"skillList\":[2]}]";
    private static DataSupplier<AbstractCharacterData> supplier = new JsonDataSupplier<>(SimpleCharacterData.class,
            characterJson);
    private static AbstractCharacter c1, c2;

    @BeforeClass
    public static void setUp() {
        c1 = AbstractCharacter.getDefault(1, supplier.get(1).get(), 1, 1, 0);
        c2 = AbstractCharacter.getDefault(2, supplier.get(2).get(), 2, 1, 1);
    }

    @Test
    public void testDistance() {
        c1.moveTo(1, 2);
        c2.moveTo(7, 9);
        assertEquals(13, c1.distance(c2));
        assertEquals(c1.distance(c2), c2.distance(c1));
    }

    @Test
    public void testIsHarm() {
        assertTrue(c1.isHarm(c2));
    }

    @Test
    public void testHurt() {
        CharacterHurtHandler handler = mock(CharacterHurtHandler.class);
        InOrder inOrder = inOrder(handler);
        c1.setHurtHandler(handler);
        c1.hurt(40);
        c1.hurt(120);
        c1.hurt(-300);
        inOrder.verify(handler).handle(1, 60);
        inOrder.verify(handler).handle(1, 0);
        inOrder.verify(handler).handle(1, 100);
    }

    @Test
    public void testMove() {
        CharacterMoveHandler handler = mock(CharacterMoveHandler.class);
        c1.setMoveHandler(handler);
        c1.moveTo(3, 9);
        verify(handler).handle(1, 3, 9);
    }
}
