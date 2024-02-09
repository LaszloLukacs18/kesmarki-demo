package com.kesmarki.demo.person;

import com.kesmarki.demo.address.Address;
import com.kesmarki.demo.address.AddressType;
import com.kesmarki.demo.contact.Contact;
import com.kesmarki.demo.contact.ContactType;

import java.util.ArrayList;
import java.util.List;

public class ValidPersonBuilder {

    public static Person build(final String emailPrefix) {
        Person validPerson = new Person();
        validPerson.setFirstName("First");
        validPerson.setLastName("Last");
        validPerson.setPrimaryContactEmail(emailPrefix + "@gmail.com");

        Address permanentAddress = new Address();
        permanentAddress.setPerson(validPerson);
        permanentAddress.setCity("City name");
        permanentAddress.setStreet("Street name");
        permanentAddress.setHouseNumber(14);
        permanentAddress.setAddressType(AddressType.PERMANENT);
        permanentAddress.setPostalCode("1234");

        Contact permanentcontact = new Contact();
        permanentcontact.setContactType(ContactType.EMAIL);
        permanentcontact.setValue("test@test.com");
        permanentcontact.setAddress(permanentAddress);

        Contact permanentContact2 = new Contact();
        permanentContact2.setContactType(ContactType.PHONE_NUMBER);
        permanentContact2.setValue("+36 888 3333");
        permanentContact2.setAddress(permanentAddress);

        List<Contact> permanentContacts = new ArrayList<>();
        permanentContacts.add(permanentcontact);
        permanentContacts.add(permanentContact2);
        permanentAddress.setContacts(permanentContacts);

        Address temporaryAddress = new Address();
        temporaryAddress.setPerson(validPerson);
        temporaryAddress.setCity("Temporary city name");
        temporaryAddress.setStreet("Temporary  street name");
        temporaryAddress.setHouseNumber(88);
        temporaryAddress.setPostalCode("123456");
        temporaryAddress.setAddressType(AddressType.TEMPORARY);

        Contact temporaryContact = new Contact();
        temporaryContact.setContactType(ContactType.EMAIL);
        temporaryContact.setValue("test2@test.com");
        temporaryContact.setAddress(temporaryAddress);

        Contact temporaryContact2 = new Contact();
        temporaryContact2.setContactType(ContactType.PHONE_NUMBER);
        temporaryContact2.setValue("+36 888 3433");
        temporaryContact2.setAddress(temporaryAddress);

        List<Contact> temporaryContacts = new ArrayList<>();
        temporaryContacts.add(temporaryContact);
        temporaryContacts.add(temporaryContact2);
        temporaryAddress.setContacts(temporaryContacts);

        List<Address> addresses = new ArrayList<>();
        addresses.add(permanentAddress);
        addresses.add(temporaryAddress);
        validPerson.setAddresses(addresses);
        return validPerson;
    }

}
