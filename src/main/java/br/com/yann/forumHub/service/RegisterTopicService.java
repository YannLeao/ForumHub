package br.com.yann.forumHub.service;

import br.com.yann.forumHub.domain.course.CourseRepository;
import br.com.yann.forumHub.domain.topic.DataRegisterTopic;
import br.com.yann.forumHub.domain.topic.DataResponseTopic;
import br.com.yann.forumHub.domain.topic.Topic;
import br.com.yann.forumHub.domain.topic.TopicRepository;
import br.com.yann.forumHub.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class RegisterTopicService {

    private final TopicRepository topicRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public RegisterTopicService(TopicRepository topicRepository, UserRepository userRepository, CourseRepository courseRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    public DataResponseTopic execute(@Valid DataRegisterTopic data) {

        if (topicRepository.existsByTitleAndMessage(data.title(), data.message())) {
            throw new IllegalArgumentException("Topic with the same title and message already exists.");
        }

        var author = userRepository.findById(data.authorId())
                .orElseThrow(() -> new IllegalArgumentException("Author not found."));
        var course = courseRepository.findById(data.courseId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found."));

        var topic = new Topic(data.title(), data.message(), author, course);
        topicRepository.save(topic);

        return new DataResponseTopic(topic);
    }
}
