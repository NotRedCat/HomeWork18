package diplomTests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement
            emailInput = $("#office-auth-login-username"),
            passwordInput = $("#office-login-form-password"),
            authButton = $(".btn-primary");


    private final static String REGISTRATION_TITLE_TEXT = "Авторизация",
    PROFILE_TITLE_TEXT = "My account - Customer info";

    public RegistrationPage openRegisterPage() {
        open("https://ampero.ru/authorization.html");
        $(".office-auth-login-wrapper h4").shouldHave(text(REGISTRATION_TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }


    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }


    public RegistrationPage openProfilePage() {
            open("customer/info");
            $(".page-title").shouldHave(text(PROFILE_TITLE_TEXT));
            return this;
    }

    public RegistrationPage clickAuthButton() {
        authButton.click();
        return this;
    }



}
