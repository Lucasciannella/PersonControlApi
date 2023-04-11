package com.attornatus.person.utils;

import com.attornatus.person.dto.PersonPutBody;

public class PersonPutBodyBuilder {

    public static PersonPutBody createPutBody() {

        return PersonPutBody.builder()
                .id(PersonBuilder.createValidPerson().getId())
                .name(PersonBuilder.createValidPerson().getName())
                .birthDate(PersonBuilder.createValidPerson().getBirthDate())
                .build();
    }
}