package org.example.java_spring_boot_back_end_app.controllers;


import jakarta.validation.Valid;
import org.example.java_spring_boot_back_end_app.dto.GenreDTO;
import org.example.java_spring_boot_back_end_app.models.Genre;
import org.example.java_spring_boot_back_end_app.repositories.AuthorRepository;
import org.example.java_spring_boot_back_end_app.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/genres") //this is where we tell Spring what the base path is for all the endpoints in this controller
public class GenreController {

    //Using Autowire to use JpaRepository methods to interact with database
    @Autowired
    GenreRepository genreRepository; //I am declaring this but, I don't need to initialize since JPA will do that behind the scenes

    // Retrieve all genres
    // GET http://localhost:8080/api/genres
    @GetMapping("") //no additional path to add
    public ResponseEntity<?> getAllGenres() { //allows me to list the genres since not needing a collection, and the ? mark says that I'm not sure what will be in there ye
        List<Genre> allGenres = genreRepository.findAll();
        return new ResponseEntity<>(allGenres, HttpStatus.OK); // corresponds to the 200 response
    }

    //Save genre
    //use query parameters
    @PostMapping(value="/add", consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) //must do key value because I am adding a second one
    public ResponseEntity<?> addNewGenre(@Valid @RequestBody GenreDTO genreData) { //structuring in a way that Spring can directly translate to the model and providing validation
        Genre genre = new Genre(genreData.getTitle());
        genreRepository.save(genre);
        return new ResponseEntity<>(genre, HttpStatus.CREATED); //corresponds to 201
    }

    //Delete genre
    @DeleteMapping(value="/delete/{genreId}")
    public ResponseEntity<?> deleteGenre(@PathVariable int genreId) throws NoResourceFoundException { //adding to signature of the method
        Genre genre = genreRepository.findById(genreId).orElse(null);
        if (genre == null) {
            String path = "/api/genres/delete/" + genreId;
            throw new NoResourceFoundException(HttpMethod.DELETE, path);
        }else {
            genreRepository.deleteById(genreId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // this will throw error 204 which means it was successful
        }
    }
}
