package com.kesmarki.demo.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kesmarki.demo.person.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    private AddressType addressType;
    private String postalCode;
    private String city;
    private String street;
    private String houseNumber;

}
