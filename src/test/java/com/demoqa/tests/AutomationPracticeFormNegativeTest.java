package com.demoqa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormNegativeTest extends TestBase {
    private final static String RED = "rgb(220, 53, 69)";

    @Test
    @DisplayName("Negative checking form")
    void formNegativeTest() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#submit").click();

        $("#firstName").shouldHave(cssValue("border-color", RED));
        $("#lastName").shouldHave(cssValue("border-color", RED));
        $("#userNumber").shouldHave(cssValue("border-color", RED));

    }
}
