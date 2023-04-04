package br.com.adopet.domain.tutor;

import br.com.adopet.domain.ValidacaoException;
import br.com.adopet.domain.tutor.validadores.cadastro.ValidadorCadastroTutor;
import br.com.adopet.domain.usuario.Usuario;
import br.com.adopet.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {
    private final TutorRepository _tutorRepository;
    private final UsuarioRepository _usuarioRepository;
    private final List<ValidadorCadastroTutor> _validadoresCadastroTutor;

    @Autowired
    public TutorService(
            TutorRepository _tutorRepository,
            UsuarioRepository _usuarioRepository,
            List<ValidadorCadastroTutor> _validadoresCadastroTutor
    ) {
        this._tutorRepository = _tutorRepository;
        this._usuarioRepository = _usuarioRepository;
        this._validadoresCadastroTutor = _validadoresCadastroTutor;
    }

    @Transactional
    public DadosDetalhamentoTutor cadastrar(DadosCadastroTutor dadosCadastroTutor){
        for(ValidadorCadastroTutor validadorCadastroTutor: _validadoresCadastroTutor){
            System.out.println("Rodando dentro do loop");
            validadorCadastroTutor.validar(dadosCadastroTutor);
        }

        var usuario = new Usuario(null, dadosCadastroTutor.email(), dadosCadastroTutor.senha());
        var tutor = new Tutor(null, dadosCadastroTutor.nome());
        usuario.setTutor(tutor);
        tutor.setUsuario(usuario);

        _usuarioRepository.save(usuario);
        var novoTutor = _tutorRepository.save(tutor);

        return new DadosDetalhamentoTutor(novoTutor);
    }

    public DadosDetalhamentoTutor detalhar(Long id) {
        if(!_tutorRepository.findAtivoById(id)) throw new ValidacaoException("Conta desativada");
        var tutor = _tutorRepository.getReferenceById(id);

        return new DadosDetalhamentoTutor(tutor);
    }

    public Page<DadosDetalhamentoTutor> listar(Pageable paginacao) {
        return _tutorRepository.findAllByAtivoTrue(paginacao).map(DadosDetalhamentoTutor::new);
    }

    @Transactional
    public void deletar(Long id) {
        Tutor tutor = _tutorRepository.getReferenceById(id);
        tutor.deletar();
    }
}
