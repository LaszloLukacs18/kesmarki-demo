package com.kesmarki.demo.person;

import com.kesmarki.demo.address.Address;
import com.kesmarki.demo.contact.Contact;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
    private List<Contact> contacts;

}
