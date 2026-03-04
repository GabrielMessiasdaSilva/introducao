package io.github.fatec.introducao.controller;

import io.github.fatec.introducao.dto.PessoaRequest;
import io.github.fatec.introducao.dto.PessoaResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @GetMapping("aluno")
    public PessoaResponse aluno() {
        return new PessoaResponse(1L, "Gabriel");
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> criar(@RequestBody PessoaRequest request) {
        PessoaResponse response = new PessoaResponse(1L, request.nome());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponse> atualizar(@PathVariable Long id, @RequestBody PessoaRequest request) {
        PessoaResponse response = new PessoaResponse(id, request.nome());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        return ResponseEntity.ok("USUARIO: " + id + " Deletado");
    }
}