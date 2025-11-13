package org.example.java_spring_boot_back_end_app.controllers;

import jakarta.validation.Valid;
import org.example.java_spring_boot_back_end_app.dto.AuthorDTO;
import org.example.java_spring_boot_back_end_app.models.Author;
import org.example.java_spring_boot_back_end_app.repositories.AuthorRepository;
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

//Trying to enable CORS for this specific controller as a test
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/authors") //this is where we tell Spring what the base path is for all the endpoints in this controller
public class AuthorController {


    //Using Autowire to use JpaRepository methods to interact with database
    @Autowired
    AuthorRepository authorRepository; //I am declaring this but, I don't need to initialize since JPA will do that behind the scenes


    // Retrieve all authors
    // GET http://localhost:8080/api/authors
    @GetMapping("") //no additional path to add
    public ResponseEntity<?> getAllAuthors() { //allows me to list the authors since not needing a collection, and the ? mark says that I'm not sure what will be in there yet
        // For demonstration purposes, returning a static list of authors
        List<Author> allAuthors = authorRepository.findAll();
        return new ResponseEntity<>(allAuthors, HttpStatus.OK); // corresponds to the 200 response
    }

    //Returning author object from database or using null if not found
    //Retrieve a specific author
    @GetMapping(value="/details/{authorId}", produces =MediaType.APPLICATION_JSON_VALUE ) //path variable
    public ResponseEntity<?> getAuthorById(@PathVariable int authorId) throws NoResourceFoundException {
       Author author =  authorRepository.findById(authorId).orElse(null); //returning object and Spring returns it as a JSON
        if (author == null) {
            String path = "/api/authors/details/" + authorId;
            throw new NoResourceFoundException(HttpMethod.GET, path); //? allows for me to send anything back in the body and will produce a 404
        } else {
            return new ResponseEntity<>(author, HttpStatus.OK); //this will return as 200 ok
        }
    }

    //Save author
    //use query parameters
    @PostMapping(value="/add", consumes=MediaType.APPLICATION_JSON_VALUE) //must do key value because I am adding a second one
    public ResponseEntity<?> addNewAuthor(@Valid @RequestBody AuthorDTO authorData) { //structuring in a way that Spring can directly translate to the model and providing validation
        Author author = new Author(authorData.getFirstName(), authorData.getLastName());
        authorRepository.save(author);
        return new ResponseEntity<>(author, HttpStatus.CREATED); //corresponds to 201
    }

    //Delete author
    @DeleteMapping(value="/delete/{authorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteAuthor(@PathVariable int authorId) throws NoResourceFoundException { //adding to signature of the method
       Author author = authorRepository.findById(authorId).orElse(null);
        if (author == null) {
            String path = "/api/authors/delete/" + authorId;
            throw new NoResourceFoundException(HttpMethod.DELETE, path);
        }else {
            authorRepository.deleteById(authorId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // this will throw error 204 which means it was successful
        }
    }

    //Update author
    @PutMapping(value = "/update/{authorId}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateAuthor(@PathVariable int authorId, @RequestBody AuthorDTO authorData) {
        Author author = authorRepository.findById(authorId).orElse(null);

        author.setFirstName(authorData.getFirstName());
        author.setLastName(authorData.getLastName());

        Author updateAuthors = authorRepository.save(author);
        return new ResponseEntity<>(updateAuthors, HttpStatus.OK);
    }


}
