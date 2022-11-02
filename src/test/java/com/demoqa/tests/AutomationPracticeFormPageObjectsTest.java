package com.demoqa.tests;

import com.demoqa.pages.FormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AutomationPracticeFormPageObjectsTest extends TestBase {
    FormPage formPage = new FormPage();
    TestData testData = new TestData();


    @Test
    @DisplayName("Проверка формы")
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