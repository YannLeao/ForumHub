package br.com.yann.forumHub.domain.topic;

public record DataUpdateTopic(

        String title,
        String message,
        Long courseId
) {
}
