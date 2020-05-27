package com.ndirangu.registration.service;

import com.ndirangu.registration.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PersonService {
    Page<Person> listAll(Pageable pageable);
    Optional<Person> findOne(Long id) throws Exception;
    Long create(Person person);
    Long update(Person person)  throws Exception;
    void deleteById(Long id);
}
