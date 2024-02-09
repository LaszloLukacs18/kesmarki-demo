package com.kesmarki.demo.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kesmarki.demo.contact.Contact;
import com.kesmarki.demo.person.Person;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;


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

    @NotNull(message = "Address type is mandatory")
    private AddressType addressType;

    @NotBlank(message = "Postal code is mandatory")
    private String postalCode;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "Street is mandatory")
    private String street;

    @NotBlank(message = "House number is mandatory")
    private String houseNumber;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "address",
            cascade = CascadeType.ALL
    )
    @Valid
    @NotNull
    @Size(min=1)
    private List<Contact> contacts;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Address address = (Address) o;
        return getId() != null && Objects.equals(getId(), address.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
