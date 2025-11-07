package org.example.java_spring_boot_back_end_app.repositories;

import org.example.java_spring_boot_back_end_app.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //informing that this is a repository interface
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}