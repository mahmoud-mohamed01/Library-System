package com.maidsTask.LibrarySystem.mapper;

import com.maidsTask.LibrarySystem.dto.BookDTO;
import com.maidsTask.LibrarySystem.model.Book;

public class BookMapper {

    public static Book mapToBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setQuantity(bookDTO.getQuantity());
        book.setPublicationYear(bookDTO.getPublicationYear());
        return book;

    }


    public static BookDTO mapToProductDto(Book book) {

      return new BookDTO(
              book.getTitle(),
              book.getAuthor(),
              book.getPublicationYear(),
              book.getIsbn(),
              book.getQuantity()
      );

    }

}
