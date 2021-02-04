package ru.leovalter.smartcards.web;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.leovalter.smartcards.model.User;
import ru.leovalter.smartcards.service.UserService;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "users")
public class UserRestController {

    private final UserService service;

    public UserRestController(@Qualifier("userServiceImpl") UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = service.create(user);
        if (createdUser == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdUser.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(createdUser);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user) {
        User updatedUser = service.update(user);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> get(@PathVariable("id") int id) {
        User foundUser = service.get(id);
        if (foundUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundUser);
    }

    @GetMapping("/by-login/{login}")
    public ResponseEntity<User> getByLogin(@PathVariable String login) {
        User foundUser = service.getByLogin(login);
        if (foundUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundUser);
    }

    @GetMapping("/by-email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable String email) {
        User foundUser = service.getByEmail(email);
        if (foundUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> foundUsers = service.getAll();
        if (foundUsers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(foundUsers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.notFound().build();
    }

}
