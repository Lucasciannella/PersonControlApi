package com.attornatus.person.repository;

import com.attornatus.person.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByPersonId(Long id);
}