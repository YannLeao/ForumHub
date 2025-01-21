package br.com.yann.forumHub.domain.topic;

import br.com.yann.forumHub.domain.course.Course;
import br.com.yann.forumHub.domain.user.User;

import java.time.LocalDateTime;

public record DataResponseTopic(
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        StatusTopic status,
        String authorName,
        String courseName
) {

    public DataResponseTopic(Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getStatus(),
                topic.getAuthor().getName(),
                topic.getCourse().getName()
        );
    }
}
