package com.attornatus.person.utils;

import com.attornatus.person.dto.PersonPostBody;

public class PersonPostBodyBuilder {

    public static PersonPostBody createPostBody(){
      return PersonPostBody.builder()
                .name(PersonBuilder.createValidPerson().getName())
                .birthDate(PersonBuilder.createValidPerson().getBirthDate())
                .build();
    }
}