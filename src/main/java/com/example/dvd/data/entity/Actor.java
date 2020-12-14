package com.example.dvd.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Actor {

    @Id
    private Long id;
    private String name;
    private boolean wonOscar;
    private LocalDate birthday;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;
}
