package com.attornatus.person.controller;

import com.attornatus.person.dto.PersonPostBody;
import com.attornatus.person.dto.PersonPutBody;
import com.attornatus.person.model.Person;
import com.attornatus.person.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/person")
@RequiredArgsConstructor
@Tag(name = "Person Controller")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    @Operation(summary = "Save Person", description = "Save a person in database")
    @ApiResponse(responseCode = "204", description = "Successful operation, person is created")
    public ResponseEntity<Person> save(@RequestBody PersonPostBody personPostBody) {
        return new ResponseEntity<>(personService.save(personPostBody), HttpStatus.CREATED);
    }

    @PutMapping
    @Operation(summary = "Update person", description = "update a person's record")
    @ApiResponse(responseCode = "200", description = "Successful operation, person is updated")
    public ResponseEntity<Person> update(@RequestBody PersonPutBody personPutBody) {
        return new ResponseEntity<>(personService.update(personPutBody), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a person", description = "Get person by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "500", description = "Person is not discovered or not exists in database")
    })
    public ResponseEntity<Person> getPersonByid(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping
    @Operation(summary = "List of persons", description = "brings a list of all people in the database")
    public ResponseEntity<List<Person>> listAllPerson() {
        return ResponseEntity.ok(personService.findAll());
    }
}