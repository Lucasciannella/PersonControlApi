package com.attornatus.person.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String localidade;
    private Long numero;
    @JsonIgnore
    @ManyToOne
    private Person person;
}