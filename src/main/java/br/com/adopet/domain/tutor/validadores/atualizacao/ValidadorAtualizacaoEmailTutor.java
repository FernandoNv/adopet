package br.com.adopet.domain.tutor.validadores.atualizacao;

import br.com.adopet.domain.ValidacaoException;
import br.com.adopet.domain.tutor.DadosAtualizacaoTutor;
import br.com.adopet.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtualizacaoEmailTutor implements ValidadorAtualizacaoTutor{
    private final UsuarioRepository _usuarioRepository;

    @Autowired
    public ValidadorAtualizacaoEmailTutor(UsuarioRepository usuarioRepository) {
        _usuarioRepository = usuarioRepository;
    }

    @Override
    public void valida(DadosAtualizacaoTutor dadosAtualizacaoTutor) {
        if(_usuarioRepository.existsByEmail(dadosAtualizacaoTutor.email())){
            throw new ValidacaoException("E-mail já cadastrado");
        }
    }
}
