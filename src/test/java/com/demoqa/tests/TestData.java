package com.demoqa.tests;


import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = faker.demographic().sex();
    String number = faker.phoneNumber().subscriberNumber(10);
    String day = String.valueOf(faker.number().numberBetween(1, 30));
    String month = "June";
    String year = String.valueOf(faker.number().numberBetween(1900, 2010));
    String subjects = "English";
    String hobbies = "Sports";
    String picture = "1.jpg";
    String address = faker.address().fullAddress();
    String state = "NCR";
    String city = "Delhi";

}

