package com.fitness.userService.Dto.RequestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {
    @NotBlank(message = "Email is Required")
    @Email(message = "Incorrect Email Format")
    private String email;

    @NotBlank(message = "Password is Required")
    @Size(min = 6 , message = "Length of password should be atleast 6")
    private String password;
    private String firstName;
    private String lastName;
}
