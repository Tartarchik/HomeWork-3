package tests;


import org.junit.jupiter.api.Test;
import page.RegistrationPage;


public class RegistrationFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void registrationFormTest() {
        registrationPage.openPage()
                .setFirstname("Qa")
                .setLastname("Guru")
                .setUserEmail("qagutu@mail.com")
                .setGender("Female")
                .setuserNumber("9891111111")
                .setBirthDate("3", "2000", "12")
                .setSubject("Maths")
                .setHobbies("Sports")
                .setPicture("pictures/Leo.jpg")
                .setAddress("Street")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .submit();

        registrationPage.verifModal("Thanks for submitting the form")
                .verifRegResultModal("Student Name", "Qa " + "Guru")
                .verifRegResultModal("Student Email", "qagutu@mail.com")
                .verifRegResultModal("Gender", "Female")
                .verifRegResultModal("Mobile", "9891111111")
                .verifRegResultModal("Date of Birth", "12 " + "April" + "," + "2000")
                .verifRegResultModal("Subjects", "Maths")
                .verifRegResultModal("Hobbies", "Sports")
                .verifRegResultModal("Address", "Street")
                .verifRegResultModal("State and City", "Uttar Pradesh " + "Agra")
                .clickClose();

    }

}
