package com.kesmarki.demo.contact;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kesmarki.demo.person.Person;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    private ContactType contactType;
    private String value;

}
