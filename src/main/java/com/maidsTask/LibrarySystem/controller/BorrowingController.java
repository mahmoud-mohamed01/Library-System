package com.maidsTask.LibrarySystem.controller;

import com.maidsTask.LibrarySystem.exception.BadRequestException;
import com.maidsTask.LibrarySystem.model.Borrowing;
import com.maidsTask.LibrarySystem.service.BorrowingService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@AllArgsConstructor
@RestController
public class BorrowingController {
    private BorrowingService borrowingService;

    @PostMapping("/api/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<Borrowing> borrowBook(@PathVariable int bookId,
                                                @PathVariable int patronId,
                                                @RequestParam("expectedReturnDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date expectedReturnDate){

        //expectedReturnDate should be in this format "2024-6-22”
        Borrowing borrowing=borrowingService.borrowBook(bookId,patronId,expectedReturnDate);
        return new ResponseEntity<>(borrowing, HttpStatus.CREATED);
    }

    @PutMapping("/api/return/{bookId}/patron/{patronId}")
    public ResponseEntity<Borrowing> returnBook(@PathVariable int bookId,
                                                @PathVariable int patronId){
        //expectedReturnDate should be in this format "2024-6-22”
        Borrowing borrowing=borrowingService.retunrnBook(bookId,patronId);
        return new ResponseEntity<>(borrowing, HttpStatus.ACCEPTED);
    }


}
