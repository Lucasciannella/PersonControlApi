package com.attornatus.person.utils;

import com.attornatus.person.model.Person;

import java.time.LocalDate;

public class PersonBuilder {

    public static Person createValidPerson() {
        return Person.builder()
                .id(1L)
                .name("Lucas")
                .birthDate(LocalDate.of(1999, 11, 04))
                .build();
    }

    public static Person createPersonToBeSaved() {
        return Person.builder()
                .name("Lucas")
                .birthDate(LocalDate.of(1999, 11, 04))
                .build();
    }
}