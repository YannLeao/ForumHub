package br.com.yann.forumHub.domain.course;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByName(@NotBlank(message = "O nome do curso não pode está vazio") String name);
}
