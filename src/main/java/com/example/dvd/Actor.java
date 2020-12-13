package com.example.dvd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

    private String id;
    private String name;
    private boolean wonOscar;
    private String birthday;
}
