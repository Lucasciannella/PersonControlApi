package com.attornatus.person.utils;

import com.attornatus.person.model.Address;

public class AdressBuilder {

    public static Address createValidAdress(){
        return Address.builder()
                .id(1L)
                .numero(100L)
                .cep("21640330")
                .logradouro("Rua são venâncio")
                .localidade("Rio de janeiro")
                .person(PersonBuilder.createValidPerson())
                .build();
    }

    public static Address createAdressToBeSaved(){
        return Address.builder()
                .numero(100L)
                .cep("21640330")
                .logradouro("Rua são venâncio")
                .localidade("Rio de janeiro")
                .build();
    }
}