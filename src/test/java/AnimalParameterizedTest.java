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
                {"Хищник", Arrays.asList("Животные", "Птицы", "Рыба")},
                {"Неизвестно", new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник")}
        });
    }

    @Test
    public void testGetFood() {
        Animal animal = new Animal();

        if (expectedResult instanceof Exception) {
            Exception exception = assertThrows(Exception.class, () -> animal.getFood(animalKind));
            assertEquals(((Exception) expectedResult).getMessage(), exception.getMessage());
        } else {
            try {
                assertEquals(expectedResult, animal.getFood(animalKind));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
