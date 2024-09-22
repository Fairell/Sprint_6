import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {

    private final String animalKind;
    private final Object expectedResult;

    public AnimalParameterizedTest(String animalKind, Object expectedResult) {
        this.animalKind = animalKind;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Травоядное", Arrays.asList("Трава", "Различные растения")},
                {"Хищник", Arrays.asList("Животные", "Птицы", "Рыба")}
        });
    }

    @Test
    public void testGetFoodValidAnimals() throws Exception {
        Animal animal = new Animal();
        assertEquals(expectedResult, animal.getFood(animalKind));
    }

    @Test
    public void testGetFoodInvalidAnimalThrowsException() {
        Animal animal = new Animal();
        String invalidAnimalKind = "Неизвестно";
        Exception exception = assertThrows(Exception.class, () -> animal.getFood(invalidAnimalKind));
        String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        assertEquals(expectedMessage, exception.getMessage());
    }
}
