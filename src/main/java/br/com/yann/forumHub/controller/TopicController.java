package br.com.yann.forumHub.controller;


import br.com.yann.forumHub.domain.topic.DataRegisterTopic;
import br.com.yann.forumHub.service.RegisterTopicService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("topics")
public class TopicController {

    private final RegisterTopicService registerService;

    public TopicController(RegisterTopicService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DataRegisterTopic data) {
        var result = registerService.execute(data);
        var uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/topicos/{id}")
                .buildAndExpand(result.id())
                .toUri();
        return ResponseEntity.created(uri).body(result);
    }

}
