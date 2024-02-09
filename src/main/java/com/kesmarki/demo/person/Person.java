package com.kesmarki.demo.person;

import com.kesmarki.demo.address.Address;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.transaction.annotation.Transactional;

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

    @Column(unique = true)
    @Email(message = "Must provide a valid email!")
    @NotBlank(message = "Primary contact email is mandatory!")
    private String primaryContactEmail;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "person",
            cascade = CascadeType.ALL)
    @Valid
    @NotNull
    @UniqueElements
    @Size(min = 1, max = 2)
    private List<Address> addresses;

}
