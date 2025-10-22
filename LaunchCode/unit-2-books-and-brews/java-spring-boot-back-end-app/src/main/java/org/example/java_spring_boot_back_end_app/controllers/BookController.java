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
    @GetMapping("/details/{bookId}") //path variable
    public Book getBookById(@PathVariable int bookId) {
        return BookData.getById(bookId); //returning object and Spring returns it as a JSON
    }

    //Retrieve a specific book and return as HTML
    @GetMapping("/details/{bookId}/html") //path variable
    public String displayBookDetails(@PathVariable int bookId) {
        Book book = BookData.getById(bookId);
        return "<h2>Book</h2>" + //returning object and Spring returns it as HTML
               "<p><b>ID:</b> " + book.getId() + "</p>" +
                "<p><b>Title:</b> " + book.getTitle() + "</p>" +
                "<p><b>Author:</b> " + book.getAuthor() + "</p>" +
                "<p><b>ISBN:</b> " + book.getIsbn() + "</p>" +
                "<p><b>Description:</b> " + book.getDescription() + "</p>";
    }

    //Save book
    //use query parameters
    @PostMapping("/add")
    public String addNewBook(@RequestParam String title, String author, long isbn, String description) {
        Book newBook = new Book(title, author, isbn, description);
        BookData.addNewBook(newBook);
        return "Book added successfully: " + newBook;
    }


}
