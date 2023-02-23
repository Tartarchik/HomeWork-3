import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        //browserName: 'Firefox';
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Qa");
        $("#lastName").setValue("Guru");
        $("#userEmail").setValue("qagutu@mail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9891111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("3");
        $(".react-datepicker__year-select").selectOptionByValue("2006");
        $(".react-datepicker__month-container").$(byText("10")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("pictures/Leo.jpg");
        $("#currentAddress").setValue("Street").click();
        $("#state").click();
        $("#state").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#city").$(byText("Agra")).click();
        $("#submit").click();

        $(".modal-open").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Qa Guru"));
        $(".modal-body").shouldHave(text("qagutu@mail.com"));
        $(".modal-body").shouldHave(text("Female"));
        $(".modal-body").shouldHave(text("9891111111"));
        $(".modal-body").shouldHave(text("10 April,2006"));
        $(".modal-body").shouldHave(text("Maths"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("Leo.jpg"));
        $(".modal-body").shouldHave(text("Street"));
        $(".modal-body").shouldHave(text("Uttar Pradesh Agra"));
        $("#closeLargeModal").click();
    }

}
