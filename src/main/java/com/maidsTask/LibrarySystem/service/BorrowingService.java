package com.maidsTask.LibrarySystem.service;

import com.maidsTask.LibrarySystem.model.Borrowing;

import java.util.Date;

public interface BorrowingService {
    Borrowing borrowBook(Integer bookId, Integer PatronId, Date expectedReturnDate);
    Borrowing retunrnBook(Integer bookId,Integer PatronId);

}
