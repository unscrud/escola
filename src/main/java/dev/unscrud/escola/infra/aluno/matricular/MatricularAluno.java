package dev.unscrud.escola.infra.aluno.matricular;

import dev.unscrud.escola.dominio.aluno.Aluno;
import dev.unscrud.escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {
  private final RepositorioDeAlunos repositorio;

  public MatricularAluno(RepositorioDeAlunos repositorio) {
    this.repositorio = repositorio;
  }

  public void executa(MatricularAlunoDTO dados) {
    Aluno novo = dados.criarAluno();
    repositorio.matricular(novo);
  }
}
