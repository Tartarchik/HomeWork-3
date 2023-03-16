package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import page.RegistrationPage;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        //browserName: 'Firefox';
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
