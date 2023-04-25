package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import page.components.Attachments;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = System.getProperty("browserSize","1920x1080");;
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion","100");
        Configuration.baseUrl = System.getProperty("baseUrl","https://demoqa.com");
        Configuration.remote = System.getProperty("remoteUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.pageLoadTimeout = 30000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void attach(){
        Attachments.pageSource();
        Attachments.screenShot();
        Attachments.addConsoleLog();
        Attachments.addVideo();
    }


}
