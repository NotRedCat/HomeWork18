package diplomTests.tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DnsTests {

    MainPage mainPage = new MainPage();

    @Test
    void checkAddProductToWishlist() {
        mainPage
                .openWishList()
                .checkWishlistIsEmpty()
                .addProductInWishlist()
                .checkWishlistIsNotEmpty();
    }

    @Test
    void checkAuthWithWrongEmail() {
        mainPage.openMainPage();
        $(".user-profile__login").click();
        $(".user-profile__wrapper button").click();
        $(".auth-modal input").click();
        $(".auth-modal input").sendKeys("NoEmail");
        $$(".auth-modal button").find(text("Получить код")).click();
        $(".error-message-block").shouldHave(text("E-mail/телефон указан неверно"));
    }

    @Test
    void aboutCompanyShouldHaveText() {
        open("https://www.dns-shop.ru/about/about/");
        $(".about-dns__top-title")
                .shouldHave(text("DNS – один из лидеров рынка по продаже цифровой и бытовой техники в России"));
    }

    @Test
    void checkSmartSearch() {
        mainPage.openMainPage();
        $("#header-search input").hover().click();
        $("#header-search input").setValue("Sumsang");
        $$(".ui-input-search a").shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    @Test
    void checkClickLogo() {
        open("https://www.dns-shop.ru/catalog/17aa280216404e77/akkumulyatory-dlya-elektroinstrumentov/");
        executeJavaScript("$('.v-confirm-city').remove()");
        $(".logo").click();
        $(".homepage-actual-offers-main__title").shouldHave(text("Актуальные предложения"));
    }

    @Test
    void checkTheTransitionToVk() {
        mainPage.openMainPage();
        $(".social__vkontakte").click();
        switchTo().window(1);
        $(".page_name").shouldHave(text("Сеть магазинов DNS"));
    }
}

