package com.ndirangu.registration.controller;

import com.ndirangu.registration.model.Person;
import com.ndirangu.registration.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/person")
@Api(tags = {"Person"})
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping({"", "/", "/list"})
    @ApiOperation(value = "Returns a list of all registered people")
    public Page<Person> list(Pageable pageable){
        return personService.listAll(pageable);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Returns a registered person by id")
    public Optional<Person> findOne(@PathVariable Long id) throws Exception{
        personService.findOne(id).orElseThrow(()-> new Exception("person with id "+id+" not found"));
        return personService.findOne(id);
    }

    @PostMapping("/register")
    @ApiOperation(value = "Registers a new person")
    public @ResponseBody  Long create(@RequestBody Person person){
        return personService.create(person);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Updates information of a registered person")
    public @ResponseBody  Long update(@PathVariable Long id, @RequestBody Person person)throws Exception{
        personService.findOne(id).orElseThrow(()-> new Exception("person with id "+id+" not found"));
        person.setId(id);
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletes a registered person")
    public void deleteById(@PathVariable Long id){
        personService.deleteById(id);
    }

}
