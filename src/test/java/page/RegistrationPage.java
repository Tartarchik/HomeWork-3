package page;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.LogType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import page.components.CalendarComponent;
import tests.TestBase;

import java.sql.DriverManager;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;

public class RegistrationPage extends TestBase {
    CalendarComponent calendarComponent = new CalendarComponent();
    final private SelenideElement firstName = $("#firstName");
    final private SelenideElement lastName = $("#lastName");
    final private SelenideElement userEmail = $("#userEmail");
    final private SelenideElement genderWrapper = $("#genterWrapper");
    final private SelenideElement userNumber = $("#userNumber");
    final private SelenideElement subject = $("#subjectsInput");
    final private SelenideElement hobbies = $("#hobbiesWrapper");
    final private SelenideElement picture = $("#uploadPicture");
    final private SelenideElement address = $("#currentAddress");
    final private SelenideElement state = $("#state");
    final private SelenideElement city = $("#city");

    private SelenideElement birthDay = $("#dateOfBirthInput");

    private SelenideElement submit = $("#submit");
    private SelenideElement closeButton = $("#closeLargeModal");

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");

        return this;
    }

    public RegistrationPage closeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstname(String value) {
        firstName.setValue(value);

        return this;
    }

    public RegistrationPage setLastname(String value) {
        lastName.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmail.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subject.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPicture(String value) {
        picture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        address.setValue(value).click();

        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        state.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        city.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setBirthDate(String month, String year, String day) {
        birthDay.click();
        calendarComponent.setCalendar(month, year, day);

        return this;
    }

    public void submit() {
        submit.click();;
    }

    public void clickClose() {
        closeButton.click();
    }

}
