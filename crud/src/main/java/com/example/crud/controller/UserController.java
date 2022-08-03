package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.User;
import com.example.crud.service.UserService;

// spring will understand that the methods in this class will follow rest convention
@RestController
@RequestMapping("/api")
public class UserController {
    // spring will create a bean when we do a autowiring
    @Autowired
    UserService userService;

    // invoking the spring-boot that this is end point /users
    // to create USER
    @RequestMapping(value="/users", method=RequestMethod.POST)
    public User createUser(@RequestBody User usr) {
        return userService.createUser(usr);
    }

    // to get all the list of Users
    @RequestMapping(value="/users", method=RequestMethod.GET)
    public List<User> readUsers() {
        return userService.getUsers();
    }

    // to update the values of USER
    @RequestMapping(value="/users/{userId}", method=RequestMethod.PUT)
    public User readUsers(@PathVariable(value = "userId") Long id, @RequestBody User empDetails) {
        return userService.updateUser(id, empDetails);
    }

    // to delete the record from the DB
    @RequestMapping(value="/users/{userId}", method=RequestMethod.DELETE)
    public void deleteUsers(@PathVariable(value = "userId") Long id) {
        userService.deleteUser(id);
    }

}