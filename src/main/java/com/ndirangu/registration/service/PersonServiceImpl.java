package com.ndirangu.registration.service;

import com.ndirangu.registration.model.Person;
import com.ndirangu.registration.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{
    private  final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Page<Person> listAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @Override
    public Optional<Person> findOne(Long id) throws Exception{
        personRepository.findById(id).orElseThrow(()-> new Exception("person with id "+id+" not found"));
        return personRepository.findById(id);
    }

    @Override
    public Long create(Person person) {
        return personRepository.save(person).getId();
    }

    @Override
    public Long update(Person person) throws Exception{
        personRepository.findById(person.getId()).orElseThrow(()-> new Exception("person with id "+person.getId()+" not found"));
        person.setId(person.getId());
        return personRepository.save(person).getId();
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
