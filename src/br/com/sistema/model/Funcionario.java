package br.com.sistema.model;

import java.sql.Date;

public class Funcionario {
    private int id;
    private String nome;
    private String cpf;
    private Date dataInclusao;

    public Funcionario() {}

    public Funcionario(int id, String nome, String cpf, Date dataInclusao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataInclusao = dataInclusao;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public Date getDataInclusao() { return dataInclusao; }
    public void setDataInclusao(Date dataInclusao) { this.dataInclusao = dataInclusao; }
}
