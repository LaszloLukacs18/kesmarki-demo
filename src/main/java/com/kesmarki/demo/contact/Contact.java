package com.kesmarki.demo.contact;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kesmarki.demo.address.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "address_id")
    private Address address;

    @NotNull(message = "Contact type is mandatory")
    private ContactType contactType;

    @NotBlank(message = "Contact value is mandatory")
    private String value;

}
