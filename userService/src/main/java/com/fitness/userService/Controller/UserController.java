package com.fitness.userService.Controller;

import com.fitness.userService.Dto.RequestDto.UserRequestDTO;
import com.fitness.userService.Dto.ResponseDto.UserResponseDTO;
import com.fitness.userService.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public UserResponseDTO getUserDetails(@PathVariable int userId) {
        return userService.getUserDetails(userId);
    }

    @PostMapping("/register")
    public UserResponseDTO registerUser(@Valid @RequestBody UserRequestDTO dto) {
        return userService.registerUser(dto);
    }

    @GetMapping("/validate/{userId}")
    public ResponseEntity<Boolean> validateUserById(@PathVariable int userId) {
        return ResponseEntity.ok(userService.validateUserById(userId));
    }
}
