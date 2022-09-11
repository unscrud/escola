package dev.unscrud.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
  private CPF cpf;
  private String nome;
  private Email email;
  private String senha;

  private List<Telefone> telefones = new ArrayList<>();

  public Aluno(CPF cpf, String nome, Email email) {
    this.cpf = cpf;
    this.nome = nome;
    this.email = email;
  }

  public void adicionaTelefone(String ddd, String numero) {
    if (this.telefones.size() >= 2)
      throw new QuantidadeMaximaDeTelefonesException("O aluno não pode ter mais de 2 telefones!");
    this.telefones.add(new Telefone(ddd, numero));
  }

  public CPF getCpf() {
    return cpf;
  }

  public String getNome() {
    return nome;
  }

  public Email getEmail() {
    return email;
  }

  public List<Telefone> getTelefones() {
    return telefones;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getSenha() {
    return senha;
  }

}
