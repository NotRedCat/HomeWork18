package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final static String TITLE_TEXT = "Актуальные предложения";



    public MainPage openMainPage() {
        open("https://www.dns-shop.ru");
        $(".homepage-actual-offers-main__title").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('.v-confirm-city').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
    public MainPage openWishList() {
        open("https://www.dns-shop.ru/profile/wishlist/");
        return this;
    }
    public MainPage clickWishlist() {
        $(".wishlist-link__lbl").click();
        return this;
    }
    public MainPage checkWishlistIsEmpty() {
        String emptyWishlistText = "В списке пока нет ни одного избранного товара";
        $(".profile-wishlist__empty-text").shouldHave(text(emptyWishlistText));
        return this;
    }
    public MainPage checkWishlistIsNotEmpty() {
        $(".wishlist-link__badge").shouldHave(text("1"));
        return this;
    }
    public MainPage addProductInWishlist() {
        open("https://www.dns-shop.ru/catalog/17a8a05316404e77/planshety/");
        $$("div.catalog-product a").first().click();
        $(".wishlist-btn").click();
        return this;
    }
}
