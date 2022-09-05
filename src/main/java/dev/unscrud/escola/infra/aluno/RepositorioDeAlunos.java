package dev.unscrud.escola.infra.aluno;

import java.util.List;

import dev.unscrud.escola.dominio.aluno.Aluno;
import dev.unscrud.escola.dominio.aluno.CPF;

public interface RepositorioDeAlunos {
  void matricular(Aluno aluno);

  Aluno buscarPorCpf(CPF cpf);

  List<Aluno> listarTodosAlunosMatriculados();
}
