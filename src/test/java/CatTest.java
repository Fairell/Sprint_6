import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CatTest {

    private static final String EXPECTED_SOUND = "Мяу";
    private static final List<String> EXPECTED_FOOD = List.of("Животные", "Птицы", "Рыба");

    private Feline felineMock;

    @Before
    public void setUp() {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    public void testGetSound() {
        Cat cat = new Cat(felineMock);
        assertEquals(EXPECTED_SOUND, cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        when(felineMock.eatMeat()).thenReturn(EXPECTED_FOOD);
        Cat cat = new Cat(felineMock);
        assertEquals(EXPECTED_FOOD, cat.getFood());
    }
}
