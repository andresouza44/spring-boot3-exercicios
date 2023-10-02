package com.andre.backendmovies.controller;


import com.andre.backendmovies.model.Review;
import com.andre.backendmovies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value="/api/v1/review")
@CrossOrigin("*")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        Review review = service.creatReview(payload.get("reviewBody"), payload.get("imdbId"));
        return ResponseEntity.status(HttpStatus.CREATED).body(review);

    }
}
