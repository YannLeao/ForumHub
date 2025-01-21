package br.com.yann.forumHub.domain.course;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courses")
public class Course {

    public Course() {}

    public Course(Long id, String name, CategoryCourse category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryCourse category;

    public Course(@NotNull @Valid DataRegisterCourse data) {
        name = data.name();
        category = data.category();
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
