package com.example.dvd.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Actor {

    @Id
    private Long id;
    private String name;
    private boolean wonOscar;
    private LocalDate birthday;
}
