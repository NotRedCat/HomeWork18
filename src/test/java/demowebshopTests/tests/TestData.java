package demowebshopTests.tests;

import com.github.javafaker.Faker;

import static demowebshopTests.utils.RandomUtils.getRandomGender;

    public class TestData {
         static Faker faker = new Faker();
        public static String
                firstName = faker.name().firstName(),
                newFirstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                newLastName = faker.name().firstName(),
                email = faker.internet().emailAddress(),
                password = faker.internet().password(),
                gender = getRandomGender();

        /*public  static String verificationTokenName = "__RequestVerificationToken";
        public  static String verificationTokenBodyValue = "k7V_vLOxOlQGW4Ltv_WzNm4e"
                + "6TFMaSmMdUXYTg8OUuTfNLoqjVLUm6NpH0DTERdTkt"
                + "_kjU-yXyADeQHhrcgDjvRZaitYAtiJZLHgVGKA74A1";
        public  static String verificationTokenHeaderValue = "_d9Tz4B3vP8uvyARS5wgF7vDgzD"
                + "ohzT5ZxEn4f8KpCzPwUqDwVlAF2rlI60Tr8vbsU"
                + "cfQOibiNMbfbvOQGBVMYrGDpljlE8m9HbfvXYHS501;";
        public static String authCookieName = "NOPCOMMERCE.AUTH";*/

    }

