package com.maidsTask.LibrarySystem.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BorrowingKey {
    Integer patronId;
    Integer bookId;

}
