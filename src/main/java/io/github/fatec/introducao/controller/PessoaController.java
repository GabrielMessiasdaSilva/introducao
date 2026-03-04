package io.github.fatec.introducao.controller;

import io.github.fatec.introducao.dto.PessoaRequest;
import io.github.fatec.introducao.dto.PessoaResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final Map<Long, PessoaResponse> banco = new HashMap<>();
    private Long contador = 1L;

    // GET - listar todos
    @GetMapping
    public Collection<PessoaResponse> listar() {
        return banco.values();
    }

    @PostMapping
    public PessoaResponse criar(@RequestBody PessoaRequest request) {

        Long idGerado = contador++;

        PessoaResponse nova = new PessoaResponse(idGerado, request.nome());

        banco.put(idGerado, nova);

        return nova;
    }

    @PutMapping
    public PessoaResponse atualizar(@RequestBody PessoaRequest request) {

        PessoaResponse atualizada =
                new PessoaResponse(request.id(), request.nome());

        banco.put(request.id(), atualizada);

        return atualizada;
    }

    @DeleteMapping
    public String deletar(@RequestBody PessoaRequest request) {

        banco.remove(request.id());

        return "Usuário " + request.id() + " deletado";
    }
}