package com.avo.avocado.controllers;

import com.avo.avocado.services.UserService;
import com.avo.avocado.utils.Exceptions.UserNotFoundException;
import com.avo.avocado.utils.dtos.UserDTO;
import com.avo.avocado.utils.entites.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResponseEntity<UserResponse> login(@RequestBody UserDTO userLogin) throws UserNotFoundException {
        return  userService.login(userLogin);
    }

    @PostMapping("signup")
    public ResponseEntity<UserResponse> signup(@RequestBody UserDTO userSignup) {
        return userService.signup(userSignup);
    }

}
