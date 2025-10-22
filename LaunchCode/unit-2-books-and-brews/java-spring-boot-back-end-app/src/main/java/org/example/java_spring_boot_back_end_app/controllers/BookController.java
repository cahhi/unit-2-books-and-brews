package org.example.java_spring_boot_back_end_app.controllers;


import org.example.java_spring_boot_back_end_app.data.BookData;
import org.example.java_spring_boot_back_end_app.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/books") //this is where we tell Spring what the base path is for all the endpoints in this controller
public class BookController {

    // Retrieve all books
    // GET http://localhost:8080/api/books
    @GetMapping("") //no additional path to add
    public Collection<Book> getAllBooks() {
        // For demonstration purposes, returning a static list of books
       return BookData.getAll();
    }

    //Retrieve a specific book


    //Save book
    //use query parameters
    @PostMapping("/add")
    public String addNewBook(@RequestParam String title, String author, int isbn, String description) {
        Book newBook = new Book(title, author, isbn, description);
        BookData.addNewBook(newBook);
        return "Book added successfully: " + newBook;
    }


}
