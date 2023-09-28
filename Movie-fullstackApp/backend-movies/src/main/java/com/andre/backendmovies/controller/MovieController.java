package com.andre.backendmovies.controller;


import com.andre.backendmovies.model.Movie;
import com.andre.backendmovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService service;




    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = service.findAllMovies();
        return ResponseEntity.ok().body(movies);

    }

}
