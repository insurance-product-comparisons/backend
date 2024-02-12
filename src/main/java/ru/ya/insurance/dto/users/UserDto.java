package ru.ya.insurance.dto.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class UserDto  {

    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    @Email
    private String email;


}
