package com.attornatus.person.service;

import com.attornatus.person.dto.AddressPostBody;
import com.attornatus.person.exceptions.BadRequestException;
import com.attornatus.person.model.Address;
import com.attornatus.person.repository.AdressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdressService {

    private final PersonService personService;

    private final AdressRepository adressRepository;

    public Address findByIdOrThrowBadRequestException(Long id) {
        return adressRepository.findById(id).orElseThrow(() -> new BadRequestException("Adress is not discovered or not exists in database"));
    }

    @Transactional
    public Address saveAdress(Long id, AddressPostBody addressPostBody) {
        var person = personService.findByIdOrThrowBadRequestException(id);

        Address address = Address.builder()
                .cep(addressPostBody.cep())
                .numero(addressPostBody.numero())
                .localidade(addressPostBody.localidade())
                .logradouro(addressPostBody.logradouro())
                .person(person)
                .build();

        return adressRepository.save(address);
    }

    public List<Address> listAdressByPersonId(Long personId) {
        var person = personService.findByIdOrThrowBadRequestException(personId);

        return adressRepository.findAllByPersonId(person.getId());
    }

    @Transactional
    public Address setMainAdress(Long personid, Long adressId){
        var adress = findByIdOrThrowBadRequestException(adressId);
        var person = personService.findByIdOrThrowBadRequestException(personid);

        Address addressToUpdated = Address.builder()
                .id(adress.getId())
                .cep(adress.getCep())
                .logradouro(adress.getLogradouro())
                .localidade(adress.getLocalidade())
                .numero(adress.getNumero())
                .isMain(true)
                .build();

        return adressRepository.save(addressToUpdated);
    }
}