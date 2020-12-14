package com.example.dvd.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class FilmStudio {

    @Id
    private Long id;

    private String name;

    private Date since;

    @OneToMany(mappedBy = "filmStudio")
    private List<Movie> movies;




}
