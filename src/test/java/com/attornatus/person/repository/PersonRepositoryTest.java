package com.attornatus.person.repository;

import com.attornatus.person.model.Person;
import com.attornatus.person.utils.PersonBuilder;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@Log4j2
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    void save_PersistPerson_WhenSuccessful(){

        Person personToBeSaved = PersonBuilder.createPersonToBeSaved();

        Person person = personRepository.save(personToBeSaved);

        Assertions.assertEquals(person.getId(), personToBeSaved.getId());
        Assertions.assertEquals(person.getName(), personToBeSaved.getName());
        Assertions.assertEquals(person.getBirthDate(), personToBeSaved.getBirthDate());
    }

    @Test
    void Update_PersistPerson_WhenSuccessful(){

        Person personToBeSaved = PersonBuilder.createPersonToBeSaved();

        Person personSaved = personRepository.save(personToBeSaved);

        Person personUpdated = personRepository.save(personSaved);

        Assertions.assertEquals(personUpdated.getId(), personSaved.getId());
        Assertions.assertEquals(personUpdated.getName(), personSaved.getName());
        Assertions.assertEquals(personUpdated.getBirthDate(), personSaved.getBirthDate());
    }


    @Test
    void ListOfPersons_NotNull(){
        Person personToBeSaved = PersonBuilder.createPersonToBeSaved();

        Person personSaved = personRepository.save(personToBeSaved);

        List<Person> ListOfpersons = personRepository.findAll();

        Assertions.assertNotNull(ListOfpersons);
    }
}