package com.kesmarki.demo.person;

import com.kesmarki.demo.address.Address;
import com.kesmarki.demo.contact.Contact;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "person",
            cascade = CascadeType.ALL
    )
    @Size(min=1, max=2)
    private List<Address> addresses;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "person",
            cascade = CascadeType.ALL
    )
    @Size(min=1)
    private List<Contact> contacts;

}
