package dev.unscrud.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dev.unscrud.escola.dominio.PublicadorDeEventos;
import dev.unscrud.escola.dominio.aluno.Aluno;
import dev.unscrud.escola.dominio.aluno.CPF;
import dev.unscrud.escola.dominio.aluno.LogDeAlunoMatriculado;
import dev.unscrud.escola.dominio.aluno.RepositorioDeAlunos;
import dev.unscrud.escola.infra.aluno.RepositorioDeAlunosEmMemoria;
import dev.unscrud.escola.infra.aluno.matricular.MatricularAluno;
import dev.unscrud.escola.infra.aluno.matricular.MatricularAlunoDTO;

public class MatricularAlunoTest {
  @Test
  void deveriaPersistirAluno() {
    String nomeDeTeste = "Fulano";
    String cpfDeTeste = "123.456.789-00";
    String emailDeTeste = "fulano@email.com";
    RepositorioDeAlunos repositorio = new RepositorioDeAlunosEmMemoria();
    PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
    publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());
    MatricularAluno useCase = new MatricularAluno(repositorio, publicadorDeEventos);
    MatricularAlunoDTO dados = new MatricularAlunoDTO(nomeDeTeste, cpfDeTeste, emailDeTeste);
    useCase.executa(dados);
    Aluno encontrado = repositorio.buscarPorCpf(new CPF(cpfDeTeste));
    assertEquals(nomeDeTeste, encontrado.getNome());
    assertEquals(cpfDeTeste, encontrado.getCpf().getNumero());
    assertEquals(emailDeTeste, encontrado.getEmail().getEndereco());
  }
}