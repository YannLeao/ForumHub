package br.com.yann.forumHub.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DataRegisterUser(

        @NotBlank(message= "O nome do usuário não pode estar em branco")
        String name,

        @NotBlank(message = "Campo de email do usuário incorreto")
        @Email
        String email,

        @NotBlank(message = "Campo da senha do usuário obrigatório")
        String password
) {
}
