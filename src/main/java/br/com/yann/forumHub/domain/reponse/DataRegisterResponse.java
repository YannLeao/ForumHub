package br.com.yann.forumHub.domain.reponse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRegisterResponse(

        @NotBlank String message,
        @NotNull Long authorId,
        @NotNull Long topicId,
        @NotNull Boolean solution
) {
}
