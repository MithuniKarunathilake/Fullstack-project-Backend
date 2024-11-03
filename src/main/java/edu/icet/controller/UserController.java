package edu.icet.controller;

import edu.icet.dto.User;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    @Autowired
    final UserService service;

    @GetMapping("/get-user")
    public List<User> getUser(){
        return service.getAll();
    }

    @PostMapping("/add-user")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user){
        service.addUser(user);
    }

    @GetMapping("/search-user/{id}")
    public User getUserById(@PathVariable Integer id){
        return service.searchUserById(id);
    }

    @DeleteMapping("/delete-user/{id}")
    public void deleteUserById(@PathVariable Integer id){
        service.deleteUserById(id);
    }

    @PutMapping("/update-user")
    public void updateUser(@RequestBody User user){
        service.updateUserById(user);
    }
}
