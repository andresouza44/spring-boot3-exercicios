package com.andre.backendmovies.repository;

import com.andre.backendmovies.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
}
