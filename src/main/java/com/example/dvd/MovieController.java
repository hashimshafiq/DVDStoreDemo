package com.example.dvd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/movies")
public class MovieController {


    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;

    }

    @GetMapping
    public String getMovies(Model model){

        log.info("Client requested all movies");

        model.addAttribute("movies", this.movieRepository.findAll());
        model.addAttribute("movie", new Movie());

        return "movies";

    }

    @PostMapping
    public String processMovie(@Valid Movie movie, Errors errors, Model model){

        log.info("... new movie" + movie);

        if (errors.hasErrors()){
            model.addAttribute("movies", this.movieRepository.findAll());
            log.info("... but there are errors included" + movie);
            return "movies";
        }else {
            movie.setId("" + (this.movieRepository.count()+1));
            this.movieRepository.save(movie);

            return "redirect:/movies";
        }


    }
}