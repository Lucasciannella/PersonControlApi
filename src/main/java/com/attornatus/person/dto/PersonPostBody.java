package com.attornatus.person.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonPostBody {
    private String name;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
}