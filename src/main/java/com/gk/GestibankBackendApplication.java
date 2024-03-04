package com.gk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gk.entities.ERole;
import com.gk.entities.Role;
import com.gk.repositories.RoleRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class GestibankBackendApplication implements ApplicationRunner {

  @Autowired
  RoleRepository roleRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    if (roleRepository.count() == 0) {
      roleRepository.save(new Role(ERole.USER));
      roleRepository.save(new Role(ERole.SUPER_ADMIN));
      roleRepository.save(new Role(ERole.ADMIN));
      roleRepository.save(new Role(ERole.AGENT));
      roleRepository.save(new Role(ERole.CLIENT));
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(GestibankBackendApplication.class, args);
  }

}
