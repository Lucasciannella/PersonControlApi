package com.attornatus.person.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record PersonPutBody(Long id,String name, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate birthDate) {
}