package com.avo.zaytoon.controllers;

import com.avo.zaytoon.services.UserService;
import com.avo.zaytoon.utils.Exceptions.UserNotFoundException;
import com.avo.zaytoon.utils.dtos.UserDTO;
import com.avo.zaytoon.utils.entites.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("edit")
    public ResponseEntity<UserResponse> editUser(@RequestBody UserDTO userEdit) {
        return userService.editUser(userEdit);
    }

}
