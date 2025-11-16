package com.fitness.userService.Service;

import com.fitness.userService.Dto.RequestDto.UserRequestDTO;
import com.fitness.userService.Dto.ResponseDto.UserResponseDTO;
import com.fitness.userService.Entity.User;
import com.fitness.userService.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    public UserResponseDTO getUserDetails(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("No User exist wih id : " + id));
        UserResponseDTO response = new UserResponseDTO();

        mapper.map(user , response);

        return response;
    }

    public UserResponseDTO registerUser(UserRequestDTO dto) {
        User user = new User();
        mapper.map(dto , user);

        User savedUser = userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO();

        mapper.map(savedUser , response);

        return response;
    }

    public Boolean validateUserById(int id) {
        return userRepository.existsById(id);
    }

}
