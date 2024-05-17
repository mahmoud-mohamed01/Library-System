package com.maidsTask.LibrarySystem.controller;

import com.maidsTask.LibrarySystem.dto.BookDTO;
import com.maidsTask.LibrarySystem.dto.Message;
import com.maidsTask.LibrarySystem.exception.BadRequestException;
import com.maidsTask.LibrarySystem.model.Book;
import com.maidsTask.LibrarySystem.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;


    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookDTO bookDTO, Errors errors){
        System.out.println(bookDTO);
        if (errors.hasErrors()){
            //get validation error messages
            String message=errors.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                    .collect(Collectors.joining("; "));
            throw new BadRequestException(message);
        }
        Book book=bookService.addBook(bookDTO);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id){
        Book book=bookService.getBook(id);
        return new ResponseEntity<>(book,HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<Book>>getAllBooks(){
        List<Book> books=bookService.getAllBooks();
        return new ResponseEntity<>(books,HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> updateBook(@PathVariable int id,@RequestBody BookDTO bookDTO){
       bookService.updateBook(id,bookDTO);
       return new ResponseEntity<>(new Message("book updated Succesfuly!"),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(new Message("book deleted Succesfully!"),HttpStatus.ACCEPTED);
    }


}
