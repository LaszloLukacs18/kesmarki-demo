package com.kesmarki.demo.person;

import com.kesmarki.demo.address.Address;
import com.kesmarki.demo.address.AddressType;
import com.kesmarki.demo.contact.Contact;
import com.kesmarki.demo.contact.ContactType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    void saveValidPersonObjectMustBeStoredToDatabase() throws Exception {
        Person validPerson = new Person();
        validPerson.setFirstName("First");
        validPerson.setLastName("Last");
        validPerson.setPrimaryContactEmail("test@gmail.com");
        Address address = new Address();
        address.setPerson(validPerson);
        address.setCity("City name");
        address.setStreet("Street name");
        address.setHouseNumber("14");
        address.setAddressType(AddressType.PERMANENT);
        address.setPostalCode("1234");
        Address addressTmp = new Address();
        addressTmp.setPerson(validPerson);
        addressTmp.setCity("Temporary city name");
        addressTmp.setStreet("Temporary  street name");
        addressTmp.setHouseNumber("88");
        addressTmp.setPostalCode("123456");
        addressTmp.setAddressType(AddressType.TEMPORARY);
        Contact contact = new Contact();
        contact.setContactType(ContactType.EMAIL);
        contact.setValue("test@test.com");
        contact.setPerson(validPerson);
        Contact contact2 = new Contact();
        contact2.setContactType(ContactType.PHONE_NUMBER);
        contact2.setValue("+36 888 3333");
        contact2.setPerson(validPerson);
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        addresses.add(addressTmp);
        validPerson.setAddresses(addresses);
        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact);
        contacts.add(contact2);
        validPerson.setContacts(contacts);
        Person savedPerson = personService.save(validPerson);
        Person dbPerson = personService.findById(savedPerson.getId()).get();
        assertThat(savedPerson).isEqualTo(dbPerson);
    }

    @Test
    void saveInValidPersonObjectMustThrowAnException() throws Exception {
        Person invalidPerson = new Person();
        invalidPerson.setFirstName("Invalid");
        invalidPerson.setLastName("Invalid");
        Person savedPerson = personService.save(invalidPerson);
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