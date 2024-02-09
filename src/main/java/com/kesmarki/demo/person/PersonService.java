package com.kesmarki.demo.person;

import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonPageRepository personPageRepository;

    public Person save(final Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> findById(final Integer id) {
        return personRepository.findById(id);
    }

    public List<Person> findAll(final Integer pageNo, final Integer pageSize) {
        List<Person> returnValue = new ArrayList<>();
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Person> pageResult = personPageRepository.findAll(paging);
        if (pageResult.hasContent()) {
            returnValue = pageResult.getContent();
        }
        return returnValue;
    }

    public Person update(final Person person) {
        return personRepository.save(person);
    }

    public void deleteById(final Integer id) {
        personRepository.deleteById(id);
    }

}
