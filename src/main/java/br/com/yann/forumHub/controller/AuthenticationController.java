package br.com.yann.forumHub.controller;

import br.com.yann.forumHub.domain.authentication.AuthenticationRequest;
import br.com.yann.forumHub.domain.user.User;
import br.com.yann.forumHub.domain.authentication.DataTokenJWT;
import br.com.yann.forumHub.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public AuthenticationController(final AuthenticationManager manager,
                                    final TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<DataTokenJWT> applyLongin(@RequestBody @Valid AuthenticationRequest request) {
        final var authenticationToken = new UsernamePasswordAuthenticationToken(request.username(), request.password());

        final var authentication = manager.authenticate(authenticationToken);
        final var tokenJWT = tokenService.buildToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
    }

}