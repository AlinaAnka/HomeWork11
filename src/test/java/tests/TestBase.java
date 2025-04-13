package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
//import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @BeforeAll
    static void setupConfig() {

//        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

        Configuration.browser = System.getProperty("BROWSER");
        Configuration.browserVersion = System.getProperty("BROWSER_VERSION");
        Configuration.browserSize = System.getProperty("SCREEN_RESOLUTION");
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
        Configuration.remote = System.getProperty("selenoid_url");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        System.out.println("=== Параметры запуска ===");

    }

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

    private String remoteUrl() {
        return "https://"
                + System.getProperty("SELENOID_USER") + ":"
                + System.getProperty("SELENOID_PASSWORD") + "@"
                + System.getProperty("SELENOID_URL");
    }
}
