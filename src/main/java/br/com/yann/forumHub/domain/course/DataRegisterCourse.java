package br.com.yann.forumHub.domain.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRegisterCourse(

        @NotBlank(message = "O nome do curso não pode está vazio")
        String name,

        @NotNull(message = "A categoria do curso deve ser: BACK_END, FRONT_END, DATA_SCIENCE ou MOBILE" )
        CategoryCourse category
) {
}
