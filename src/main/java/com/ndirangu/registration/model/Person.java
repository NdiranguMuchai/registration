package com.ndirangu.registration.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    private Long nationalId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }
}
