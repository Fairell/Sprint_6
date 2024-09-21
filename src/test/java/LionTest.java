import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

public class LionTest {

    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private static final String INVALID_SEX = "Неверный";
    private static final List<String> EXPECTED_FOOD = List.of("Животные", "Птицы", "Рыба");
    private static final int EXPECTED_KITTENS_COUNT = 3;

    private Feline felineMock;

    @Before
    public void setUp() {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    public void testDoesHaveManeForMaleLion() throws Exception {
        Lion lion = new Lion(MALE, felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testDoesNotHaveManeForFemaleLion() throws Exception {
        Lion lion = new Lion(FEMALE, felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        new Lion(INVALID_SEX, felineMock);
    }

    @Test
    public void testGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(EXPECTED_KITTENS_COUNT);
        Lion lion = new Lion(MALE, felineMock);
        assertEquals(EXPECTED_KITTENS_COUNT, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        when(felineMock.getFood("Хищник")).thenReturn(EXPECTED_FOOD);
        Lion lion = new Lion(MALE, felineMock);
        assertEquals(EXPECTED_FOOD, lion.getFood());
    }
}
