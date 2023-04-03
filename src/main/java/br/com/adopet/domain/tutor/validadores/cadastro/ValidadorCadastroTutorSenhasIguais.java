package br.com.adopet.domain.tutor.validadores.cadastro;

import br.com.adopet.domain.ValidacaoException;
import br.com.adopet.domain.tutor.DadosCadastroTutor;
import org.springframework.stereotype.Component;

@Component
public class ValidadorCadastroTutorSenhasIguais implements ValidadorCadastroTutor{
    @Override
    public void validar(DadosCadastroTutor dadosCadastroTutor) {
        var senha = dadosCadastroTutor.senha();
        var confirmacaoSenha = dadosCadastroTutor.confirmacaoSenha();

        if(!senha.equals(confirmacaoSenha)){
            throw new ValidacaoException("Campo senha deve ser igual ao campo validacaoSenha");
        }
    }
}
