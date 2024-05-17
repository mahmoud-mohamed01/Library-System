package com.maidsTask.LibrarySystem.repository;

import com.maidsTask.LibrarySystem.model.Book;
import com.maidsTask.LibrarySystem.model.Borrowing;
import com.maidsTask.LibrarySystem.model.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowingRepository extends JpaRepository<Borrowing,Integer> {
    Optional<Borrowing> findByPatronAndBook(Patron patron, Book book);
}
