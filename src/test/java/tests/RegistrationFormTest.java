package tests;


import org.junit.jupiter.api.Test;
import page.RegistrationPage;
import page.components.RegistrationModal;

import static tests.TestData.*;


public class RegistrationFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationModal registrationModal = new RegistrationModal();


    @Test
    void registrationFormTest() {
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

        registrationPage.clickClose();

    }

}
