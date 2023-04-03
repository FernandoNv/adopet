package br.com.adopet.controller;

import br.com.adopet.domain.tutor.DadosCadastroTutor;
import br.com.adopet.domain.tutor.DadosDetalhamentoTutor;
import br.com.adopet.domain.tutor.TutorService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class TutorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JacksonTester<DadosCadastroTutor> dadosCadastroTutorJson;
    @Autowired
    private JacksonTester<DadosDetalhamentoTutor> dadosDetalhamentoTutorJson;
    @MockBean
    private TutorService tutorService;

    private final String baseUrl = "/tutores";

    @Test
    @DisplayName("cadastrar - Deve devolver codigo HTTP 400 quando informações estão incorretas")
    void cadastrarCenario1() throws Exception {
        var response = mockMvc.perform(
                        MockMvcRequestBuilders.post(baseUrl)
                )
                .andReturn().getResponse();

        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }
    @Test
    @DisplayName("cadastrar - Deve devolver codigo HTTP 200 quando informações estão válidas")
    void cadastrarCenario2() throws Exception{
        var dadosCadastro = new DadosCadastroTutor("email@email", "Fernando Vieira", "12345678", "12345678");
        var dadosDetalhamento = new DadosDetalhamentoTutor(1L, null, "Fernando Vieira", null, null, null);

        Mockito.when(this.tutorService.cadastrar(Mockito.any(DadosCadastroTutor.class))).thenReturn(dadosDetalhamento);

        var response = mockMvc.perform(
                MockMvcRequestBuilders.post(baseUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroTutorJson.write(dadosCadastro).getJson())
                )
                .andReturn().getResponse();
        var jsonEsperado = dadosDetalhamentoTutorJson.write(dadosDetalhamento).getJson();

        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        Assertions.assertEquals(jsonEsperado, response.getContentAsString());
    }

    @Test
    @DisplayName("detalhar - Deve devolver codigo HTTP 404 quando passado um id inválido")
    void detalharCenario1() throws Exception {
        Mockito.when(this.tutorService.detalhar(Mockito.any(Long.class))).thenThrow(EntityNotFoundException.class);

        var response = mockMvc.perform(
                MockMvcRequestBuilders.get(baseUrl+"/1")
                )
                .andReturn().getResponse();

        Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }

    @Test
    @DisplayName("detalhar - Deve devolver codigo HTTP 200 quando passado um id válido")
    void detalharCenario2() throws Exception {
        var dadosDetalhamentoTutor = new DadosDetalhamentoTutor(1L, null, "Fernando Vieira", null, null, null);
        Mockito.when(this.tutorService.detalhar(Mockito.any(Long.class))).thenReturn(dadosDetalhamentoTutor);

        var response = mockMvc.perform(
                        MockMvcRequestBuilders.get(baseUrl+"/1")
                )
                .andReturn().getResponse();
        var jsonEsperado = dadosDetalhamentoTutorJson.write(dadosDetalhamentoTutor).getJson();

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
        Assertions.assertEquals(jsonEsperado, response.getContentAsString());
    }
}