package com.example.movies.services;

import com.example.movies.modals.Movie;
import com.example.movies.modals.Rating;
import com.example.movies.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class RatingService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MovieService movieService;
    @Autowired
    private RatingRepository ratingRepository;

    public Rating createRating(String body, String imdbId){
        Rating rating = ratingRepository.insert(new Rating(body));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("ratingIds").value(rating)).first();

        return rating;
    }


}
