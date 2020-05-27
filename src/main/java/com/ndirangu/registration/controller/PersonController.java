package com.ndirangu.registration.controller;

import com.ndirangu.registration.model.Person;
import com.ndirangu.registration.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public Page<Person> list(Pageable pageable){
        return personService.listAll(pageable);
    }

    @GetMapping("/{id}")
    public Optional<Person> findOne(@PathVariable Long id) throws Exception{
        personService.findOne(id).orElseThrow(()-> new Exception("person with id "+id+" not found"));
        return personService.findOne(id);
    }

    @PostMapping("/register")
    public @ResponseBody  Long create(@RequestBody Person person){
        return personService.create(person);
    }

    @PutMapping("/{id}")
    public @ResponseBody  Long update(@PathVariable Long id, @RequestBody Person person)throws Exception{
        personService.findOne(id).orElseThrow(()-> new Exception("person with id "+id+" not found"));
        person.setId(id);
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        personService.deleteById(id);
    }

}
