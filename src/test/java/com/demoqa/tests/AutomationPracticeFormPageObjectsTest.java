package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.FormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormPageObjectsTest extends TestBase {
    FormPage formPage = new FormPage();
    TestData testData = new TestData();


    @Test
    void formTest() {
        formPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.number)
                .setBirthDay(testData.day, testData.month, testData.year)
                .setSubjects(testData.subjects)
                .setHobbiesWrapper(testData.hobbies)
                .setUploadPicture(testData.picture)
                .setCurrentAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .setSubmit();

        formPage.checkResultsTableVisible()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.number)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);

    }
}