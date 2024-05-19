package com.maidsTask.LibrarySystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "patron_id",nullable = false)
    @JsonBackReference
    private Patron patron;
    @ManyToOne()
    @JoinColumn(name = "book_id",nullable = false)
    @JsonBackReference
    private Book book;

    @CreationTimestamp
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date borrowingDate;
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date excepctedReturnDate;
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date actualReturnDate;
}
