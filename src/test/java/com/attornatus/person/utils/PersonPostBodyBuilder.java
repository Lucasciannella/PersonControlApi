package com.attornatus.person.utils;

import com.attornatus.person.dto.PersonPostBody;

public class PersonPostBodyBuilder {

    public static PersonPostBody createPostBody() {
        return new PersonPostBody(PersonBuilder.createValidPerson().getName(),
                PersonBuilder.createValidPerson().getBirthDate());
    }
}