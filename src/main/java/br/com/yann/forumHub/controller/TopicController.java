package br.com.yann.forumHub.controller;


import br.com.yann.forumHub.domain.topic.DataRegisterTopic;
import br.com.yann.forumHub.domain.topic.DataResponseTopic;
import br.com.yann.forumHub.domain.topic.Topic;
import br.com.yann.forumHub.domain.topic.TopicRepository;
import br.com.yann.forumHub.service.RegisterTopicService;
import br.com.yann.forumHub.service.TopicService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final RegisterTopicService registerService;
    private final TopicService topicService;
    private final TopicRepository repository;

    public TopicController(RegisterTopicService registerService, TopicService topicService, TopicRepository repository) {
        this.registerService = registerService;
        this.topicService = topicService;
        this.repository = repository;
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

    @GetMapping
    public ResponseEntity<List<DataResponseTopic>> list(@RequestParam(defaultValue = "false") boolean limited) {
        var topics = topicService.listTopics(limited);
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponseTopic> getTopicDetails(@PathVariable Long id) {
        var topic = repository.findById(id).orElse(null);
        return ResponseEntity.ok(new DataResponseTopic(topic));
    }

}
