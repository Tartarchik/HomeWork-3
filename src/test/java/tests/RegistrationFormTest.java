package tests;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.RegistrationPage;
import page.components.RegistrationModal;

import static io.qameta.allure.Allure.step;
import static tests.TestData.*;

@Tag("simple")
public class RegistrationFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationModal registrationModal = new RegistrationModal();

    @Test
    void registrationFormTest() {
        step("Заполняем форму", () -> {
            registrationPage.openPage()
                    .closeBanner()
                    .setFirstname(userFirstName)
                    .setLastname(userLastName)
                    .setUserEmail(userEmail)
                    .setGender(gender)
                    .setUserNumber(phone)
                    .setBirthDate(month, year, day)
                    .setSubject(subject)
                    .setHobby(hobby)
                    .setPicture(picture)
                    .setAddress(adress)
                    .setState(state)
                    .setCity(city)
                    .submit();
        });
        step("Проверяем форму", () -> {
            registrationModal.verifyModal("Thanks for submitting the form")
                    .verifyModalResult("Student Name", userFirstName + " " + userLastName)
                    .verifyModalResult("Student Email", userEmail)
                    .verifyModalResult("Gender", gender)
                    .verifyModalResult("Mobile", phone)
                    .verifyModalResult("Date of Birth", day + " " + month + "," + year)
                    .verifyModalResult("Subjects", subject)
                    .verifyModalResult("Hobbies", hobby)
                    .verifyModalResult("Picture", picture)
                    .verifyModalResult("Address", adress)
                    .verifyModalResult("State and City", state + " " + city);
        });

        registrationPage.clickClose();


    }

}
