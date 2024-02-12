package ru.ya.insurance.service.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.ya.insurance.model.user.User;

public interface UserService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    @Transactional
    void register(User user) throws RuntimeException;
}
