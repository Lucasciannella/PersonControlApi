package com.attornatus.person.service;

import com.attornatus.person.dto.PersonPostBody;
import com.attornatus.person.dto.PersonPutBody;
import com.attornatus.person.exceptions.BadRequestException;
import com.attornatus.person.model.Person;
import com.attornatus.person.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person findByIdOrThrowBadRequestException(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new BadRequestException("Person is not discovered or not exists in database"));
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person save(PersonPostBody personPostBody) {
        var person = Person.builder()
                .name(personPostBody.getName())
                .birthDate(personPostBody.getBirthDate())
                .build();
        return personRepository.save(person);
    }

    public Person update(PersonPutBody personPutBody) {
        Person person = findByIdOrThrowBadRequestException(personPutBody.getId());

        Person personUpdated = Person.builder()
                .id(personPutBody.getId())
                .name(personPutBody.getName())
                .birthDate(personPutBody.getBirthDate())
                .build();
        return personRepository.save(personUpdated);
    }
}