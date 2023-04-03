package br.com.adopet.domain.tutor.validadores.cadastro;

import br.com.adopet.domain.ValidacaoException;
import br.com.adopet.domain.tutor.DadosCadastroTutor;
import br.com.adopet.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorCadastroTutorEmailJaCadastrado implements ValidadorCadastroTutor{
    private final UsuarioRepository _usuarioRepository;
    @Autowired
    public ValidadorCadastroTutorEmailJaCadastrado(UsuarioRepository _usuarioRepository) {
        this._usuarioRepository = _usuarioRepository;
    }

    @Override
    public void validar(DadosCadastroTutor dadosCadastroTutor) {
        if(_usuarioRepository.existsByEmail(dadosCadastroTutor.email())){
            throw new ValidacaoException("Email já cadastrado");
        }
    }
}
