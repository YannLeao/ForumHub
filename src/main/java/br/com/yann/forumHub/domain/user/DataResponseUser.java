package br.com.yann.forumHub.domain.user;

public record DataResponseUser(Long id, String name, String email) {
    public DataResponseUser(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
