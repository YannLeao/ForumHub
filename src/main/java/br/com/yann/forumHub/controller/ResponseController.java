package br.com.yann.forumHub.controller;


import br.com.yann.forumHub.domain.reponse.DataRegisterResponse;
import br.com.yann.forumHub.domain.reponse.DetailingResponse;
import br.com.yann.forumHub.service.RegisterResponseService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("responses")
public class ResponseController {
    private final RegisterResponseService registerService;

    public ResponseController(RegisterResponseService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetailingResponse> register(@RequestBody @Valid DataRegisterResponse data) {
        var result = registerService.execute(data);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id())
                .toUri();
        return ResponseEntity.created(uri).body(result);
    }
}
