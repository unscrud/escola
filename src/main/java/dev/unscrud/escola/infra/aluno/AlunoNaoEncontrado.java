package dev.unscrud.escola.infra.aluno;

import dev.unscrud.escola.dominio.aluno.CPF;

public class AlunoNaoEncontrado extends RuntimeException {

  public AlunoNaoEncontrado(CPF cpf) {
    super("Aluno não encontrado com CPF: " + cpf.getNumero());
  }

}
