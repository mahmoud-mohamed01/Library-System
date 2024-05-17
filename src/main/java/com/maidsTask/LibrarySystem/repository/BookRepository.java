package com.maidsTask.LibrarySystem.repository;

import com.maidsTask.LibrarySystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
