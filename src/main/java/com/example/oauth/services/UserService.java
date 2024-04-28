package com.example.oauth.services;


import com.example.oauth.models.Token;
import com.example.oauth.models.User;
import com.example.oauth.repository.TokenRepositroy;
import com.example.oauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenRepositroy tokenRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public User signup(String name, String email, String password) {

        User user= new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);
    }

    public Token login(String email, String password) {
        Optional<User> userOptional=userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Invalid userOptional or password");
        }
        User user=userOptional.get();
        if (! bCryptPasswordEncoder.matches(password,user.getPassword())) {
            throw new RuntimeException("Invalid userOptional or password");
        }
        Token token = new Token();
        token.setValue(UUID.randomUUID().toString());

        token.setUser(user);
        token.setValue(UUID.randomUUID().toString());

        Date expiredDate = getExpiredDate();

        token.setExpireAt(expiredDate);

        return tokenRepository.save(token);
    }
    private Date getExpiredDate() {

        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(new Date());


        //add(Calendar.DAY_OF_MONTH, -5).
        calendarDate.add(Calendar.DAY_OF_MONTH, 30);

        Date expiredDate = calendarDate.getTime();
        return expiredDate;

    }
}
