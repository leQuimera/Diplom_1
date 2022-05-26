package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Database database = new Database();

    int expectedBunsQuantity = 3;

    @Test
    public void availableBunsTest(){
        assertEquals(expectedBunsQuantity, database.availableBuns().size());
    }

    @Test
    public void availableIngredientsTest() {
        assertFalse(database.availableIngredients().isEmpty());
    }
}
