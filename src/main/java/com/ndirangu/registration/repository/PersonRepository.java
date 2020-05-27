package com.ndirangu.registration.repository;

import com.ndirangu.registration.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
