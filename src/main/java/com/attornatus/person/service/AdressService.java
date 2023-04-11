package com.attornatus.person.service;

import com.attornatus.person.dto.AdressPostBody;
import com.attornatus.person.exceptions.BadRequestException;
import com.attornatus.person.model.Adress;
import com.attornatus.person.model.Person;
import com.attornatus.person.repository.AdressRepository;
import com.attornatus.person.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdressService {

    private final PersonService personService;

    private final AdressRepository adressRepository;

    private final PersonRepository personRepository;

    public Adress saveAdress(Long id, AdressPostBody adressPostBody) {
        var person = personService.findByIdOrThrowBadRequestException(id);

        Adress adress = Adress.builder()
                .cep(adressPostBody.getCep())
                .numero(adressPostBody.getNumero())
                .localidade(adressPostBody.getLocalidade())
                .logradouro(adressPostBody.getLogradouro())
                .person(person)
                .build();

        return adressRepository.save(adress);
    }

    public List<Adress> listAdress(Long personId) {
        var person = personService.findByIdOrThrowBadRequestException(personId);

        return adressRepository.findAllByPersonId(person.getId());
    }


    public Adress setMainAdress(Long personId, Long adressId) {

        Person person = personService.findByIdOrThrowBadRequestException(personId);

        Adress adress = adressRepository.findById(adressId).orElseThrow(() -> new BadRequestException("deu ruim"));

        if (!adress.getPerson().equals(person)) {
            throw new BadRequestException(" enderço e pessoa nao correspondem");
        }
        person.setAdress(adress);
        personRepository.save(person);
        return adress;
    }
}