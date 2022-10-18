package dev.unscrud.escola.infra.aluno.matricular;

import dev.unscrud.escola.dominio.PublicadorDeEventos;
import dev.unscrud.escola.dominio.aluno.Aluno;
import dev.unscrud.escola.dominio.aluno.AlunoMatriculado;
import dev.unscrud.escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {
  private final RepositorioDeAlunos repositorio;
  private final PublicadorDeEventos publicador;

  public MatricularAluno(RepositorioDeAlunos repositorio, PublicadorDeEventos publicador) {
    this.repositorio = repositorio;
    this.publicador = publicador;
  }

  public void executa(MatricularAlunoDTO dados) {
    Aluno novo = dados.criarAluno();
    repositorio.matricular(novo);

    AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
    publicador.publicar(evento);
  }
}
