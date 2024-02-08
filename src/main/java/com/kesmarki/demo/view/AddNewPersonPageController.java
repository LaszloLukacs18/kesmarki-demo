package com.kesmarki.demo.view;

import com.kesmarki.demo.address.Address;
import com.kesmarki.demo.contact.Contact;
import com.kesmarki.demo.person.Person;
import com.kesmarki.demo.person.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AddNewPersonPageController {

    private final PersonService personService;

    @GetMapping("/")
    public String getHomePage(final Model model) {
        List<Address> addresses = new ArrayList<>();
        List< Contact> contacts = new ArrayList<>();
        Person person = new Person();
        person.setAddresses(addresses);
        person.setContacts(contacts);
        model.addAttribute("person", person);
        return "pages/home/home-page";
    }
    @PostMapping(
            value = "/add-new-person",
            consumes = {MediaType.ALL_VALUE}
    )
    public String getRegisterResultPage(Person person) {
        personService.save(person);
        return "pages/home/home-page";
    }

}
