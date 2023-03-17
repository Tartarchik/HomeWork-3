package tests;


import org.junit.jupiter.api.Test;
import page.RegistrationPage;
import page.components.RegistrationModal;


public class RegistrationFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationModal registrationModal = new RegistrationModal();
    final private String userFirstName = "Qa";
    final private String userLastName = "Guru";


    @Test
    void registrationFormTest() {
        registrationPage.openPage()
                .closeBanner()
                .setFirstname(userFirstName)
                .setLastname(userLastName)
                .setUserEmail("qagutu@mail.com")
                .setGender("Female")
                .setUserNumber("9891111111")
                .setBirthDate("3", "2000", "12")
                .setSubject("Maths")
                .setHobby("Sports")
                .setPicture("pictures/Leo.jpg")
                .setAddress("Street")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .submit();

        registrationModal.verifyModal("Thanks for submitting the form")
                .verifyModalResult("Student Name", "Qa " + "Guru")
                .verifyModalResult("Student Email", "qagutu@mail.com")
                .verifyModalResult("Gender", "Female")
                .verifyModalResult("Mobile", "9891111111")
                .verifyModalResult("Date of Birth", "12 " + "April" + "," + "2000")
                .verifyModalResult("Subjects", "Maths")
                .verifyModalResult("Hobbies", "Sports")
                .verifyModalResult("Picture", "Leo.jpg")
                .verifyModalResult("Address", "Street")
                .verifyModalResult("State and City", "Uttar Pradesh " + "Agra");

        registrationPage.clickClose();

    }

}
