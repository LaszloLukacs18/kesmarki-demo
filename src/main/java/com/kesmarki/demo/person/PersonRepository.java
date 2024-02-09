package com.kesmarki.demo.person;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    Optional<Person> findByPrimaryContactEmail(String primaryContactEmail);
}
