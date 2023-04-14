package com.attornatus.person.dto;

public record AddressPostBody(String cep, String logradouro, String localidade, Long numero, Boolean isMain) {
}