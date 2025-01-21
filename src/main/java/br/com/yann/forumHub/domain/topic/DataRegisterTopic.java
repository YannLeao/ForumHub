package br.com.yann.forumHub.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRegisterTopic(

        @NotBlank(message = "O título do tópico não pode estar em branco")
        String title,

        @NotBlank(message = "A mensagem do tópico não pode estar em branco")
        String message,

        @NotNull
        Long authorId,

        @NotNull
        Long courseId) {}
