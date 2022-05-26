package praktikum;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun testBun;
    Random random = new Random();
    Faker faker = Faker.instance();
    final String testBunName = faker.name().toString();
    final float testBunPrice = random.nextFloat();


    @Before
    public void setUp() {
        testBun = new Bun(testBunName, testBunPrice);
    }

    @Test
    public void getNameCheck() {
        String actual = testBun.getName();
        assertEquals(testBunName, actual);
    }

    @Test
    public void getPriceCheck() {
        float actual = testBun.getPrice();
        assertEquals(testBunPrice, actual, 0);
    }
}
