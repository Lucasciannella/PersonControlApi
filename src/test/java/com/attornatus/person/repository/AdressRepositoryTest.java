package com.attornatus.person.repository;

import com.attornatus.person.model.Address;
import com.attornatus.person.utils.AdressBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AdressRepositoryTest {

    @Autowired
    AdressRepository adressRepository;

    @Test
    void save_persistAdress_WhenSuccessful() {

        Address addressToBeSaved = AdressBuilder.createAdressToBeSaved();

        Address address = adressRepository.save(addressToBeSaved);

        Assertions.assertEquals(address.getId(), addressToBeSaved.getId());
        Assertions.assertEquals(address.getCep(), addressToBeSaved.getCep());
        Assertions.assertEquals(address.getNumero(), addressToBeSaved.getNumero());
        Assertions.assertEquals(address.getLogradouro(), addressToBeSaved.getLogradouro());
        Assertions.assertEquals(address.getLocalidade(), addressToBeSaved.getLocalidade());
    }

    @Test
    void update_PersistAdress_WhenSuccessful() {
        Address addressToBeSaved = AdressBuilder.createAdressToBeSaved();

        Address addressSaved = adressRepository.save(addressToBeSaved);

        Address addressUpdated = adressRepository.save(addressSaved);

        Assertions.assertEquals(addressUpdated.getId(), addressSaved.getId());
        Assertions.assertEquals(addressUpdated.getNumero(), addressSaved.getNumero());
        Assertions.assertEquals(addressUpdated.getCep(), addressSaved.getCep());
        Assertions.assertEquals(addressUpdated.getLocalidade(), addressSaved.getLocalidade());
        Assertions.assertEquals(addressUpdated.getLogradouro(), addressSaved.getLogradouro());
    }
}