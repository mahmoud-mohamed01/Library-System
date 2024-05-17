package com.maidsTask.LibrarySystem.service;

public interface EncryptionService {

    public String encryptPassword(String pasword);
    public boolean verifyPassowrd(String password,String hash);
}
