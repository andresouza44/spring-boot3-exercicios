package com.andre.backendmovies.service;


import com.andre.backendmovies.model.Movie;
import com.andre.backendmovies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> findAllMovies(){
        return repository.findAll();
    }

    public String get(){
        return "get servive;";
    }

}
