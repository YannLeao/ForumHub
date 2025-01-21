package br.com.yann.forumHub.domain.course;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryCourse category;

    public Course() {}

    public Course(Long id, String name, CategoryCourse category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CategoryCourse getCategory() {
        return category;
    }
}
