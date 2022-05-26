package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    Burger burger = new Burger();


    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        burger.moveIngredient(0, 1);
        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(20.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(100.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = 140.0f;
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.001f);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200.0f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("sour cream");
        Mockito.when(ingredient.getPrice()).thenReturn(200.0f);

        assertFalse(burger.getReceipt().isEmpty());
    }

}
