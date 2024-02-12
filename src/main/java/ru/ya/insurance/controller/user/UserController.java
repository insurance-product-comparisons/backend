package ru.ya.insurance.controller.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.insurance.dto.users.UserDto;
import ru.ya.insurance.mapper.users.UsersMapper;
import ru.ya.insurance.model.user.User;
import ru.ya.insurance.service.user.UserServiceImpl;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    private final UsersMapper userMapper;

    private final PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public String register(@Valid UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userService.register(user);
        return "Registration successful";
    }
}
