package com.attornatus.person.repository;

import com.attornatus.person.model.Adress;
import com.attornatus.person.utils.AdressBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class AdressRepositoryTest {

    @Autowired
    AdressRepository adressRepository;

    @Test
    void save_persistAdress_WhenSuccessful() {

        Adress adressToBeSaved = AdressBuilder.createAdressToBeSaved();

        Adress adress = adressRepository.save(adressToBeSaved);

        Assertions.assertEquals(adress.getId(), adressToBeSaved.getId());
        Assertions.assertEquals(adress.getCep(), adressToBeSaved.getCep());
        Assertions.assertEquals(adress.getNumero(), adressToBeSaved.getNumero());
        Assertions.assertEquals(adress.getLogradouro(), adressToBeSaved.getLogradouro());
        Assertions.assertEquals(adress.getLocalidade(), adressToBeSaved.getLocalidade());
    }

    @Test
    void update_PersistAdress_WhenSuccessful() {
        Adress adressToBeSaved = AdressBuilder.createAdressToBeSaved();

        Adress adressSaved = adressRepository.save(adressToBeSaved);

        Adress adressUpdated = adressRepository.save(adressSaved);

        Assertions.assertEquals(adressUpdated.getId(), adressSaved.getId());
        Assertions.assertEquals(adressUpdated.getNumero(), adressSaved.getNumero());
        Assertions.assertEquals(adressUpdated.getCep(), adressSaved.getCep());
        Assertions.assertEquals(adressUpdated.getLocalidade(), adressSaved.getLocalidade());
        Assertions.assertEquals(adressUpdated.getLogradouro(), adressSaved.getLogradouro());
    }
}