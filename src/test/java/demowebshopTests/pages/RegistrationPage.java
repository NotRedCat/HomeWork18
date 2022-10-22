package demowebshopTests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import demowebshopTests.tests.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement
            firstNameInput = $("#FirstName"),

    lastNameInput = $("#LastName"),
            emailInput = $("#Email"),
            passwordInput = $("#Password"),
            confirmPasswordInput = $("#ConfirmPassword"),
            registerButton = $("#register-button"),
            profileButton = $(".account"),
            saveButton = $("[value=\"Save\"]");


    private final static String REGISTRATION_TITLE_TEXT = "Register",
            PROFILE_TITLE_TEXT = "My account - Customer info";

    public RegistrationPage openRegisterPage() {
        open("register");
        $(".page-title").shouldHave(text(REGISTRATION_TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage setGender(String gender) {
        $("#gender-" + TestData.gender).click();
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
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

    public RegistrationPage setConfirmPassword(String confirmPassword) {
        confirmPasswordInput.setValue(confirmPassword);
        return this;
    }

    public RegistrationPage clickRegisterButton() {
        registerButton.click();
        return this;
    }

    public RegistrationPage checkRegistration(String email) {
        $(".account").shouldHave(Condition.text(email));
        return this;
    }

    public RegistrationPage openProfilePage() {
        open("customer/info");
        $(".page-title").shouldHave(text(PROFILE_TITLE_TEXT));
        return this;
    }

    public RegistrationPage clickSaveButton() {
        saveButton.click();
        return this;
    }

    public RegistrationPage checkUpdatedUser(String newFirstName, String newLastName) {
        firstNameInput.shouldHave(Condition.value(newFirstName));
        lastNameInput.shouldHave(Condition.value(newLastName));
        return this;
    }

}
