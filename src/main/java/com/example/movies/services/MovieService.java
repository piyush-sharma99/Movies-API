package com.example.movies.services;

import com.example.movies.modals.Movie;
import com.example.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Let framework know this is a Service
public class MovieService {

    @Autowired  //Lets framework know to Instantiate this class for us. So we do not need constructor init ect for this
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    //If there is no movie we will return null. Optional allows us to cover that condition
    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
