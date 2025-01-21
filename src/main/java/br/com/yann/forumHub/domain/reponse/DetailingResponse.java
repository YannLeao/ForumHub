package br.com.yann.forumHub.domain.reponse;

public record DetailingResponse(Long id, String message, String authorName, Long topicId) {

    public DetailingResponse(Response response) {
        this(response.getId(), response.getMessage(), response.getAuthor().getName(),
                response.getTopic().getId());
    }
}
