package com.maidsTask.LibrarySystem.service;

import com.maidsTask.LibrarySystem.dto.BookDTO;
import com.maidsTask.LibrarySystem.model.Book;

import java.util.List;

public interface BookService {

    Book addBook(BookDTO bookDto);
    Book getBook(Integer id);
    List<Book> getAllBooks();
    void updateBook(Integer id,BookDTO bookDTO);
    // this method used in borrowing service to update book quantity by the entity
    void updateBook(Book book);
    void deleteBook(Integer id);







}
