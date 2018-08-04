package com.example.learn.angular.user.controller;

import com.example.learn.angular.user.UserService;
import com.example.learn.angular.user.model.User;
import com.google.common.collect.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = Lists.newArrayList(userService.getAllUsers());
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(this.userService.addUser(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(this.userService.updateUser(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json", value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long userId) {
        this.userService.removeUser(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(this.userService.getUser(userId), HttpStatus.OK);
    }

}
