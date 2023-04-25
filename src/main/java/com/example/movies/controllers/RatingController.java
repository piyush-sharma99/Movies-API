package com.example.movies.controllers;

import com.example.movies.modals.Rating;
import com.example.movies.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;


    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Map<String,String> payload){

        return new ResponseEntity<Rating>(ratingService.createRating(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);

    }
}
