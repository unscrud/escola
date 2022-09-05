package dev.unscrud.escola.infra.aluno.matricular;

import dev.unscrud.escola.dominio.aluno.Aluno;
import dev.unscrud.escola.dominio.aluno.CPF;
import dev.unscrud.escola.dominio.aluno.Email;

public class MatricularAlunoDTO {
  private String nomeAluno;
  private String cpfAluno;
  private String emailAluno;

  public MatricularAlunoDTO(String nomeAluno, String cpfAluno, String emailAluno) {
    this.nomeAluno = nomeAluno;
    this.cpfAluno = cpfAluno;
    this.emailAluno = emailAluno;
  }

  public Aluno criarAluno() {
    return new Aluno(new CPF(cpfAluno), nomeAluno, new Email(emailAluno));
  }

}
