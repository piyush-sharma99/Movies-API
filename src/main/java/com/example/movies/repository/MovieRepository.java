package com.example.movies.repository;

import com.example.movies.modals.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//This is a repository used to get data from DB. We do similar for JPA using JPARepository.
//We pass DB Document(noSQL)/Table(SQL) modal here with the ID type
@Repository //So the framework knows this is a repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    //Spring framework is so smart that if you want to mind anything by a specific input all you have to do is below
    //Spring framework is smart enough to determine we are trying to query something by the following param and it does the rest for us!!!!!
    Optional<Movie> findMovieByImdbId(String imdbId);
    //We can use examples like above to create custom methods to get data by specific property as long as the property are unique
}
