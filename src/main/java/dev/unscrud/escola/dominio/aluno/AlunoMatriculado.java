package dev.unscrud.escola.dominio.aluno;

import java.time.LocalDateTime;

import dev.unscrud.escola.dominio.Evento;

public class AlunoMatriculado implements Evento {
  private final CPF cpfDoAluno;
  private final LocalDateTime momento;

  public AlunoMatriculado(CPF cpfDoAluno) {
    this.cpfDoAluno = cpfDoAluno;
    this.momento = LocalDateTime.now();
  }

  @Override
  public LocalDateTime momento() {
    return this.momento;
  }

  public CPF getCpfDoAluno() {
    return cpfDoAluno;
  }

}