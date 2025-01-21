package br.com.yann.forumHub.service;

import br.com.yann.forumHub.domain.user.DataRegisterUser;
import br.com.yann.forumHub.domain.user.DataResponseUser;
import br.com.yann.forumHub.domain.user.User;
import br.com.yann.forumHub.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    private final UserRepository userRepository;

    public RegisterUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public DataResponseUser execute(@Valid DataRegisterUser data) {
        if (userRepository.existsByEmail(data.email())) {
            throw new IllegalArgumentException("User with this email already exists.");
        }

        var user = new User(null, data.name(), data.email(), data.password());
        userRepository.save(user);

        return new DataResponseUser(user);

    }
}
