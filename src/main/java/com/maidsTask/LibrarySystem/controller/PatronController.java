package com.maidsTask.LibrarySystem.controller;

import com.maidsTask.LibrarySystem.dto.BookDTO;
import com.maidsTask.LibrarySystem.dto.Message;
import com.maidsTask.LibrarySystem.dto.PatronDTO;
import com.maidsTask.LibrarySystem.exception.BadRequestException;
import com.maidsTask.LibrarySystem.model.Book;
import com.maidsTask.LibrarySystem.model.Patron;
import com.maidsTask.LibrarySystem.service.PatronService;
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
@RequestMapping("/api/patrons")
public class PatronController {
   private PatronService patronService;

    @PostMapping
    public ResponseEntity<Patron> addBook(@Valid @RequestBody PatronDTO patronDTO, Errors errors){
        System.out.println(patronDTO);
        if (errors.hasErrors()){
            //get validation error messages
            String message=errors.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                    .collect(Collectors.joining("; "));
            throw new BadRequestException(message);
        }
        Patron patron=patronService.addPatron(patronDTO);
        return new ResponseEntity<>(patron, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patron> getBook(@PathVariable int id){
        Patron patron=patronService.getPatron(id);
        return new ResponseEntity<>(patron,HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<Patron>>getAllBooks(){
        List<Patron> patrons=patronService.getAllPatrons();
        return new ResponseEntity<>(patrons,HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> updateBook(@PathVariable int id, @RequestBody PatronDTO patronDTO){
        patronService.updatePatron(id,patronDTO);
        return new ResponseEntity<>(new Message("patron updated Succesfuly!"),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> deleteBook(@PathVariable int id){
        patronService.deletePatron(id);
        return new ResponseEntity<>(new Message("patron deleted Succesfully!"),HttpStatus.ACCEPTED);
    }
}
