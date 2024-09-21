import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private static final String FAMILY_NAME = "Кошачьи";
    private static final int DEFAULT_KITTENS_COUNT = 1;
    private static final int CUSTOM_KITTENS_COUNT = 5;
    private static final List<String> EXPECTED_FOOD = List.of("Животные", "Птицы", "Рыба");

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        assertEquals(EXPECTED_FOOD, feline.eatMeat());
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals(FAMILY_NAME, feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(DEFAULT_KITTENS_COUNT, feline.getKittens());
    }

    @Test
    public void testGetKittensWithCount() {
        Feline feline = new Feline();
        assertEquals(CUSTOM_KITTENS_COUNT, feline.getKittens(CUSTOM_KITTENS_COUNT));
    }
}
