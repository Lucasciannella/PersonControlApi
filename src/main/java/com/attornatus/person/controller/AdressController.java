package com.attornatus.person.controller;

import com.attornatus.person.dto.AdressPostBody;
import com.attornatus.person.model.Adress;
import com.attornatus.person.service.AdressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/adress-management")
@RequiredArgsConstructor
@Tag(name = "Person Controller")
public class AdressController {

    private final AdressService adressService;

    @PostMapping("/{id}")
    @Transactional
    @Operation(summary = "save adress", description = "Saves person's adress by id")
    public ResponseEntity<Adress> save(@PathVariable Long id, @RequestBody AdressPostBody adressPostBody) {
        return new ResponseEntity<>(adressService.saveAdress(id, adressPostBody), HttpStatus.CREATED);
    }

    @GetMapping("/{personId}")
    @Operation(summary = "List adress", description = "Lists all addresses for a person")
    public ResponseEntity<List<Adress>> getAdress (@PathVariable Long personId){
        return  ResponseEntity.ok(adressService.listAdress(personId));
    }

    @PutMapping("/person/{personId}/adress/{adressId}")
    @Transactional
    @Operation(summary = "Set main adress", description = "defines a person's primary address")
    public ResponseEntity<Adress> setMainAdress(@PathVariable Long personId, @PathVariable Long adressId){
        return  ResponseEntity.ok(adressService.setMainAdress(personId,adressId));
    }
}