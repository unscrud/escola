package dev.unscrud.escola;

import dev.unscrud.escola.infra.aluno.RepositorioDeAlunosEmMemoria;
import dev.unscrud.escola.infra.aluno.matricular.MatricularAluno;
import dev.unscrud.escola.infra.aluno.matricular.MatricularAlunoDTO;

public class MatricularAlunoViaLinhaDeComando {
  public static void main(String[] args) {
    String nome = "fulano";
    String cpf = "000.000.000-00";
    String email = "fulano@teste.com";

    MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
    matricular.executa(new MatricularAlunoDTO(nome, cpf, email));

  }
}
