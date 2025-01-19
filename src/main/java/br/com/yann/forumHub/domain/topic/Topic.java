package br.com.yann.forumHub.domain.topic;

import br.com.yann.forumHub.domain.course.Course;
import br.com.yann.forumHub.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topics")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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
}
