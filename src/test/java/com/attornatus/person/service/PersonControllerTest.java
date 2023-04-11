package com.attornatus.person.service;

import com.attornatus.person.controller.PersonController;
import com.attornatus.person.dto.PersonPostBody;
import com.attornatus.person.model.Person;
import com.attornatus.person.utils.PersonBuilder;
import com.attornatus.person.utils.PersonPostBodyBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PersonControllerTest {

    @InjectMocks
    PersonController personController;

    @Mock
    PersonService personService;


    @BeforeEach
    void setUp() {

        BDDMockito.when(personService.save(ArgumentMatchers.any(PersonPostBody.class))).thenReturn(PersonBuilder.createValidPerson());

    }


    @Test
    void save_WhenSuccessful() {

        Person personToBeSaved = PersonBuilder.createValidPerson();

        var personSaved = personController.save(PersonPostBodyBuilder.createPostBody()).getBody();

        Assertions.assertThat(personSaved).isNotNull();
        Assertions.assertThat(personSaved.getId()).isEqualTo(personToBeSaved.getId());
    }

}