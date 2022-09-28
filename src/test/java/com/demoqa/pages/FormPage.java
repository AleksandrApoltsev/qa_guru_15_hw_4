package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormPage {

    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarPage calendarPage = new CalendarPage();
    private HobbiesPage hobbiesPage = new HobbiesPage();
    private ResultsModal resultsModal = new ResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail");

    public FormPage openPage (){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    public FormPage setFirstName (String value) {
        firstNameInput.setValue(value);

        return this;
    }
   public FormPage setLastName (String value) {
       lastNameInput.setValue(value);

        return this;
    }
   public FormPage setUserEmail (String value) {
       emailInput.setValue(value);

        return this;
    }

    public FormPage setGender (String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }
    public FormPage setUserNumber (String value) {
        $("#userNumber").setValue(value);

        return this;
    }
    public FormPage setSubjects (String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }
    public FormPage setBirthDay (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarPage.setDate(day, month, year);

        return this;
    }
    public FormPage setHobbiesWrapper (String value) {
        hobbiesPage.setHobbies(value);

        return this;

    }
    public FormPage setUploadPicture (String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }
    public FormPage setCurrentAddress (String value) {
        $("#currentAddress").setValue(value);

        return this;
    }
    public FormPage setState (String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }
    public FormPage setCity (String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }
    public FormPage setSubmit () {
        $("#submit").click();

        return this;
    }
    public FormPage checkResultsTableVisible () {
        resultsModal.checkVisible();

        return this;
    }
    public FormPage checkResult (String key, String value) {
        resultsModal.checkResult(key, value);

        return this;
    }
}
