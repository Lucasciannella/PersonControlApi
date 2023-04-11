package com.attornatus.person.utils;

import com.attornatus.person.model.Adress;

public class AdressBuilder {

    public static Adress createValidAdress(){
        return Adress.builder()
                .id(1L)
                .numero(100L)
                .cep("21640330")
                .logradouro("Rua são venâncio")
                .localidade("Rio de janeiro")
                .person(PersonBuilder.createValidPerson())
                .build();
    }

    public static Adress createAdressToBeSaved(){
        return Adress.builder()
                .numero(100L)
                .cep("21640330")
                .logradouro("Rua são venâncio")
                .localidade("Rio de janeiro")
                .build();
    }
}