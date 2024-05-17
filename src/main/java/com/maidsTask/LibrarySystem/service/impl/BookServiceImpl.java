package com.maidsTask.LibrarySystem.service.impl;

import com.maidsTask.LibrarySystem.dto.BookDTO;
import com.maidsTask.LibrarySystem.exception.NotFoundException;
import com.maidsTask.LibrarySystem.mapper.BookMapper;
import com.maidsTask.LibrarySystem.model.Book;
import com.maidsTask.LibrarySystem.repository.BookRepository;
import com.maidsTask.LibrarySystem.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Override
    public Book addBook(BookDTO bookDto) {
        Book book= BookMapper.mapToBook(bookDto);
        return bookRepository.save(book);
    }

    @Override
    public Book getBook(Integer id) {
        Book book=bookRepository.findById(id).
                orElseThrow(()->new NotFoundException("not found book with this id :"+ id));
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
     return bookRepository.findAll();
    }

    @Override
    public void updateBook(Integer id,BookDTO bookDTO) {
        Book book=bookRepository.findById(id).
                orElseThrow(()->new NotFoundException("not found book with this id :"+ id));
        //check the existing fields before update
        book.setTitle(bookDTO.getTitle()!=null?bookDTO.getTitle():book.getTitle());
        book.setQuantity(bookDTO.getQuantity()!=0?bookDTO.getQuantity():book.getQuantity());
        book.setPublicationYear(bookDTO.getPublicationYear()!=0?bookDTO.getPublicationYear():book.getPublicationYear());
        book.setIsbn(bookDTO.getIsbn()!=0?bookDTO.getIsbn():book.getIsbn());
        book.setAuthor(bookDTO.getAuthor()!=null?bookDTO.getAuthor():book.getAuthor());
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id) {
        Book book=bookRepository.findById(id).
                orElseThrow(()->new NotFoundException("not found book with this id :"+ id));
        bookRepository.deleteById(id);
    }
}
