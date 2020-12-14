package com.example.dvd;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Title must be set")
    @NotEmpty(message = "Title not there")
    private String title;

    private boolean wonOscar;

    @Min(value = 1920, message = "Movies before 1920 are not considered")
    @Max(value = 2025, message = "Movies after 2025 are not planned yet")
    private int year;

    @NotNull
    @Pattern(regexp = "(https:\\/\\/).*\\.(?:jpg|gif|png)"
            , message = "Must a valid URL to a picture")
    private String coverImage;


}
