package com.deploy.praktikum1.controller;

import com.deploy.praktikum1.model.dto.UserAddRequest;
import com.deploy.praktikum1.model.dto.UserDto;
import com.deploy.praktikum1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> AddUser(@RequestBody UserAddRequest request) {
        UserDto result = userService.addUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "status", "success",
                "data", result
        ));
    }

    @GetMapping(
            path = "/api/users",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> getAllUser() {
        List<UserDto> result = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", "success",
                "data", result
        ));
    }

    @GetMapping(
            path = "/api/users/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable("id") String id) {
        UserDto result = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", "success",
                "data", result
        ));
    }

    @PutMapping(
            path = "/api/users/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> UpdateUser(
            @PathVariable("id") String id,
            @RequestBody UserAddRequest request
    ) {
        UserDto result = userService.updateUser(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", "success",
                "data", result
        ));
    }

    @DeleteMapping(
            path = "/api/users/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> DeleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", "success delete user with id " + id
        ));
    }
}