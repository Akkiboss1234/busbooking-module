package com.busbookingreservation.service;

import com.busbookingreservation.entity.UserRegistration;
import com.busbookingreservation.payload.UserRegistrationDto;
import com.busbookingreservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceRegistration {

  @Autowired
    private UserRepository userRepositoy;
public UserServiceRegistration createUser(UserRegistration userRegistration){
    userRepositoy.save(userRegistration);
    return null;
}


    public UserRegistration getUserById(Long id) {
        return userRepositoy.findById(id).get();
    }
}

