package io.github.fatec.introducao.model;

public class Pessoa {
    private Long id;
    private String nome;
    private String telefone;
    private String endereco;

    public Pessoa(Long id, String nome, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String telefone() {return telefone;}
    public String endereco() {return  endereco;}
}