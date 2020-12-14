package com.example.dvd.data.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Data
@NoArgsConstructor
@Entity
@NamedEntityGraph(name = "Movie.movies",
    attributeNodes = @NamedAttributeNode(value = "actors"))
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private boolean wonOscar;
    private int year;
    private String coverImage;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;

    @ManyToOne(cascade = CascadeType.MERGE)
    private FilmStudio filmStudio;
}
