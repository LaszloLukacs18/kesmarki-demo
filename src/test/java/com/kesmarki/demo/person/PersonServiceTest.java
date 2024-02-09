package com.kesmarki.demo.person;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class PersonServiceTest {

    public static final String JPA_COMMIT_ERROR
            = "Could not commit JPA transaction";
    public static final String EMPTY_STRING = "";
    public static final String NO_VALUE_PRESENT = "No value present";
    public static final int _0 = 0;
    public static final int _100 = 100;
    public static final int _40 = 40;
    public static final String CHANGED_FIRSTNAME = "Changed Firstname";
    public static final int CHANGED_HOUSE_NUMBER = 43;

    @Autowired
    private PersonService personService;

    @BeforeEach
    void setUp() {
        List<Person> persons = personService.findAll(_0, _100);
        for (Person person : persons) {
            personService.deleteById(person.getId());
        }
    }

    @Test
    void saveValidPersonObjectMustBeStoredToDatabase() {
        Person validPerson = ValidPersonBuilder.build("test0");
        Person savedPerson = personService.save(validPerson);
        Person dbPerson = personService.findById(savedPerson.getId()).get();
        assertThat(savedPerson.getId()).isEqualTo(dbPerson.getId());
    }

    @Test
    void savePersonWithoutFirstNameMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test1");
            person.setFirstName(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithEmptyFirstNameMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test2");
            person.setFirstName(EMPTY_STRING);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutLastNameMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test3");
            person.setLastName(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithEmptyLastNameMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test4");
            person.setLastName(EMPTY_STRING);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutPrimaryContactEmailMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test5");
            person.setPrimaryContactEmail(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithEmptyPrimaryContactEmailMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test6");
            person.setPrimaryContactEmail(EMPTY_STRING);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutAddressesMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test7");
            person.setAddresses(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithEmptyAddressListMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test8");
            person.setAddresses(new ArrayList<>());
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutContactsMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test9");
            person.getAddresses().get(_0).getContacts().get(_0)
                    .setContactType(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithEmptyContactListMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test10");
            person.getAddresses().get(_0).setContacts(new ArrayList<>());
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutAddressTypeMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test11");
            person.getAddresses().get(_0).setAddressType(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutPostalCodeMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test12");
            person.getAddresses().get(_0).setPostalCode(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithEmptyPostalCodeMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test13");
            person.getAddresses().get(_0).setPostalCode(EMPTY_STRING);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutCityMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test14");
            person.getAddresses().get(_0).setCity(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithEmptyCityMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test15");
            person.getAddresses().get(_0).setCity(EMPTY_STRING);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutStreetMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test16");
            person.getAddresses().get(_0).setStreet(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithEmptyStreetMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test17");
            person.getAddresses().get(_0).setStreet(EMPTY_STRING);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutHouseNumberMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test18");
            person.getAddresses().get(_0).setHouseNumber(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutContactTypeMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test19");
            person.getAddresses().get(_0).getContacts().get(_0)
                    .setContactType(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithoutContactValueMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test20");
            person.getAddresses().get(_0).getContacts().get(_0)
                    .setValue(null);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void savePersonWithEmptyContactValueMustThrownException() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test21");
            person.getAddresses().get(_0).getContacts().get(_0)
                    .setValue(EMPTY_STRING);
            personService.save(person);
        });
        Assertions.assertEquals(JPA_COMMIT_ERROR, thrown.getMessage());
    }

    @Test
    void findByIdMustReturnThePersonWithTheGivenId() {
        Person person = ValidPersonBuilder.build("test22");
        Person savedPerson = personService.save(person);
        Person dbPerson = personService.findById(savedPerson.getId()).get();
        assertThat(savedPerson.getId()).isEqualTo(dbPerson.getId());
    }

    @Test
    void findAllMustReturnAsManyPersonsAsPageSizeGiven() {
        for (int i = _0; i < _40; i++) {
            Person person = ValidPersonBuilder.build("test" + i);
            personService.save(person);
        }
        List<Person> persons = personService.findAll(_0, _40);
        Assertions.assertEquals(_40, persons.size());
    }

    @Test
    void updateMustUpdateThePersonsFirstNameInDatabase() {
        Person person = ValidPersonBuilder.build("test");
        personService.save(person);
        person.setFirstName(CHANGED_FIRSTNAME);
        personService.update(person);
        Person updatedPerson = personService.findById(person.getId()).get();
        String updatedPersonName = updatedPerson.getFirstName();
        Assertions.assertEquals(CHANGED_FIRSTNAME, updatedPersonName);
    }

    @Test
    @Transactional
    void updateMustUpdateThePersonsAddressInDatabase() {
        Person person = ValidPersonBuilder.build("test");
        personService.save(person);
        person.getAddresses().get(0).setHouseNumber(CHANGED_HOUSE_NUMBER);
        personService.update(person);
        Person updatedPerson = personService.findById(person.getId()).get();
        Integer updatedHouseNumber
                = updatedPerson.getAddresses().get(0).getHouseNumber();
        Assertions.assertEquals(CHANGED_HOUSE_NUMBER, updatedHouseNumber);
    }

    @Test
    void deleteByIdMustRemovePersonWithTheGivenIdFromDatabase() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            Person person = ValidPersonBuilder.build("test23");
            Person savedPerson = personService.save(person);
            personService.deleteById(savedPerson.getId());
            personService.findById(savedPerson.getId()).get();
        });
        Assertions.assertEquals(NO_VALUE_PRESENT, thrown.getMessage());
    }

}