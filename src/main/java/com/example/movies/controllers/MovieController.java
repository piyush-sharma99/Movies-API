package com.example.movies.controllers;

import com.example.movies.services.MovieService;
import com.example.movies.modals.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired // Tells framework to Instantiate this class for us
    private MovieService movieService;

    @GetMapping
    //ResponseEntity is the best way to return api responses as it allows us to handle things like HttpStatus codes ect which are very beneficial from a dev prospective
    public ResponseEntity<List<Movie>> getAllMovies() {
        //Calling the service that calls upon the Repository interface that uses the Modal and MongoDB connection to get the data
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    //Passing "id" param in url and we detect it using PathVariable
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){

        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }

}
