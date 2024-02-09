package com.kesmarki.demo.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonApiTest {

    public static final int _0 = 0;
    public static final int _40 = 40;
    public static final int _100 = 100;
    public static final String FIRST_NAME = "firstName";
    public static final String FIRST_NAME_IS_MANDATORY
            = "First name is mandatory";
    public static final String EMPTY_STRING = "";
    public static final String ENDPOINT_PERSON = "/person";
    public static final String HOST = "http://localhost:";
    public static final String PRIMARY_CONTACT_EMAIL_IS_MANDATORY
            = "Primary contact email is mandatory!";
    public static final String PRIMARY_CONTACT_EMAIL = "primaryContactEmail";
    public static final String LAST_NAME = "lastName";
    public static final String LAST_NAME_IS_MANDATORY
            = "Last name is mandatory";
    public static final String MUST_PROVIDE_A_VALID_EMAIL
            = "Must provide a valid email!";
    public static final String INVALID_EMAIL = "hdjduezeze";
    public static final String TEST_0_EMAIL = "test0";
    public static final String ADDRESSES = "addresses";
    public static final String MUST_PROVIDE_AT_LEAST_ONE_ADDRESS
            = "Must provide at least one address!";
    public static final String A_MÉRETNEK_A_Z_1_ÉS_2_ÉRTÉKEK_KÖZÖTT_KELL_LENNIE
            = "a méretnek a(z) 1 és 2 értékek között kell lennie";
    public static final String ADDRESSES_0_CONTACTS = "addresses[0].contacts";
    public static final String MUST_PROVIDE_AT_LEAST_1_CONTACT
            = "Must provide at least 1 contact!";
    public static final String CONTACTS_CAN_NOT_BE_NULL
            = "Contacts can not be null!";
    public static final String ADDRESSES_0_ADDRESS_TYPE
            = "addresses[0].addressType";
    public static final String ADDRESS_TYPE_IS_MANDATORY
            = "Address type is mandatory";
    public static final String ADDRESSES_0_POSTAL_CODE
            = "addresses[0].postalCode";
    public static final String POSTAL_CODE_IS_MANDATORY
            = "Postal code is mandatory";
    public static final String ADDRESSES_0_CITY = "addresses[0].city";
    public static final String CITY_IS_MANDATORY = "City is mandatory";
    public static final String ADDRESSES_0_STREET = "addresses[0].street";
    public static final String STREET_IS_MANDATORY = "Street is mandatory";
    public static final String ADDRESSES_0_HOUSE_NUMBER
            = "addresses[0].houseNumber";
    public static final String HOUSE_NUMBER_IS_MANDATORY
            = "House number is mandatory";
    public static final String ADDRESSES_0_CONTACTS_0_VALUE
            = "addresses[0].contacts[0].value";
    public static final String CONTACT_VALUE_IS_MANDATORY
            = "Contact value is mandatory";
    public static final int NON_EXISTED_PERSON_ID = 9999999;
    public static final String FIND_ALL_ENDPOINT = "/person?pageNo=0&&pageSize=40";

    @Autowired
    private PersonService personService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        List<Person> persons = personService.findAll(_0, _100);
        for (Person person : persons) {
            personService.deleteById(person.getId());
        }
    }

    @Test
    void saveValidPersonObjectMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        restTemplate.postForEntity(uri, request, Person.class);
        Optional<Person> dbPerson
                = personService.findByPrimaryContactEmail("test0@gmail.com");
        assertThat(dbPerson.isPresent()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void savePersonWithoutFirstNameMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.setFirstName(null);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(FIRST_NAME, FIRST_NAME_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithEmptyFirstNameMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.setFirstName(EMPTY_STRING);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(FIRST_NAME, FIRST_NAME_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithoutLastNameMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.setLastName(null);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(LAST_NAME, LAST_NAME_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithEmptyLastNameMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.setLastName(EMPTY_STRING);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(LAST_NAME, LAST_NAME_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithoutPrimaryContactEmailMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.setPrimaryContactEmail(null);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(PRIMARY_CONTACT_EMAIL, PRIMARY_CONTACT_EMAIL_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithEmptyPrimaryContactEmailMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.setPrimaryContactEmail(EMPTY_STRING);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(PRIMARY_CONTACT_EMAIL, PRIMARY_CONTACT_EMAIL_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithInvalidPrimaryContactEmailMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.setPrimaryContactEmail(INVALID_EMAIL);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(PRIMARY_CONTACT_EMAIL, MUST_PROVIDE_A_VALID_EMAIL);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithoutAddressesMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.setAddresses(null);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(ADDRESSES, MUST_PROVIDE_AT_LEAST_ONE_ADDRESS);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithEmptyAddressesMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.setAddresses(new ArrayList<>());
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(ADDRESSES, MUST_PROVIDE_AT_LEAST_ONE_ADDRESS);
        errors.put(ADDRESSES, A_MÉRETNEK_A_Z_1_ÉS_2_ÉRTÉKEK_KÖZÖTT_KELL_LENNIE);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithoutContactsMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.getAddresses().get(0).setContacts(null);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(ADDRESSES_0_CONTACTS, CONTACTS_CAN_NOT_BE_NULL);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithEmptyContactsMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.getAddresses().get(0).setContacts(new ArrayList<>());
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(ADDRESSES_0_CONTACTS, MUST_PROVIDE_AT_LEAST_1_CONTACT);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithoutAddressTypeMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.getAddresses().get(0).setAddressType(null);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(ADDRESSES_0_ADDRESS_TYPE, ADDRESS_TYPE_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithoutPostalCodeMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.getAddresses().get(0).setPostalCode(null);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(ADDRESSES_0_POSTAL_CODE, POSTAL_CODE_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithEmptyPostalCodeMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.getAddresses().get(0).setPostalCode(EMPTY_STRING);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(ADDRESSES_0_POSTAL_CODE, POSTAL_CODE_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithoutCityMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.getAddresses().get(0).setCity(null);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(ADDRESSES_0_CITY, CITY_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithEmptyCityMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.getAddresses().get(0).setCity(EMPTY_STRING);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(ADDRESSES_0_CITY, CITY_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithoutStreetMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.getAddresses().get(0).setStreet(null);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(ADDRESSES_0_STREET, STREET_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithEmptyStreetMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.getAddresses().get(0).setStreet(EMPTY_STRING);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(ADDRESSES_0_STREET, STREET_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithoutHouseNumberMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.getAddresses().get(0).setHouseNumber(null);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(ADDRESSES_0_HOUSE_NUMBER, HOUSE_NUMBER_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithoutContactValueMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.getAddresses().get(0).getContacts().get(0).setValue(null);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(ADDRESSES_0_CONTACTS_0_VALUE, CONTACT_VALUE_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void savePersonWithEmptyContactValueMustReturnError()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        validPerson.getAddresses().get(0).getContacts().get(0)
                .setValue(EMPTY_STRING);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        ResponseEntity<Object> response
                = restTemplate.postForEntity(uri, request, Object.class);
        Map<String, String> errors = new HashMap<>();
        errors.put(ADDRESSES_0_CONTACTS_0_VALUE, CONTACT_VALUE_IS_MANDATORY);
        Assertions.assertEquals(errors, response.getBody());
    }

    @Test
    void findByIdMustReturnThePersonWithTheGivenId() throws URISyntaxException {
        Person person = ValidPersonBuilder.build(TEST_0_EMAIL);
        Person dbPerson = personService.save(person);
        URI uri = new URI(HOST + port + ENDPOINT_PERSON
                + "/" + dbPerson.getId());
        ResponseEntity<Person> response
                = restTemplate.getForEntity(uri, Person.class);
        Person respondPerson = response.getBody();
        assertThat(respondPerson.getPrimaryContactEmail())
                .isEqualTo(dbPerson.getPrimaryContactEmail());
    }

    @Test
    void findByIdMustReturnNullWhenNonExistedIdProvided()
            throws URISyntaxException {
        URI uri = new URI(HOST + port + ENDPOINT_PERSON
                + "/" + NON_EXISTED_PERSON_ID);
        ResponseEntity<Person> response
                = restTemplate.getForEntity(uri, Person.class);
        Person respondPerson = response.getBody();
        Assertions.assertNull(respondPerson);
    }

    @Test
    void findAllMustReturnAsManyPersonsAsPageSizeGiven()
            throws URISyntaxException {
        for (int i = _0; i < _40; i++) {
            Person person = ValidPersonBuilder.build("test" + i);
            personService.save(person);
        }
        URI uri = new URI(HOST + port + FIND_ALL_ENDPOINT);
        ResponseEntity<List<Person>> persons = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Person>>() {});
        Assertions.assertEquals(_40, persons.getBody().size());
    }

    @Test
    void updateMustUpdateThePersonsFirstNameInDatabase()
            throws URISyntaxException {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        URI saveUri = new URI(HOST + port + ENDPOINT_PERSON);
        HttpEntity<Person> request = new HttpEntity<>(validPerson);
        restTemplate.postForEntity(saveUri, request, Person.class);
        Optional<Person> dbPerson
                = personService.findByPrimaryContactEmail("test0@gmail.com");
        Integer id = dbPerson.get().getId();
        URI getUri = new URI(HOST + port + "/person/" + id);
        ResponseEntity<Person> getResponse
                = restTemplate.getForEntity(getUri, Person.class);
        Person person = getResponse.getBody();
        person.setFirstName("Changed first name");
        URI updateUri = new URI(HOST + port + "/person/" + id);
        restTemplate.put(updateUri, person);
        Person updatedPerson = personService.findById(id).get();
        Assertions.assertEquals("Changed first name",
                updatedPerson.getFirstName());
    }

    @Test
    void deleteMustRemovePersonWithGivenIdFromDatabase() {
        Person validPerson = ValidApiPersonBuilder.build(TEST_0_EMAIL);
        Person dbPerson = personService.save(validPerson);
        restTemplate.delete("/person/" + dbPerson.getId());
        Optional<Person> person = personService.findById(dbPerson.getId());
        Assertions.assertEquals(person.isPresent(), Boolean.FALSE);
    }
}