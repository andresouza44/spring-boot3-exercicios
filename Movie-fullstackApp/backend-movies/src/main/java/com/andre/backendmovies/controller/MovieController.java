package com.andre.backendmovies.controller;


import com.andre.backendmovies.model.Movie;
import com.andre.backendmovies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin("*")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = service.findAllMovies();
        return ResponseEntity.ok().body(movies);

    }
    @GetMapping(value = "/{imdbId}")
    public ResponseEntity<Movie> getSingleMovie(@PathVariable String imdbId){
        Movie movie = service.findByImdbId(imdbId);
        return ResponseEntity.ok(movie);

    }

}
