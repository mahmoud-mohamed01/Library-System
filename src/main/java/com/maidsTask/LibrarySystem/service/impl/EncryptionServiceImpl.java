package com.maidsTask.LibrarySystem.service.impl;

import com.maidsTask.LibrarySystem.service.EncryptionService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements EncryptionService {
    @Value("${encryption.salt.rounds}")
    private int saltRounds;
    private String salt;

    @PostConstruct
    public void postConstruct(){
        salt= BCrypt.gensalt(saltRounds);
    }

    @Override
    public String encryptPassword(String pasword){
        return BCrypt.hashpw(pasword,salt);
    }

    @Override
    public boolean verifyPassowrd(String password,String hash){
        return BCrypt.checkpw(password,hash);
    }
}
