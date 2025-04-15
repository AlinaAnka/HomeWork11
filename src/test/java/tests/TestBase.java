package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @BeforeAll
    static void setupConfig() {
        Configuration.browser = System.getProperty("browser");
        Configuration.browserVersion = System.getProperty("browser_version" );
        Configuration.browserSize = System.getProperty("screen_resolution");
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
        Configuration.remote = remoteUrl();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        System.out.println("=== Параметры запуска ===");
        System.out.println("browser: " + System.getProperty("browser"));
        System.out.println("browser_version: " + System.getProperty("browser_version"));
        System.out.println("screen_resolution: " + System.getProperty("screen_resolution"));
        System.out.println("remoteUrl: " + remoteUrl());

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

    static private String remoteUrl() {
        return "https://"
                + System.getProperty("selenoidUser") + ":"
                + System.getProperty("selenoidPassword") + "@"
                + System.getProperty("selenoid_url");
    }
}
