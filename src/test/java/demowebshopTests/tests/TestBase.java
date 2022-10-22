package demowebshopTests.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import demowebshopTests.config.DriverConfig;
import demowebshopTests.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.Map;


public class TestBase {

    @BeforeAll
    static void configure() throws MalformedURLException {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.browserCapabilities = capabilities;
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        System.setProperty("properties","remote");
        DriverConfig config = ConfigFactory.create(DriverConfig.class,System.getProperties());

        if (System.getProperty("remote_url") != null) {

            capabilities.setCapability("browserName", config.getBrowser());
            capabilities.setCapability("baseURI", config.getBaseURI());
            Configuration.browserSize = config.getBrowserSize();
            Configuration.remote = System.getProperty("remote_url");
            Configuration.baseUrl = config.getBaseUrl();
            Configuration.browserVersion= config.getBrowserVersion();
        } else {
            capabilities.setCapability("browserName", config.getBrowser());
            capabilities.setCapability("browserVersion", config.getBrowserVersion());
            Configuration.browserSize = config.getBrowserSize();


        }
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotsAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}