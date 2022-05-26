package praktikum;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient testIngredient;
    Random random = new Random();
    Faker faker = Faker.instance();

    final String ingredientName = faker.name().toString();
    final float ingredientPrice = random.nextFloat();
    final IngredientType ingredientType = IngredientType.SAUCE;

    @Before
    public void setUp() {
        testIngredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Test
    public void getPriceTest() {
        float actualPrice = testIngredient.getPrice();
        assertEquals(ingredientPrice, actualPrice, 0.0001F);
    }

    @Test
    public void getNameTest() {
        String actualName = testIngredient.getName();
        assertEquals(ingredientName, actualName);
    }

    @Test
    public void getTypeTest() {
        IngredientType actualType = testIngredient.getType();
        assertEquals(ingredientType.name(), actualType.name());
    }
}
