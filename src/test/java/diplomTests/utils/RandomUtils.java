package diplomTests.utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class RandomUtils {

    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();

    }

    /*public static String getRandomPassword() {
        return getRandomString(7);
    }*/

    public static String getRandomGender() {
        String[] arr = {"male", "female"};
        int randIdx = ThreadLocalRandom.current().nextInt(arr.length);
        String randomElem = arr[randIdx];
        return randomElem;
    }
}

