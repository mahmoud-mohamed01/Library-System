package com.maidsTask.LibrarySystem.controller;

import com.maidsTask.LibrarySystem.dto.Message;
import com.maidsTask.LibrarySystem.exception.BadRequestException;
import com.maidsTask.LibrarySystem.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler
    ResponseEntity<Message> handelException(NotFoundException bookNotFoundException){
        Message errorMessage=new Message();
        errorMessage.setMessage(bookNotFoundException.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    ResponseEntity<Message> handelException(BadRequestException badRequestException){
        Message errorMessage=new Message();
        errorMessage.setMessage(badRequestException.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }




    @ExceptionHandler //this exception for the expected return date argument
    ResponseEntity<Message> handelException(MissingServletRequestParameterException missingParameterException){
        Message errorMessage=new Message();
        errorMessage.setMessage(missingParameterException.getMessage()+" in this format yyyy-mm-dd");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }


}
