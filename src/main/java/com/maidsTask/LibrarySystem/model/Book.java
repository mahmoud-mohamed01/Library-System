package com.maidsTask.LibrarySystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 100)
    private String title;
    @Column(nullable = false,length = 80)
    private String author;
    @Column()
    private int publicationYear;
    @Column(nullable = false)
    private int isbn;
    private int quantity;

    @OneToMany(mappedBy = "book")
    @JsonManagedReference
    private List<Borrowing> borrowings;

}
