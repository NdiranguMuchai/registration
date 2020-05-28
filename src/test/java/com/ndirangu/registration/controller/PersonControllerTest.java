package com.ndirangu.registration.controller;

import com.ndirangu.registration.model.Person;
import com.ndirangu.registration.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    @Mock
    PersonService personService;
    @InjectMocks
    PersonController personController;

    MockMvc mockMvc;

    public static final Long ID = 1L;
    public static final String NAME = "Jina";
    public static final Long NATIONAL_ID = 323232L;
    @BeforeEach
    void setUp() {
        personController = new PersonController(personService);

        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
    }

    @Test
    void list() throws Exception{
        Person person = new Person();
        person.setId(ID);

        when(personService.findOne(anyLong())).thenReturn(java.util.Optional.of(person));

        mockMvc.perform(MockMvcRequestBuilders.get("/person/1")).
                andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    void findOne() throws Exception{
        Person person = new Person();
        person.setId(ID);

        when(personService.findOne(anyLong())).thenReturn(java.util.Optional.of(person));

        mockMvc.perform(MockMvcRequestBuilders.get("/person/1")).
                andExpect(MockMvcResultMatchers.status().isOk());
    }


}