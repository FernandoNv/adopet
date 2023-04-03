package br.com.adopet.domain.tutor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTutor(
        @NotBlank(message = "{email.obrigatorio}")
        @Email(message = "{email.invalido}")
        String email,
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,
        @NotBlank(message = "{senha.obrigatoria}")
        String senha,
        @NotBlank(message = "{confirmacaoSenha.obrigatorio}")
        String confirmacaoSenha
) {
}
