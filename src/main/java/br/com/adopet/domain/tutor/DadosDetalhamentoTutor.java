package br.com.adopet.domain.tutor;

public record DadosDetalhamentoTutor(
        Long id,
        String foto,
        String nome,
        String telefone,
        String cidade,
        String sobre
) {
    DadosDetalhamentoTutor(Tutor tutor){
        this(tutor.getId(),
                tutor.getFoto(),
                tutor.getNome(),
                tutor.getTelefone(),
                tutor.getCidade(),
                tutor.getSobre());
    }
}
