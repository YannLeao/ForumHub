package br.com.yann.forumHub.controller;

import br.com.yann.forumHub.domain.user.DataRegisterUser;
import br.com.yann.forumHub.domain.user.DataResponseUser;
import br.com.yann.forumHub.service.RegisterUserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("users")
public class UserController {

    private final RegisterUserService registerService;

    public UserController(RegisterUserService registerService) {
        this.registerService = registerService;
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
}

