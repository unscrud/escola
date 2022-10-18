package dev.unscrud.escola;

import dev.unscrud.escola.dominio.PublicadorDeEventos;
import dev.unscrud.escola.dominio.aluno.LogDeAlunoMatriculado;
import dev.unscrud.escola.infra.aluno.RepositorioDeAlunosEmMemoria;
import dev.unscrud.escola.infra.aluno.matricular.MatricularAluno;
import dev.unscrud.escola.infra.aluno.matricular.MatricularAlunoDTO;

public class MatricularAlunoViaLinhaDeComando {
  public static void main(String[] args) {
    String nome = "fulano";
    String cpf = "000.000.000-00";
    String email = "fulano@teste.com";

    PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
    publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());

    MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicadorDeEventos);
    matricular.executa(new MatricularAlunoDTO(nome, cpf, email));
  }
}
