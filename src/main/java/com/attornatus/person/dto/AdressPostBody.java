package com.attornatus.person.dto;

import lombok.Getter;

@Getter
public class AdressPostBody {
    private String cep;
    private String logradouro;
    private String localidade;
    private Long numero;
}