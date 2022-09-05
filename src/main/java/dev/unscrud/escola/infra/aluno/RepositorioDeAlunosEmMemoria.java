package dev.unscrud.escola.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import dev.unscrud.escola.dominio.aluno.Aluno;
import dev.unscrud.escola.dominio.aluno.CPF;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {
  private List<Aluno> matriculados = new ArrayList<>();

  @Override
  public void matricular(Aluno aluno) {
    matriculados.add(aluno);
  }

  @Override
  public Aluno buscarPorCpf(CPF cpf) {
    return matriculados.stream().filter(a -> a.getCpf().equals(cpf.getNumero()))
        .findFirst().orElseThrow(() -> new AlunoNaoEncontrado(cpf));
  }

  @Override
  public List<Aluno> listarTodosAlunosMatriculados() {
    return matriculados;
  }

}
