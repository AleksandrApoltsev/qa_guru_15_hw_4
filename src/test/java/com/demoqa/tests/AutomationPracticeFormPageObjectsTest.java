package com.demoqa.tests;


import com.codeborne.selenide.Configuration;
import com.demoqa.pages.FormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class AutomationPracticeFormPageObjectsTest {
    FormPage formPage = new FormPage();

    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void formTest() {
        formPage.openPage()
                .setFirstName("Aleksandr")
                .setLastName("Apoltsev")
                .setUserEmail("apoltsev@mail.ru")
                .setGender("Male")
                .setUserNumber("9876543210")
                .setBirthDay("08", "June", "1992")
                .setSubjects("English")
                .setHobbiesWrapper("Sports")
                .setHobbiesWrapper("Reading")
                .setUploadPicture("1.jpg")
                .setCurrentAddress("City Street 123456")
                .setState("NCR")
                .setCity("Delhi")
                .setSubmit();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Aleksandr Apoltsev"),
                text("apoltsev@mail.ru"),
                text("Male"),
                text("9876543210"),
                text("08 June,1992"),
                text("English"),
                text("Sports"),
                text("Reading"),
                text("1.jpg"),
                text("City Street 123456"),
                text("NCR Delhi"));

    }
}