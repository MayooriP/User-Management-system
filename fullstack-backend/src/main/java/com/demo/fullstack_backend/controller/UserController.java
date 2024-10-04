package com.demo.fullstack_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.fullstack_backend.model.User;
import com.demo.fullstack_backend.repository.UserRepository;

@CrossOrigin("http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedUser.setId(id);
        User user = userRepository.save(updatedUser);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // New search endpoint
    @GetMapping("/users/search")
    public List<User> searchUsers(@RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        if (name != null && !name.isEmpty()) {
            return userRepository.findByNameContainingIgnoreCase(name);
        } else if (email != null && !email.isEmpty()) {
            return userRepository.findByEmailContainingIgnoreCase(email);
        } else {
            return userRepository.findAll();
        }
    }
}
