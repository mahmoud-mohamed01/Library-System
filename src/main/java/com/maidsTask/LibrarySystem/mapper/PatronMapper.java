package com.maidsTask.LibrarySystem.mapper;

import com.maidsTask.LibrarySystem.dto.BookDTO;
import com.maidsTask.LibrarySystem.dto.PatronDTO;
import com.maidsTask.LibrarySystem.model.Book;
import com.maidsTask.LibrarySystem.model.Patron;

public class PatronMapper {

    public static Patron mapToPatron(PatronDTO patronDTO) {
      Patron patron=new Patron();
      patron.setEmail(patronDTO.getEmail());
      patron.setName(patronDTO.getName());
      patron.setPassword(patronDTO.getPassword());
      patron.setContactInformation(patronDTO.getContactInformation());
      return patron;

    }


    public static PatronDTO mapToPatronDTO(Patron patron) {
        return new PatronDTO(
                patron.getName(),
                patron.getEmail(),
                patron.getPassword(),
                patron.getContactInformation()
        );


    }
}
