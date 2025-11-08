package org.example.java_spring_boot_back_end_app.controllers;


import jakarta.validation.Valid;
import org.example.java_spring_boot_back_end_app.dto.BookDTO;
import org.example.java_spring_boot_back_end_app.models.Author;
import org.example.java_spring_boot_back_end_app.models.Book;
import org.example.java_spring_boot_back_end_app.models.Genre;
import org.example.java_spring_boot_back_end_app.repositories.AuthorRepository;
import org.example.java_spring_boot_back_end_app.repositories.BookRepository;
import org.example.java_spring_boot_back_end_app.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/books") //this is where we tell Spring what the base path is for all the endpoints in this controller
public class BookController {

    //Using Autowire to use JpaRepository methods to interact with database
    @Autowired
    BookRepository bookRepository; //I am declaring this but, I don't need to initialize since JPA will do that behind the scenes

    //need access to the Author Repository
    @Autowired
    AuthorRepository authorRepository;

    //need access to the Genre Repository
    @Autowired
    GenreRepository genreRepository;


    // Retrieve all books
    // GET http://localhost:8080/api/books
    @GetMapping("") //no additional path to add
    public ResponseEntity<?> getAllBooks() { //allows me to list the books since not needing a collection, and the ? mark says that I'm not sure what will be in there yet
        // For demonstration purposes, returning a static list of books
       List<Book> allBooks = bookRepository.findAll();
       return new ResponseEntity<>(allBooks, HttpStatus.OK); // corresponds to the 200 response
    }

    //Returning book object from database or using null if not found
    //Retrieve a specific book
    @GetMapping(value="/details/{bookId}", produces =MediaType.APPLICATION_JSON_VALUE ) //path variable
    public ResponseEntity<?> getBookById(@PathVariable int bookId) throws NoResourceFoundException {
        Book book =  bookRepository.findById(bookId).orElse(null); //returning object and Spring returns it as a JSON
        if (book == null) {
            String path = "/api/books/details/" + bookId;
            throw new NoResourceFoundException(HttpMethod.GET, path); //? allows for me to send anything back in the body and will produce a 404
        } else {
            return new ResponseEntity<>(book, HttpStatus.OK); //this will return as 200 ok
        }
    }

    //Save book
    //use query parameters
    @PostMapping(value="/add", consumes=MediaType.APPLICATION_JSON_VALUE) //must do key value because I am adding a second one
    public ResponseEntity<?> addNewBook(@Valid @RequestBody BookDTO bookData) { //structuring in a way that Spring can directly translate to the model and providing validation
        Author author = authorRepository.findById(bookData.getAuthorId()).orElse(null);
        List<Genre> genres = new ArrayList<>();
        for (int genreId : bookData.getGenreIds()) {
           Genre genre = genreRepository.findById(genreId).orElse(null);
           if (genre != null) {
               genres.add(genre);
           }
        }
        Book book = new Book(bookData.getTitle(), author, bookData.getDescription(), genres, bookData.isTrending(), bookData.getSalePrice(), bookData.getOriginalPrice());
        bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED); //corresponds to 201
    }

    //Delete book
    @DeleteMapping(value="/delete/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteBook(@PathVariable int bookId) throws NoResourceFoundException { //adding to signature of the method
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null) {
            String path = "/api/books/delete/" + bookId;
            throw new NoResourceFoundException(HttpMethod.DELETE, path);
        }else {
            bookRepository.deleteById(bookId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // this will throw error 204 which means it was successful
        }
    }

    //Update book


}
