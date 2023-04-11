package com.attornatus.person.repository;

import com.attornatus.person.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {
    List<Adress> findAllByPersonId(Long id);
}