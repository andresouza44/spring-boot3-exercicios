package com.andre.backendmovies.service;


import com.andre.backendmovies.model.Movie;
import com.andre.backendmovies.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> findAllMovies(){
        return repository.findAll();
    }

    public Movie findByImdbId(String imdbId){
        Optional<Movie> opt = repository.findMovieByImdbId(imdbId);
        return opt.get();

    }

}
