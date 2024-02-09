package com.kesmarki.demo.person;

import com.kesmarki.demo.address.Address;
import com.kesmarki.demo.contact.Contact;

public class ValidApiPersonBuilder {

    public static Person build(final String emailPrefix) {
        Person person = ValidPersonBuilder.build(emailPrefix);
        person.setId(null);
        removeTwoWayBinding(person);
        return person;
    }

    private static void removeTwoWayBinding(final Person person) {
        for(Address address : person.getAddresses()) {
            address.setPerson(null);
            for(Contact contact: address.getContacts()) {
                contact.setAddress(null);
            }
        }
    }

}
