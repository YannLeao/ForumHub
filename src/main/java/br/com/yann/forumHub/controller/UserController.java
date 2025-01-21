package br.com.yann.forumHub.controller;

import br.com.yann.forumHub.domain.user.DataRegisterUser;
import br.com.yann.forumHub.domain.user.DataResponseUser;
import br.com.yann.forumHub.service.RegisterUserService;
import br.com.yann.forumHub.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final RegisterUserService registerService;
    private final UserService userService;

    public UserController(RegisterUserService registerService, UserService userService) {
        this.registerService = registerService;
        this.userService = userService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DataResponseUser> register(@RequestBody @Valid DataRegisterUser data) {
        var result = registerService.execute(data);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id())
                .toUri();
        return ResponseEntity.created(uri).body(result);
    }

    @GetMapping
    public ResponseEntity<List<DataResponseUser>> list(@RequestParam(defaultValue = "false") boolean limited) {
        var users = userService.listUsers(limited);
        return ResponseEntity.ok(users);
    }
}

