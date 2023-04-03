package br.com.adopet.domain.tutor;

public record DadosDetalhamentoTutor(
        Long id,
        String foto,
        String nome,
        String telefone,
        String cidade,
        String sobre
) {}
