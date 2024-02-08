package com.kesmarki.demo.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class PersonServiceTest {

    public static final String JPA_COMMIT_ERROR
            = "Could not commit JPA transaction";

    @Autowired
    private PersonService personService;

    @Test
    void saveValidPersonObjectMustBeStoredToDatabase() {
        Person validPerson = ValidPersonBuilder.build();
        Person savedPerson = personService.save(validPerson);
        Person dbPerson = personService.findById(savedPerson.getId()).get();
        assertThat(savedPerson).isEqualTo(dbPerson);
    }

    @Test
    void savePersonWithoutFirstNameMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.setFirstName(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutLastNameMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.setLastName(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutPrimaryContactEmailMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.setPrimaryContactEmail(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutAddressesMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.setAddresses(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithEmptyAddressListMustThrownException()
            throws Exception {
        Person person = ValidPersonBuilder.build();
        person.setAddresses(new ArrayList<>());
        personService.save(person);
    }

    @Test
    void savePersonWithoutContactsMustThrownException()
            throws Exception {
        Person person = ValidPersonBuilder.build();
        person.setContacts(null);
        personService.save(person);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}