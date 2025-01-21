package br.com.yann.forumHub.service;

import br.com.yann.forumHub.domain.reponse.DataRegisterResponse;
import br.com.yann.forumHub.domain.reponse.DetailingResponse;
import br.com.yann.forumHub.domain.reponse.Response;
import br.com.yann.forumHub.domain.reponse.ResponseRepository;
import br.com.yann.forumHub.domain.topic.TopicRepository;
import br.com.yann.forumHub.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class RegisterResponseService {

    private final ResponseRepository responseRepository;
    private final TopicRepository topicRepository;
    private final UserRepository userRepository;

    public RegisterResponseService(ResponseRepository responseRepository, TopicRepository topicRepository, UserRepository userRepository) {
        this.responseRepository = responseRepository;
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
    }

    public DetailingResponse execute(@Valid DataRegisterResponse data) {
        var author = userRepository.findById(data.authorId())
                .orElseThrow(() -> new IllegalArgumentException("Author not found."));
        var topic = topicRepository.findById(data.topicId())
                .orElseThrow(() -> new IllegalArgumentException("Topic not found."));
        var response = new Response(null, topic, author, data.message());
        responseRepository.save(response);

        return new DetailingResponse(response);
    }
}
