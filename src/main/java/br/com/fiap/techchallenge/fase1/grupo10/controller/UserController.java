package br.com.fiap.techchallenge.fase1.grupo10.controller;

import br.com.fiap.techchallenge.fase1.grupo10.model.User;
import br.com.fiap.techchallenge.fase1.grupo10.dto.UserRequestDto;
import br.com.fiap.techchallenge.fase1.grupo10.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        logger.info("/users");
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        logger.info("/users/" + id);
        User users = userService.findByUserName(id);
        return ResponseEntity.ok(users);
    }
    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody UserRequestDto userRequestDto) {
        userService.saveUser(userRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody UserRequestDto userRequestDto, @PathVariable("id") Long id){
        logger.info("PUT /users");
        this.userService.update(userRequestDto, id);
        HttpStatus status = HttpStatus.NO_CONTENT;
        return ResponseEntity.status(status).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
        logger.info("DELETE /users");
        this.userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
