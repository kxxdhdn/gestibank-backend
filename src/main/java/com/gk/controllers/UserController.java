package com.gk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gk.entities.User;
import com.gk.services.UserService;

@RequestMapping("/users")
@RestController
@CrossOrigin("*")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping
  public List<User> getAllUsers() {

    return userService.users();
  }

  @PostMapping
  public User addUser(@RequestBody User user) {
    return userService.saveUser(user);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable long id) {
    userService.deleteUser(id);
  }

  @GetMapping("/{id}")
  public User getUser(@PathVariable long id) {
    return userService.getUser(id);
  }

  @PutMapping
  public User updateUser(@RequestBody User user) {
    return userService.saveUser(user);
  }

}
