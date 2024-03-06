package com.gk.controllers;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.gk.entities.ERole;
import com.gk.entities.Role;
import com.gk.entities.User;
import com.gk.jwt.JwtUtils;
import com.gk.models.request.LoginRequest;
import com.gk.models.request.SignupRequest;
import com.gk.models.response.JwtResponse;
import com.gk.models.response.MessageResponse;
import com.gk.repositories.RoleRepository;
import com.gk.repositories.UserRepository;
import com.gk.services.UserDetailsImpl;

import jakarta.validation.Valid;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

  @Autowired
  AuthenticationManager authenticationManager;
  @Autowired
  UserRepository userRepository;
  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;
  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(
      @Valid @RequestBody SignupRequest signUpRequest) {

    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body(
          new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getUsername(),
        signUpRequest.getEmail(),
        encoder.encode(signUpRequest.getPassword()));

    // Récupération du reste des champs
    Set<String> strRoles = signUpRequest.getRoles(); // Ce qu'on récupère du Request
    String nom = signUpRequest.getNom();
    String prenom = signUpRequest.getPrenom();
    String telephone = signUpRequest.getTelephone();
    String matricule = signUpRequest.getMatricule();
    String photo = signUpRequest.getPhoto();

    Set<Role> roles = new HashSet<>(); // Ce qu'on doit créer et sauvegarder dans la base pour chaque User

    if (strRoles == null) {
      Role userRole = roleRepository.findByNom(ERole.USER).orElseThrow(
          () -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "superadmin":
          Role superAdminRole = roleRepository
              .findByNom(ERole.SUPER_ADMIN)
              .orElseThrow(() -> new RuntimeException(
                  "Error: Role is not found."));
          roles.add(superAdminRole);

          break;
        case "admin":
          Role adminRole = roleRepository.findByNom(ERole.ADMIN)
              .orElseThrow(() -> new RuntimeException(
                  "Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "agent":
          Role agentRole = roleRepository.findByNom(ERole.AGENT)
              .orElseThrow(() -> new RuntimeException(
                  "Error: Role is not found."));
          roles.add(agentRole);

          break;
        case "client":
          Role clientRole = roleRepository.findByNom(ERole.CLIENT)
              .orElseThrow(() -> new RuntimeException(
                  "Error: Role is not found."));
          roles.add(clientRole);

          break;
        default:
          Role userRole = roleRepository.findByNom(ERole.USER)
              .orElseThrow(() -> new RuntimeException(
                  "Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    user.setDateCreation(LocalDate.now());
    user.setNom(nom);
    user.setPrenom(prenom);
    user.setTelephone(telephone);
    user.setMatricule(matricule);
    user.setPhoto(photo);
    userRepository.save(user);

    return ResponseEntity
        .ok(new MessageResponse("Inscription avec succès!"));
  }

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(
      @Valid @RequestBody LoginRequest loginRequest) {

    // 1-get Authentication
    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(
            loginRequest.getUsername(), loginRequest.getPassword()));

    // 2-get token
    SecurityContextHolder.getContext()
        .setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    // 3-get User details
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication
        .getPrincipal();

    // 4-get roles
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority()).collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(),
        userDetails.getUsername(), userDetails.getEmail(), roles,
        userDetails.getDateCreation(), userDetails.getNom(),
        userDetails.getPrenom(), userDetails.getTelephone(),
        userDetails.getMatricule(), userDetails.getPhoto()));
  }

}
