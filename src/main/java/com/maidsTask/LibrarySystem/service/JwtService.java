package com.maidsTask.LibrarySystem.service;

import com.maidsTask.LibrarySystem.model.Patron;

public interface JwtService {
    String generateJwt(Patron patron);
    String getEmail(String token);
}
