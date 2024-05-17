package com.maidsTask.LibrarySystem.service.impl;

import com.maidsTask.LibrarySystem.exception.BadRequestException;
import com.maidsTask.LibrarySystem.exception.NotFoundException;
import com.maidsTask.LibrarySystem.model.Book;
import com.maidsTask.LibrarySystem.model.Borrowing;
import com.maidsTask.LibrarySystem.model.Patron;
import com.maidsTask.LibrarySystem.repository.BorrowingRepository;
import com.maidsTask.LibrarySystem.service.BookService;
import com.maidsTask.LibrarySystem.service.BorrowingService;
import com.maidsTask.LibrarySystem.service.PatronService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
@AllArgsConstructor
public class BorrowingServiceImpl implements BorrowingService {
    private BorrowingRepository borrowingRepository;
    private BookService bookService;
    private PatronService patronService;

    @Override
    public Borrowing borrowBook(Integer bookId, Integer patronId,Date expectedReturnDate) {


       Book book =bookService.getBook(bookId);
       //check availability of the book
       if (book.getQuantity()<=0){
           throw new BadRequestException("Book is out of stock and unavailable");
       }
       Patron patron=patronService.getPatron(patronId);

       // if user already rented this book
      if (borrowingRepository.findByPatronAndBook(patron,book).isPresent()){
          throw new  BadRequestException("user already rented this book with this id: "+bookId);
      }

       Borrowing borrowing=new Borrowing();
       borrowing.setBook(book);
       borrowing.setPatron(patron);
       borrowing.setExcepctedReturnDate(expectedReturnDate);
       borrowingRepository.save(borrowing);

       //update book quantity
       book.setQuantity(book.getQuantity()-1);
       bookService.updateBook(book);


       return borrowing;

    }

    @Override
    public Borrowing retunrnBook(Integer bookId, Integer patronId) {
        Book book=bookService.getBook(bookId);
        Patron patron =patronService.getPatron(patronId);
        Borrowing borrowingRecord=borrowingRepository.findByPatronAndBook(patron,book).
                orElseThrow(()-> new NotFoundException("no borrowing records with this ids"));

        if (borrowingRecord.getActualReturnDate()!=null){
            throw new BadRequestException("book is already returned");
        }
        borrowingRecord.setActualReturnDate(new Date());
        borrowingRepository.save(borrowingRecord);
        return borrowingRecord;
    }
}
