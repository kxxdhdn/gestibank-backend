package com.gk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.entities.User;
import com.gk.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public List<User> users() {
    return (List<User>) userRepository.findAll();
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public void deleteUser(long id) {
    userRepository.deleteById(id);
  }

  public User getUser(long id) {
    return userRepository.findById(id).get();
  }

}
