package demowebshopTests.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static demowebshopTests.tests.TestData.*;
import static demowebshopTests.tests.TestData.firstName;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DemowebshopTestsAPI {
    private final String verificationTokenName = "__RequestVerificationToken",
            verificationTokenBodyValue = "LqOzs7c0upXSl4WTWmfowWLW3jD3gBKuTggBCXY1MtimH_5jcviDHUgES9RucYtUFmn2dO3hwWYzd2tFeVLo3FfmsYWy9HlCFWHo0BaP2to1",
            verificationTokenHeaderValue = "pwwaoyt93b7WA8_NQn2UDoYPjglbpw8qoxqpjLckZgvj2IPZAa0SEJqUv9jPJ640EBKq3nYrN1UyAh5_QlCg7lT26v6lzJM74lLFjg9Ec101";
    @Test
    @DisplayName("Регистрация и изменение профиля через API")
    void registrationApi() {
        RestAssured.baseURI = "http://demowebshop.tricentis.com/";


        String authCookieName = "NOPCOMMERCE.AUTH";
        String authCookieValue = given()
                .when()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam(verificationTokenName, verificationTokenBodyValue)
                .formParam("FirstName", firstName)
                .formParam("LastName", lastName)
                .formParam("Email", email)
                .formParam("Password", password)
                .formParam("ConfirmPassword", password)
                .cookie(verificationTokenName, verificationTokenHeaderValue)
                .post(baseURI+"register")
                .then()
                .log().all()
                .extract()
                .cookie(authCookieName);

        open(baseURI + "Themes/DefaultClean/Content/images/logo.png");
        Cookie cookie = new Cookie(authCookieName, authCookieValue);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        open("https://demowebshop.tricentis.com/customer/info");
        $(".account").shouldHave(Condition.text(email));

        given()
                .when()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("FirstName", newFirstName)
                .formParam("LastName", newLastName)
                .post(baseURI+"customer/info")
                .then()
                .log().all();
        open("https://demowebshop.tricentis.com/customer/info");
        System.out.println(firstName);
    }
}
