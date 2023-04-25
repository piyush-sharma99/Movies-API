package com.example.movies.services;

import com.example.movies.modals.Movie;
import com.example.movies.modals.Review;
import com.example.movies.repository.MovieRepository;
import com.example.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    //Repositories are good for simple DB tasks such as findAll, findById, findBy...
    //However, they are limited on what they can do. This is where we can use templates like RestTemplate or in this case MongoTemplate

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MongoTemplate mongoTemplate; //Sometimes a Repository just does not cut it when talking to BD so we use Template

    public Review createReview(String reviewBody, String imdbId){

        Review review = reviewRepository.insert(new Review(reviewBody)); // you can only insert the type for example here we create a review of type review then inserted it

        //Using the Template to call an update on Movie class where the matching criteria is the imdbId. If correct we push our review into reviewIds property
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))//which movie are we updating?
                .apply(new Update().push("reviewIds").value(review))//Apply the update
                .first();//To make sure we only carry this out for a single movie

        return review;
    }
}
