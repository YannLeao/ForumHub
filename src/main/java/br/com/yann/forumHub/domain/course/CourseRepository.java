package br.com.yann.forumHub.domain.course;

import br.com.yann.forumHub.domain.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
