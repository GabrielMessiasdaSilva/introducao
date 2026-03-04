package io.github.fatec.introducao.dto;

public record PessoaRequest(
        Long id,
        String nome,
        String telefone,
        String endereco
) {}