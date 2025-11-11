package org.example.java_spring_boot_back_end_app.repositories;

import org.example.java_spring_boot_back_end_app.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository //informing that this is a repository interface
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAuthorId(int authorId); //added this because can not delete author since it is tied to a specific book so must be able to look up if an author has a book or not
}
