package br.com.yann.forumHub.controller;

import br.com.yann.forumHub.domain.course.DataRegisterCourse;
import br.com.yann.forumHub.domain.course.DataResponseCourse;
import br.com.yann.forumHub.service.CourseService;
import br.com.yann.forumHub.service.RegisterCourseService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final RegisterCourseService registerService;
    private final CourseService courseService;


    public CourseController(RegisterCourseService registerService, CourseService courseService) {
        this.registerService = registerService;
        this.courseService = courseService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DataResponseCourse> register(@RequestBody @Valid DataRegisterCourse data) {
        var result = registerService.execute(data);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.id())
                .toUri();
        return ResponseEntity.created(uri).body(result);
    }

    @GetMapping
    public ResponseEntity<List<DataResponseCourse>> list(@RequestParam(defaultValue = "false") boolean limited) {
        var courses = courseService.listCourses(limited);
        return ResponseEntity.ok(courses);
    }
}
