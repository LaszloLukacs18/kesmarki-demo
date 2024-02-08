package com.kesmarki.demo.person;

import com.kesmarki.demo.address.Address;
import com.kesmarki.demo.address.AddressType;
import com.kesmarki.demo.contact.Contact;
import com.kesmarki.demo.contact.ContactType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PersonApi {

    private final PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<Person> save(@RequestBody Person person) {
        try {
            Person _person = personService.save(person);
            return new ResponseEntity<>(_person, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> findById(@PathVariable("id") Integer id) {
        Optional<Person> person = personService.findById(id);
        if (person.isPresent()) {
            return new ResponseEntity<>(person.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> findAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        try {
            List<Person> personList = personService.findAll(pageNo, pageSize);
            return new ResponseEntity<>(personList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("person/{id}")
    public ResponseEntity<Person> update(
            @PathVariable("id") Integer id,
            @RequestBody Person person) {
        try {
            Person _person = personService.update(person);
            return new ResponseEntity<>(_person, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("person/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {
            personService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hello")
    public String hello() {
        Address address = new Address();
        address.setAddressType(AddressType.PERMANENT);
        address.setPostalCode("2341");
        address.setCity("Budapest");
        address.setStreet("Kossuth");
        address.setHouseNumber("11");
        Address address2 = new Address();
        address2.setAddressType(AddressType.TEMPORARY);
        address2.setPostalCode("1111");
        address2.setCity("Debrecen");
        address2.setStreet("Kossuth");
        address2.setHouseNumber("22");
        Contact contact = new Contact();
        contact.setContactType(ContactType.EMAIL);
        contact.setValue("lksoddvgmail.com");
        Contact contact2 = new Contact();
        contact2.setContactType(ContactType.EMAIL);
        contact2.setValue("sder@gmail.com");
        Contact contact3 = new Contact();
        contact3.setContactType(ContactType.PHONE_NUMBER);
        contact3.setValue("+36 30 2988 333");
        Person person = new Person();
        person.setFirstName("Kiss");
        person.setLastName("Ferenc");
        address.setPerson(person);
        address2.setPerson(person);
        contact.setPerson(person);
        contact2.setPerson(person);
        contact3.setPerson(person);
        List<Contact> contactList = new ArrayList<>();
        contactList.add(contact);
        contactList.add(contact2);
        contactList.add(contact3);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        addressList.add(address2);
        person.setAddresses(addressList);
        person.setContacts(contactList);
        personService.save(person);
        List<Person> personList = (List<Person>) personService.findAll(0,10);
        System.out.println(personList);
        return "Hello";
    }

}
