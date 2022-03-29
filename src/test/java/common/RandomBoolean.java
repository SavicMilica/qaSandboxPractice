package common;
import org.testng.annotations.Test;

import java.util.Random;

public class RandomBoolean {

    @Test
    public static boolean getRandomBoolean() {
        Random random = new Random();
        boolean automated = random.nextBoolean();
        return automated;
    }
}
