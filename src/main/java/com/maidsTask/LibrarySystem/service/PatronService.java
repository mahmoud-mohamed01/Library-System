package com.maidsTask.LibrarySystem.service;

import com.maidsTask.LibrarySystem.dto.BookDTO;
import com.maidsTask.LibrarySystem.dto.LoginDTO;
import com.maidsTask.LibrarySystem.dto.PatronDTO;
import com.maidsTask.LibrarySystem.model.Book;
import com.maidsTask.LibrarySystem.model.Patron;

import java.util.List;

public interface PatronService {
    Patron addPatron(PatronDTO patronDTO);
    Patron getPatron(Integer id);
    List<Patron> getAllPatrons();
    void updatePatron(Integer id, PatronDTO patronDTO);
    void deletePatron(Integer id);

    public String loginPatron(LoginDTO loginDTO);

}
