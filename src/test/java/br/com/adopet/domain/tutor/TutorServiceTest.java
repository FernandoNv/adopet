package br.com.adopet.domain.tutor;

import br.com.adopet.domain.ValidacaoException;
import br.com.adopet.domain.tutor.validadores.cadastro.ValidadorCadastroTutor;
import br.com.adopet.domain.tutor.validadores.cadastro.ValidadorCadastroTutorEmailJaCadastrado;
import br.com.adopet.domain.tutor.validadores.cadastro.ValidadorCadastroTutorSenhasIguais;
import br.com.adopet.domain.usuario.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@AutoConfigureMockMvc
class TutorServiceTest {
    @Mock
    private ValidadorCadastroTutorEmailJaCadastrado validadorCadastroTutorEmailJaCadastrado;
    @Mock
    private ValidadorCadastroTutorSenhasIguais validadorCadastroTutorSenhasIguais;
    @Spy
    private List<ValidadorCadastroTutor> validadoresCadastroTutor = new ArrayList<>();
    @Mock
    private TutorRepository tutorRepository;
    @Mock
    private UsuarioRepository usuarioRepository;
    @Spy
    @InjectMocks
    private TutorService tutorService;

//    @Test
//    @DisplayName("cadastrar - Deve falhar ao passar um email já cadastrado")
//    void cadastrarCenario1() {
//        DadosCadastroTutor dadosCadastroTutor = new DadosCadastroTutor(
//                "email@email.com",
//                "Fernando Vieira",
//                "123456",
//                "123456"
//        );
//
//        Mockito.when(this.usuarioRepository.existsByEmail(Mockito.any(String.class))).thenReturn(true);
//
//        try {
//            this.tutorService.cadastrar(dadosCadastroTutor);
//            fail("Não deu a exception esperada");
//        }catch (ValidacaoException e){
//            var mensagem = e.getMessage();
//
//            Assertions.assertEquals("Email já cadastrado", mensagem);
//        }
//    }
}