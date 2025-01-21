package br.com.yann.forumHub.service;

import br.com.yann.forumHub.domain.user.DataResponseUser;
import br.com.yann.forumHub.domain.user.User;
import br.com.yann.forumHub.domain.user.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<DataResponseUser> listUsers(boolean limited) {
        List<User> users;
        if (limited) {
            Pageable pageable = PageRequest.of(0, 10, Sort.by("name").ascending());
            users = userRepository.findAll(pageable).getContent();
        } else {
            users = userRepository.findAll(Sort.by("name").ascending());
        }
        return users.stream()
                .map(DataResponseUser::new)
                .toList();
    }
}
