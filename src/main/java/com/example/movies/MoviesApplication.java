package com.example.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Annotation lets the compiler know what the class does
@SpringBootApplication
public class MoviesApplication {
//Call the run method to start your application
	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

}


//Step 1: Connect to DB
//Step 2: Secure application by hiding DB credentials using ENV Files
//(To allow spring to detect .env files we need to import a dependency called spring-dotenv{look at pom file})
//Step 3: Create Modals for your DB Documents
//Step 4: Create Controller for movies
//Step 5: Create service layer and a Repository(Interface) to access the Data
