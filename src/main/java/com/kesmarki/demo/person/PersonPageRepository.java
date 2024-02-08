package com.kesmarki.demo.person;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonPageRepository
        extends PagingAndSortingRepository<Person, Integer> {


}
