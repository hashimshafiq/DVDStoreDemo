package com.example.dvd.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class FilmStudio {

    @Id
    private Long id;

    private String name;

    private Date since;




}
