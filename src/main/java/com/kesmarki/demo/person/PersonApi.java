package com.kesmarki.demo.person;

import com.kesmarki.demo.address.Address;
import com.kesmarki.demo.contact.Contact;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PersonApi {

    private final PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<Person> save(@RequestBody @Valid Person person) {
        try {
            setTwoWayBinding(person);
            Person _person = personService.save(person);
            return new ResponseEntity<>(_person, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void setTwoWayBinding(final Person person) {
        for (Address address : person.getAddresses()) {
            address.setPerson(person);
            for (Contact contact : address.getContacts()) {
                contact.setAddress(address);
            }
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

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> update(
            @PathVariable("id") Integer id,
            @RequestBody Person person) {
        try {
            person.setId(id);
            setTwoWayBinding(person);
            Person _person = personService.update(person);
            return new ResponseEntity<>(_person, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {
            personService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
