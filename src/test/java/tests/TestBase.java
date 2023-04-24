package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import page.components.Attachments;

import java.util.concurrent.TimeUnit;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        Configuration.pageLoadTimeout = 100000;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterEach
    void attach(){
        Attachments.pageSource();
        Attachments.screenShot();
        Attachments.addConsoleLog();
        Attachments.addVideo();
    }


}
