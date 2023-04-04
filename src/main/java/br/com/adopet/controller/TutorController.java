package br.com.adopet.controller;

import br.com.adopet.domain.tutor.DadosCadastroTutor;
import br.com.adopet.domain.tutor.DadosDetalhamentoTutor;
import br.com.adopet.domain.tutor.TutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("tutores")
public class TutorController {
    private final TutorService _tutorService;
    @Autowired
    public TutorController(TutorService _tutorService) {
        this._tutorService = _tutorService;
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoTutor> cadastrar(@RequestBody @Valid DadosCadastroTutor dadosCadastroTutor, UriComponentsBuilder uriComponentsBuilder){
        DadosDetalhamentoTutor dadosDetalhamentoTutor = _tutorService.cadastrar(dadosCadastroTutor);

        URI uri = uriComponentsBuilder
                .path("/tutores/{id}")
                .buildAndExpand(dadosDetalhamentoTutor.id())
                .toUri();

        return ResponseEntity.created(uri).body(dadosDetalhamentoTutor);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DadosDetalhamentoTutor> detalhar(@PathVariable Long id){
        DadosDetalhamentoTutor dadosDetalhamentoTutor = _tutorService.detalhar(id);

        return ResponseEntity.ok(dadosDetalhamentoTutor);
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoTutor>> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao){
        Page<DadosDetalhamentoTutor> page = _tutorService.listar(paginacao);

        return ResponseEntity.ok(page);
    }
}
