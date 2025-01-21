package br.com.yann.forumHub.service;

import br.com.yann.forumHub.domain.course.Course;
import br.com.yann.forumHub.domain.course.CourseRepository;
import br.com.yann.forumHub.domain.course.DataRegisterCourse;
import br.com.yann.forumHub.domain.course.DataResponseCourse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class RegisterCourseService {

    private final CourseRepository courseRepository;

    public RegisterCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public DataResponseCourse execute(@Valid DataRegisterCourse data) {
        if (courseRepository.existsByName(data.name())) {
            throw new IllegalArgumentException("Course with this name already exists.");
        }

        var course = new Course(null, data.name(), data.category());
        courseRepository.save(course);

        return new DataResponseCourse(course);

    }
}
