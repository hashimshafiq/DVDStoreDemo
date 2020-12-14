package com.example.dvd.data.repository;

import com.example.dvd.data.entity.Movie;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    @Override
    @EntityGraph(value="Movie.movies") // entity graph solution
    Optional<Movie> findById(Long aLong);

    @Override
    @EntityGraph(value="Movie.movies") // entity graph solution
    Iterable<Movie> findAll();
}
