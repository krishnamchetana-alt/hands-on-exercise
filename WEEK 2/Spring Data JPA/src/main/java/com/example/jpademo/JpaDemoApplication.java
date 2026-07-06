package com.example.jpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// --- 1. THE REPOSITORY LAYER ---
// Spring Data JPA automatically handles all boilerplate SQL implementation behind this interface.
interface UserRepository extends JpaRepository<User, Long> {}

// --- 2. THE MAIN ENTRYPOINT & WEB CONTROLLER ---
@SpringBootApplication
@RestController
@RequestMapping("/users")
public class JpaDemoApplication {

    private final UserRepository repository;

    // Spring injects the automatic repository instance here
    public JpaDemoApplication(UserRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    // GET Request to http://localhost:8080/users -> Fetches all rows
    @GetMapping
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    // POST Request to http://localhost:8080/users -> Saves a new user record
    @PostMapping
    public User createUser(@RequestBody User user) {
        return repository.save(user);
    }
}