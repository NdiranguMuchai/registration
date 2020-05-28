package com.ndirangu.registration.service;

import com.ndirangu.registration.model.Person;
import com.ndirangu.registration.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.MockAnnotationProcessor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonServiceImpl personService;

    public static final Long ID =1L;
    public static final String NAME ="Jina";
    public static final Long NATIONAL_ID =123244L;

    Person returnedPerson = new Person();

    @BeforeEach
    void setUp() {
        returnedPerson.setId(1L);
        returnedPerson.setNationalId(NATIONAL_ID);
        returnedPerson.setName(NAME);

        personRepository.save(returnedPerson);
    }



    @Test
    void findOne() throws Exception{

        when(personRepository.findById(anyLong())).thenReturn(Optional.of(returnedPerson));

        Person person = personService.findOne(ID).get();

        assertNotNull(person);

    }

    @Test
    void create() {
        Person personToSave = new Person();
        personToSave.setName("Jas");
        personToSave.setNationalId(23454L);
        personToSave.setId(3L);
        personRepository.save(personToSave);


        when(personRepository.save(any())).thenReturn(returnedPerson);

        Long savedPersonId = personService.create(personToSave);

        assertNotNull(savedPersonId);

    }

    @Test
    void update() throws Exception{
        Person personToUpdate = new Person();
        personToUpdate.setName("Jas");
        personToUpdate.setNationalId(23454L);
        personToUpdate.setId(3L);
        personRepository.save(personToUpdate);


        when(personRepository.save(any())).thenReturn(returnedPerson);

        Long updatedPersonId = personService.create(personToUpdate);

        assertNotNull(updatedPersonId);
    }

    @Test
    void deleteById() {
        personService.deleteById(ID);
        verify(personRepository).deleteById(anyLong());
    }
}