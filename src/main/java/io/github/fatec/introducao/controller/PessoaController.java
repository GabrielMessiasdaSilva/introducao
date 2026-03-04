package io.github.fatec.introducao.controller;

import io.github.fatec.introducao.dto.PessoaRequest;
import io.github.fatec.introducao.dto.PessoaResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    // Para simular banco de dados
    private final Map<Long, PessoaResponse> banco = new HashMap<>();

    // gerar ID simples
    private Long contador = 1L;

    @GetMapping("aluno")
    public PessoaResponse aluno() {
        return new PessoaResponse(1L, "Gabriel");
    }

    @GetMapping
    public Collection<PessoaResponse> listar() {
        return banco.values();
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> criar(@RequestBody PessoaRequest request) {

        PessoaResponse nova = new PessoaResponse(contador++, request.nome());

        banco.put(nova.id(), nova);

        return ResponseEntity.status(HttpStatus.CREATED).body(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponse> atualizar(@PathVariable Long id,
                                                    @RequestBody PessoaRequest request) {

        if (!banco.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        PessoaResponse atualizada = new PessoaResponse(id, request.nome());

        banco.put(id, atualizada);

        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        if (!banco.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        banco.remove(id);

        return ResponseEntity.noContent().build();
    }
}