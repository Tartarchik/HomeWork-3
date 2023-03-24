package tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestData {
    public static void main(String[] args) {
        System.out.println(phone);
    }

    public static Faker fakerEn = new Faker(new Locale("en"));
    public static Faker fakerRu = new Faker(new Locale("ru"));

    public static String userFirstName = fakerEn.name().firstName();
    public static String userLastName = fakerEn.name().lastName();
    public static String userEmail = fakerEn.internet().emailAddress();
    public static String gender = fakerEn.options().option("Male", "Female", "Other");
    public static String phone = fakerRu.phoneNumber().phoneNumber().replaceAll("\\+","")
            .replaceFirst("7","")
            .replaceAll("\\(","")
            .replaceAll("\\)","")
            .replaceAll("-","");
    public static String subject = fakerEn.options().option("English", "Physics", "Civics", "Chemistry");
    public static String hobby = fakerEn.options().option("Sports", "Reading", "Music");
    public static String picture = "Leo.jpg";
    public static String adress = fakerEn.address().fullAddress();


    public static Date strDate = fakerEn.date().birthday();
    public static String month = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(strDate);
    public static String year = new SimpleDateFormat("yyyy", Locale.ENGLISH).format(strDate);
    public static String day = new SimpleDateFormat("dd", Locale.ENGLISH).format(strDate);
    public static String state = fakerEn.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public static String city = city();

    public static String city() {
        if (state.equals("NCR")) {
            String city = fakerEn.options().option("Delhi", "Gurgaon", "Noida");
            return city;
        } else if (state.equals("Uttar Pradesh")) {
            String city = fakerEn.options().option("Agra", "Lucknow", "Merrut");
            return city;
        } else if (state.equals("Haryana")) {
            String city = fakerEn.options().option("Karnal", "Panipat");
            return city;
        } else if (state.equals("Rajasthan")) {
            String city = fakerEn.options().option("Jaipur", "Jaiselmer");
            return city;
        }
        return "";
    }
}
