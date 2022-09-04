package dev.unscrud.escola;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dev.unscrud.escola.dominio.aluno.CPF;

public class CPFTest {
  private final String[] numerosInvalidos = { null, "teste", "1234567890", "123.123.I23-l2" };
  private final String[] numerosValidos = { "018.092.610-15", "123.456.789-00", "789.456.789-55" };

  @Test
  void naoDeveriaAceitarCPF() {
    List<CPF> cpfs = new ArrayList<>();
    for (String numero : numerosInvalidos) {
      try {
        cpfs.add(new CPF(numero));
      } catch (IllegalArgumentException e) {
        assertThrows(IllegalArgumentException.class,
            () -> new CPF(numero));
        continue;
      }
      assertEquals(0, cpfs.size());
    }
  }

  @Test
  void deveriaAceitarCPF() {
    List<CPF> cpfs = new ArrayList<>();
    for (String numero : numerosValidos) {
      try {
        assertDoesNotThrow(() -> cpfs.add(new CPF(numero)));
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        continue;
      }
    }

    assertEquals(3, cpfs.size());

  }
}
