package dev.unscrud.escola;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dev.unscrud.escola.dominio.aluno.Telefone;

public class TelefoneTest {
  private final String[] dddsInvalidos = { null, "1", "a4", "333" };
  private final String[] telefonesInvalidos = { null, "", "", "" };
  private final String[] dddsValidos = { "21", "22", "23" };
  private final String[] telefonesValidos = { "12345678", "123456789" };

  @Test
  void naoDeveriaAceitarDDDETelefonesInvalidos() {
    List<Telefone> telefones = new ArrayList<>();
    for (String ddd : dddsInvalidos) {
      for (String numero : telefonesInvalidos) {
        try {
          telefones.add(new Telefone(ddd, numero));
        } catch (IllegalArgumentException e) {
          assertThrows(IllegalArgumentException.class,
              () -> new Telefone(ddd, numero));
        }
      }
    }
    assertEquals(0, telefones.size());
  }

  @Test
  void naoDeveriaAceitarDDDInvalidoComTelefoneValido() {
    List<Telefone> telefones = new ArrayList<>();
    for (String ddd : dddsInvalidos) {
      for (String numero : telefonesValidos) {
        try {
          telefones.add(new Telefone(ddd, numero));
        } catch (IllegalArgumentException e) {
          assertThrows(IllegalArgumentException.class,
              () -> new Telefone(ddd, numero));
        }
      }
    }
    assertEquals(0, telefones.size());
  }

  @Test
  void naoDeveriaAceitarDDDValidoComTelefoneInvalido() {
    List<Telefone> telefones = new ArrayList<>();
    for (String ddd : dddsValidos) {
      for (String numero : telefonesInvalidos) {
        try {
          telefones.add(new Telefone(ddd, numero));
        } catch (IllegalArgumentException e) {
          assertThrows(IllegalArgumentException.class,
              () -> new Telefone(ddd, numero));
        }
      }
    }
    assertEquals(0, telefones.size());
  }

  @Test
  void deveriaAceitarDDDeTelefonesValidos() {
    List<Telefone> telefones = new ArrayList<>();
    for (String ddd : dddsValidos) {
      for (String numero : telefonesValidos) {
        try {
          telefones.add(new Telefone(ddd, numero));
        } catch (IllegalArgumentException e) {
          assertThrows(IllegalArgumentException.class,
              () -> new Telefone(ddd, numero));
        }
      }
    }
    assertEquals(6, telefones.size());
  }
}
