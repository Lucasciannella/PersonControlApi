package com.attornatus.person.service;

import com.attornatus.person.dto.PersonPostBody;
import com.attornatus.person.dto.PersonPutBody;
import com.attornatus.person.exceptions.BadRequestException;
import com.attornatus.person.model.Person;
import com.attornatus.person.repository.PersonRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public Person save(PersonPostBody personPostBody) {
        var person = Person.builder()
                .name(personPostBody.name())
                .birthDate(personPostBody.birthDate())
                .build();
        return personRepository.save(person);
    }

    @Transactional
    public Person update(PersonPutBody personPutBody) {
        Person person = findByIdOrThrowBadRequestException(personPutBody.id());

        Person personUpdated = Person.builder()
                .id(personPutBody.id())
                .name(personPutBody.name())
                .birthDate(personPutBody.birthDate())
                .build();
        return personRepository.save(personUpdated);
    }
}