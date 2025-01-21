package br.com.yann.forumHub.domain.topic;

import br.com.yann.forumHub.domain.course.Course;
import br.com.yann.forumHub.domain.user.User;
import jakarta.persistence.*;

import java.time.Clock;
import java.time.LocalDateTime;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String message;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private StatusTopic status;

    @ManyToOne
    private User author;

    @ManyToOne
    private Course course;

    public Topic() {}

    public Topic(String title, String message, User author, Course course) {
        this.title = title;
        this.message = message;
        creationDate = LocalDateTime.now(Clock.systemDefaultZone());
        status = StatusTopic.NOT_ANSWERED;
        this.author = author;
        this.course = course;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public StatusTopic getStatus() {
        return status;
    }

    public User getAuthor() {
        return author;
    }

    public Course getCourse() {
        return course;
    }
}
