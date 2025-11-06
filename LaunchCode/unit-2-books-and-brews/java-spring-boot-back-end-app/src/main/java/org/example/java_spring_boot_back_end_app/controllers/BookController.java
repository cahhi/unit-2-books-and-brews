package org.example.java_spring_boot_back_end_app.controllers;


import org.example.java_spring_boot_back_end_app.models.Book;
import org.example.java_spring_boot_back_end_app.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/books") //this is where we tell Spring what the base path is for all the endpoints in this controller
public class BookController {

    //Using Autowire to use JpaRepository methods to interact with database
    @Autowired
    BookRepository bookRepository; //I am declaring this but, I don't need to initialize since JPA will do that behind the scenes


    // Retrieve all books
    // GET http://localhost:8080/api/books
    @GetMapping("") //no additional path to add
    public List<?> getAllBooks() { //allows me to list the books since not needing a collection, and the ? mark says that I'm not sure what will be in there yet
        // For demonstration purposes, returning a static list of books
       return bookRepository.findAll();
    }

    //Returning book object from database or using null if not found
    //Retrieve a specific book
    @GetMapping("/details/{bookId}") //path variable
    public Book getBookById(@PathVariable int bookId) {
        return bookRepository.findById(bookId).orElse(null); //returning object and Spring returns it as a JSON
    }

    //Save book
    //use query parameters
    @PostMapping("/add")
    public String addNewBook(@RequestParam String title, String author, String description, String genre, Boolean isTrending, float salePrice, float originalPrice) { //will refactor later
        Book newBook = new Book(title, author, description, genre, isTrending, salePrice, originalPrice);
        bookRepository.save(newBook);
        return "Book added successfully: " + newBook;
    }


}
