package com.example.movies.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;
//THIS IS A MODAL
//Here we are basically creating the structure of our DB Document(not table because noSQL).
//Letting the project know key details like what is the collection we are looking at. What each document looks like in that collection


//This "Document" annotation spring know this class represents each document in the movies collection[this is the collection in database] (Like in JPA we use @Table @Column ect)
@Document(collection = "movies")
@Data //Takes care of getters/setters part of Lombok
@AllArgsConstructor //Takes care of constructor that takes all arguments part of Lombok
@NoArgsConstructor //Takes care of constructor that takes no arguments part of Lombok
public class Movie {
    @Id // Lets project know the below is the ID per movie  // this auto generates an ID
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference
    private List<Review> reviewIds;
    //The above can be an embedded relationship which means all reviews will be added to movies collection under each movie (So the revieIds will be a list of reviews)
    //Or we use @DocumentReference which will create a new collection and store reviews there. Only Ids will be stored in the above array


}
