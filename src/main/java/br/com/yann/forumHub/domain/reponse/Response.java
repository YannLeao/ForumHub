package br.com.yann.forumHub.domain.reponse;

import br.com.yann.forumHub.domain.topic.Topic;
import br.com.yann.forumHub.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "responses")
public class Response {

    public Response() {}

    public Response(Long id, Topic topic, User author, String message, LocalDateTime creationDate) {
        this.id = id;
        this.topic = topic;
        this.author = author;
        this.message = message;
        this.creationDate = creationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(nullable = false)
    private String message;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public Topic getTopic() {
        return topic;
    }

    public User getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
