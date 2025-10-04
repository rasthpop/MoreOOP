

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HobbitTest {

    private Demo.Hobbit character;

    @BeforeEach
    public void init() {
        character = new Demo.Hobbit();
    }

    @Test
    public void testToString() {
        assertEquals("Hobbit{hp=3, power=0}", character.toString());
    }

    @Test
    public void testIsClass() {
        assertTrue(character instanceof Demo.Character);
    }

    @Test
    public void testSetHp() {
        character.setHp(-100);
        assertEquals(0, character.getHp());
    }
}