package br.com.yann.forumHub.controller;

import br.com.yann.forumHub.domain.course.DataRegisterCourse;
import br.com.yann.forumHub.domain.course.DataResponseCourse;
import br.com.yann.forumHub.service.RegisterCourseService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final RegisterCourseService registerService;

    public CourseController(RegisterCourseService registerService) {
        this.registerService = registerService;
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
}
