package com.attornatus.person.controller;

import com.attornatus.person.dto.AddressPostBody;
import com.attornatus.person.model.Address;
import com.attornatus.person.service.AdressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/adress-management")
@RequiredArgsConstructor
@Tag(name = "Adress Controller")
public class AddressController {

    private final AdressService adressService;

    @PostMapping("/{id}")
    @Operation(summary = "save adress", description = "Saves person's adress by id")
    public ResponseEntity<Address> save(@PathVariable Long id, @RequestBody AddressPostBody addressPostBody) {
        return new ResponseEntity<>(adressService.saveAdress(id, addressPostBody), HttpStatus.CREATED);
    }

    @GetMapping("/person/{personId}")
    @Operation(summary = "List adress", description = "Lists all addresses for a person")
    public ResponseEntity<List<Address>> getAdress(@PathVariable Long personId) {
        return ResponseEntity.ok(adressService.listAdressByPersonId(personId));
    }

    @PutMapping("person/{personId}/adress/{adressId}")
    @Operation(summary = "Set main adress", description = "defines a person's primary address")
    public ResponseEntity<Address> setMainAdress(@PathVariable Long personId, @PathVariable Long adressId) {
        return ResponseEntity.ok(adressService.setMainAdress(personId, adressId));
    }
}