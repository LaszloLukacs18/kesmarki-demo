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
    public static final String EMPTY_STRING = "";
    public static final String NO_VALUE_PRESENT = "No value present";

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
    void savePersonWithEmptyFirstNameMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.setFirstName(EMPTY_STRING);
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
    void savePersonWithEmptyLastNameMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.setLastName(EMPTY_STRING);
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
    void savePersonWithEmptyPrimaryContactEmailMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.setPrimaryContactEmail(EMPTY_STRING);
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
    void savePersonWithEmptyAddressListMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.setAddresses(new ArrayList<>());
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutContactsMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.getAddresses().get(0).getContacts().get(0)
                    .setContactType(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithEmptyContactListMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.getAddresses().get(0).setContacts(new ArrayList<>());
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutAddressTypeMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.getAddresses().get(0).setAddressType(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutPostalCodeMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.getAddresses().get(0).setPostalCode(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithEmptyPostalCodeMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.getAddresses().get(0).setPostalCode(EMPTY_STRING);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutCityMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.getAddresses().get(0).setCity(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithEmptyCityMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.getAddresses().get(0).setCity(EMPTY_STRING);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutStreetMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.getAddresses().get(0).setStreet(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithEmptyStreetMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.getAddresses().get(0).setStreet(EMPTY_STRING);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutHouseNumberMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.getAddresses().get(0).setHouseNumber(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutContactTypeMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.getAddresses().get(0).getContacts().get(0)
                    .setContactType(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutContactValueMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.getAddresses().get(0).getContacts().get(0)
                    .setValue(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithEmptyContactValueMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            person.getAddresses().get(0).getContacts().get(0)
                    .setValue(EMPTY_STRING);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void findByIdMustReturnThePersonWithTheGivenId() {
        Person person = ValidPersonBuilder.build();
        Person savedPerson = personService.save(person);
        Person dbPerson = personService.findById(savedPerson.getId()).get();
        assertThat(savedPerson).isEqualTo(dbPerson);
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteByIdMustRemovePersonWithTheGivenIdFromDatabase() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build();
            Person savedPerson = personService.save(person);
            personService.deleteById(savedPerson.getId());
            Person dbPerson = personService.findById(savedPerson.getId()).get();
        });
        Assertions.assertEquals(NO_VALUE_PRESENT, thrown.getMessage());

    }

}