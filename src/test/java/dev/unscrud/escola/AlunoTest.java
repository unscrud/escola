package dev.unscrud.escola;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.unscrud.escola.dominio.aluno.Aluno;
import dev.unscrud.escola.dominio.aluno.FabricaDeAluno;
import dev.unscrud.escola.dominio.aluno.QuantidadeMaximaDeTelefonesException;

public class AlunoTest {
  private Aluno aluno;

  @BeforeEach
  void beforeEach() {
    FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
    fabricaDeAluno.comNomeCpfEmail("Fulano da Silva", "123.456.789-00", "fulano@email.com");
    aluno = fabricaDeAluno.getAluno();
  }

  @Test
  void deveriaAceitarAdicionarUmTelefone() {
    this.aluno.adicionaTelefone("11", "12345678");
    assertEquals(1, this.aluno.getTelefones().size());
  }

  @Test
  void deveriaAceitarAdicionarDoisTelefones() {
    this.aluno.adicionaTelefone("11", "12345678");
    this.aluno.adicionaTelefone("21", "123456789");
    assertEquals(2, this.aluno.getTelefones().size());
  }

  @Test
  void naoDeveriaAceitarAdicionarTresTelefones() {
    this.aluno.adicionaTelefone("11", "12345678");
    this.aluno.adicionaTelefone("11", "12345678");
    assertThrows(QuantidadeMaximaDeTelefonesException.class, () -> {
      this.aluno.adicionaTelefone("11", "12345678");
    });
  }
}
