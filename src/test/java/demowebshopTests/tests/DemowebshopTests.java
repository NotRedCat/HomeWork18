package demowebshopTests.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import demowebshopTests.helpers.Attach;
import demowebshopTests.pages.RegistrationPage;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static demowebshopTests.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class DemowebshopTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "http://demowebshop.tricentis.com/";
        RestAssured.baseURI = "http://demowebshop.tricentis.com/";
    }

    @Test
    void registrationUI() {
        step("Открытие страницы регистрации", () ->
        {
            registrationPage
                    .openRegisterPage();
        });
        step("Заполнение полей сгенерированными данными и отправка формы", () ->
        {
        registrationPage
                    .setGender(gender)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setPassword(password)
                    .setConfirmPassword(password)
                    .clickRegisterButton();
        });
        step("Проверка, что емайл совпадает", () ->
        {
            registrationPage
                    .checkRegistration(email);
        });
        step("Открытие страницы профиля", () ->
        {
            registrationPage
                    .openProfilePage();
        });
        step("Изменение имени и фамилии пользователя", () ->
        {
            registrationPage
                    .setFirstName(newFirstName)
                    .setLastName(newLastName)
                    .clickSaveButton();
        });
        step("Проверка,что данные изменились", () ->
        {
            registrationPage
                    .checkUpdatedUser(newFirstName, newLastName)
            ;
        });
            Attach.screenshotsAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            if (System.getProperty("remote_url") != null) {
                Attach.addVideo();
            }
            Selenide.closeWebDriver();

        }


}


