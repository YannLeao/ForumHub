package br.com.yann.forumHub.service;

import br.com.yann.forumHub.domain.course.Course;
import br.com.yann.forumHub.domain.course.CourseRepository;
import br.com.yann.forumHub.domain.course.DataResponseCourse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<DataResponseCourse> listCourses(boolean limited) {
        List<Course> courses;
        if (limited) {
            Pageable pageable = PageRequest.of(0, 10, Sort.by("name").ascending());
            courses = courseRepository.findAll(pageable).getContent();
        } else {
            courses = courseRepository.findAll(Sort.by("name").ascending());
        }
        return courses.stream()
                .map(DataResponseCourse::new)
                .toList();
    }
}
