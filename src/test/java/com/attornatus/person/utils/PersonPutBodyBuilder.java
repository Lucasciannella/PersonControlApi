package com.attornatus.person.utils;

import com.attornatus.person.dto.PersonPutBody;

public class PersonPutBodyBuilder {

    public static PersonPutBody createPutBody() {

        return new PersonPutBody(PersonBuilder.createValidPerson().getId(),
                PersonBuilder.createValidPerson().getName(),
                PersonBuilder.createValidPerson().getBirthDate());
    }
}