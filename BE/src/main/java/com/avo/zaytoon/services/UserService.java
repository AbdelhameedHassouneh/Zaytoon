package com.avo.zaytoon.services;

import com.avo.zaytoon.repositories.UserRepository;
import com.avo.zaytoon.utils.dtos.UserDTO;
import com.avo.zaytoon.utils.entites.UserResponse;
import com.avo.zaytoon.utils.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<UserResponse> login(UserDTO userLogin) {
        User user = userRepository.findByEmail(userLogin.getEmail());
        if (user != null){
            if (user.getPassword().compareTo(userLogin.getPassword())==0){
                UserResponse userResponse = new UserResponse();
                userResponse.setEmail(user.getEmail());
                userResponse.setFirst_name(user.getFirstName());
                userResponse.setGender(user.getGender());
                userResponse.setLast_name(user.getLastName());
                userResponse.setHeight(user.getHeight());
                userResponse.setWeight(user.getWeight());
                userResponse.setPhone(user.getPhone());
                userResponse.setId(user.getId());
                userResponse.setAge(user.getAge());
                return new ResponseEntity<>(userResponse, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<UserResponse> signup(UserDTO userSignup){
        User user = userRepository.findByEmail((userSignup.getEmail()));
        if (user == null) {
            User newUser = new User();
            newUser.setPassword(userSignup.getPassword());
            newUser.setAge(userSignup.getAge());
            newUser.setEmail(userSignup.getEmail());
            newUser.setGender(userSignup.getGender());
            newUser.setHeight(userSignup.getHeight());
            newUser.setPhone(userSignup.getPhone());
            newUser.setWeight(userSignup.getWeight());
            newUser.setFirstName(userSignup.getFirst_name());
            newUser.setLastName(userSignup.getLast_name());
            if (userRepository.save(newUser) != null) {
                UserResponse userResponse = new UserResponse();
                userResponse.setEmail(newUser.getEmail());
                userResponse.setFirst_name(newUser.getFirstName());
                userResponse.setGender(newUser.getGender());
                userResponse.setLast_name(newUser.getLastName());
                userResponse.setHeight(newUser.getHeight());
                userResponse.setWeight(newUser.getWeight());
                userResponse.setPhone(newUser.getPhone());
                userResponse.setId(newUser.getId());
                userResponse.setAge(newUser.getAge());
                return new ResponseEntity<>(userResponse,HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    public ResponseEntity<UserResponse> editUser(UserDTO userEdit) {
        User user = userRepository.findById(userEdit.getId());
        try {
            user.setLastName(userEdit.getLast_name());
            user.setWeight(userEdit.getWeight());
            user.setHeight(userEdit.getHeight());
            user.setFirstName(userEdit.getFirst_name());
            user.setGender(userEdit.getGender());
            user.setAge(userEdit.getAge());
            user.setEmail(userEdit.getEmail());
            userRepository.save(user);
        } catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        UserResponse userResponse = new UserResponse();
        userResponse.setAge(user.getAge());
        userResponse.setHeight(user.getHeight());
        userResponse.setWeight(user.getWeight());
        userResponse.setGender(user.getGender());
        userResponse.setPhone(user.getPhone());
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirst_name(user.getFirstName());
        userResponse.setLast_name(user.getLastName());
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }
}

