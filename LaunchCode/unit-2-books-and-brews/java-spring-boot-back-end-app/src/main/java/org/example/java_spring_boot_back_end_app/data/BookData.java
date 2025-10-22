package org.example.java_spring_boot_back_end_app.data;

import org.example.java_spring_boot_back_end_app.models.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookData {

    //Temporary Representation of book data storage
    private static final Map<Integer, Book> books = new HashMap<>();

    //Temporary method for CRUD operations

    public static Collection<Book> getAll() {
        return books.values();
    }

    public static void addNewBook(Book book) {
        books.put(book.getId(), book);
    }

    public static Book getById(int id) {
        return books.get(id);
    }
}
