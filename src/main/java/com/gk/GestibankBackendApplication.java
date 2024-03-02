package com.gk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gk.entities.ERole;
import com.gk.entities.Role;
import com.gk.repositories.RoleRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class GestibankBackendApplication {

  @Autowired
  RoleRepository roleRepository;

  @PostConstruct
  private void initRole() {
    roleRepository.save(new Role(ERole.CLIENT));
    roleRepository.save(new Role(ERole.USER));
    roleRepository.save(new Role(ERole.AGENT));
    roleRepository.save(new Role(ERole.ADMIN));
  }

  public static void main(String[] args) {
    SpringApplication.run(GestibankBackendApplication.class, args);
  }

}
