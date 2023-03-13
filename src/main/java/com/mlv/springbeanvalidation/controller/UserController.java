package com.mlv.springbeanvalidation.controller;

import com.mlv.springbeanvalidation.dto.UserRequestData;
import com.mlv.springbeanvalidation.entity.Users;
import com.mlv.springbeanvalidation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<Users> createUser(@RequestBody @Valid UserRequestData userRequestData){
        return new ResponseEntity<>(userService.saveUsers(userRequestData), HttpStatus.CREATED);
    }

    @GetMapping("/getUserById")
    public Optional<Users> getUserById(@RequestParam(name = "id") Integer id) throws NoSuchElementException {

       return userService.getUserByID(id);
    }
}
