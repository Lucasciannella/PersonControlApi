package com.attornatus.person.service;

import com.attornatus.person.controller.PersonController;
import com.attornatus.person.dto.PersonPostBody;
import com.attornatus.person.dto.PersonPutBody;
import com.attornatus.person.model.Person;
import com.attornatus.person.utils.PersonBuilder;
import com.attornatus.person.utils.PersonPostBodyBuilder;
import com.attornatus.person.utils.PersonPutBodyBuilder;
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

        BDDMockito.when(personService.update(ArgumentMatchers.any(PersonPutBody.class))).thenReturn(PersonBuilder.createValidPerson());

        BDDMockito.when(personService.findByIdOrThrowBadRequestException(ArgumentMatchers.anyLong())).thenReturn(PersonBuilder.createValidPerson());

    }

    @Test
    void save_WhenSuccessful() {

        Person personToBeSaved = PersonBuilder.createValidPerson();

        Person personSaved = personController.save(PersonPostBodyBuilder.createPostBody()).getBody();

        Assertions.assertThat(personSaved).isNotNull();
        Assertions.assertThat(personSaved.getId()).isEqualTo(personToBeSaved.getId());
        Assertions.assertThat(personSaved.getName()).isEqualTo(personToBeSaved.getName());
        Assertions.assertThat(personSaved.getBirthDate()).isEqualTo(personToBeSaved.getBirthDate());
    }

    @Test
    void update_WhenSuccessful() {
        Person personToBeUpdated = PersonBuilder.createValidPerson();

        Person personUpdated = personController.update(PersonPutBodyBuilder.createPutBody()).getBody();

        Assertions.assertThat(personUpdated).isNotNull();
        Assertions.assertThat(personUpdated.getId()).isEqualTo(personToBeUpdated.getId());
        Assertions.assertThat(personUpdated.getName()).isEqualTo(personToBeUpdated.getName());
        Assertions.assertThat(personUpdated.getBirthDate()).isEqualTo(personToBeUpdated.getBirthDate());
    }

    @Test
    void findById_ReturnsAdressWhenSuccessful() {
        var expectedPerson = PersonBuilder.createValidPerson();
        var person = personController.getPersonByid(1L).getBody();

        Assertions.assertThat(person).isNotNull();
        Assertions.assertThat(person.getId()).isEqualTo(expectedPerson.getId());
        Assertions.assertThat(person.getName()).isNotNull().isEqualTo(expectedPerson.getName());
    }
}