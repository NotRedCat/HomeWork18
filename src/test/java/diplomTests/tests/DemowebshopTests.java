package diplomTests.tests;

import com.codeborne.selenide.Configuration;
import diplomTests.pages.RegistrationPage;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static com.codeborne.selenide.Selenide.open;
import static diplomTests.tests.TestData.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
public class DemowebshopTests extends TestBase {
    private final String verificationTokenName = "__RequestVerificationToken",
            verificationTokenBodyValue = "LqOzs7c0upXSl4WTWmfowWLW3jD3gBKuTggBCXY1MtimH_5jcviDHUgES9RucYtUFmn2dO3hwWYzd2tFeVLo3FfmsYWy9HlCFWHo0BaP2to1",
            verificationTokenHeaderValue = "pwwaoyt93b7WA8_NQn2UDoYPjglbpw8qoxqpjLckZgvj2IPZAa0SEJqUv9jPJ640EBKq3nYrN1UyAh5_QlCg7lT26v6lzJM74lLFjg9Ec101";
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "http://demowebshop.tricentis.com/";
        RestAssured.baseURI = "http://demowebshop.tricentis.com/";
    }

@Test
    void registrationUIAndApi(){
    step("Создание пользователя чере запрос", () ->
    {
        registrationApi();
    });
        step("Создание пользователя чере запрос", () ->
        {
registrationPage.openRegisterPage()
        .setEmail(email)
        .setPassword(password)
        .clickAuthButton();
    });

}


    void registrationApi() {
        String body = "email=" + email+
                        "&password=" +password+
                        "&username=" +firstName+
                        "&fullname="+firstName+" "+lastName+
                        "&action=auth%2FformRegister"+
                         "&pageId=3089";

        given()
                .log().uri()
                .log().body()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body(body)
                .when()
                .post("https://ampero.ru/assets/components/office/action.php")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);

        open("https://ampero.ru/images/logo.jpeg");
        open("https://ampero.ru/authorization.html");

    }

    @Test
    void CardUIAndApi(){
        step("Создание пользователя чере запрос", () ->
        {
            CardApi();
        });
        step("Создание пользователя чере запрос", () ->
        {
            registrationPage.openRegisterPage()
                    .setEmail(email)
                    .setPassword(password)
                    .clickAuthButton();
        });

    }


    void CardApi() {

        given()
                .log().uri()
                .log().body()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .when()
                .post("https://ampero.ru/assets/components/office/action.php")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);

        open("https://ampero.ru/images/logo.jpeg");
        open("https://ampero.ru/authorization.html");

    }

}


