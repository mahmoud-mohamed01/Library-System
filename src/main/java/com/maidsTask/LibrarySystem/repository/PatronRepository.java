package com.maidsTask.LibrarySystem.repository;

import com.maidsTask.LibrarySystem.model.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron,Integer> {
}
