package br.com.adopet.domain.tutor;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTutor(
        @NotNull(message = "{id.obrigatorio}")
        Long id,
        String nome,
        String telefone,
        String cidade,
        String sobre,
        String foto,
        String email
) {
}
