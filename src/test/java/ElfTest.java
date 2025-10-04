import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElfTest {

    private Demo.Character character;

    @BeforeEach
    public void init() {
        character = new Demo.Elf();
    }

    @Test
    public void testToString(){ assertEquals("Elf{hp=10, power=10}", character.toString());
    }

    @Test
    public void testKick() {
        Demo.Hobbit hobbit = new Demo.Hobbit();
        character.kick(hobbit);
        assertEquals(0, hobbit.getHp());
    }
}

