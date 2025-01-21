package br.com.yann.forumHub.service;


import br.com.yann.forumHub.domain.topic.DataResponseTopic;
import br.com.yann.forumHub.domain.topic.Topic;
import br.com.yann.forumHub.domain.topic.TopicRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<DataResponseTopic> listTopics(boolean limited) {
        List<Topic> topics;
        if (limited) {
            Pageable pageable = PageRequest.of(0, 10, Sort.by("creationDate").ascending());
            topics = topicRepository.findAll(pageable).getContent();
        } else {
            topics = topicRepository.findAll(Sort.by("creationDate").ascending());
        }

        return topics.stream()
                .map(DataResponseTopic::new)
                .toList();
    }
}
