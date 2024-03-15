package com.busbookingreservation.controller;


import com.busbookingreservation.entity.UserRegistration;

import com.busbookingreservation.payload.UserRegistrationDto;
import com.busbookingreservation.service.UserServiceRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/vi/user")
public class UserRegistrationController {
    @Autowired
   private UserServiceRegistration userServiceRegistration;

    @PostMapping
    public String createUser(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
                             @RequestParam("profilepicture") MultipartFile profilePicture) {
        try {
            UserRegistration userRegistration = new UserRegistration();
            userRegistration.setName(name);
            userRegistration.setEmail(email);
            userRegistration.setPassword(password);
            userRegistration.setProfilepicture(profilePicture.getBytes());

            // You can perform any necessary validation or business logic here

            userServiceRegistration.createUser(userRegistration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "done";
    }
    @GetMapping("/{id}")
 public ResponseEntity<UserRegistration> getUserById(@PathVariable Long id){

     UserRegistration users = userServiceRegistration.getUserById(id);
     return new ResponseEntity<>(users,HttpStatus.OK);

 }

}
