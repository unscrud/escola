package dev.unscrud.escola;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dev.unscrud.escola.aluno.Email;

public class EmailTest {
  @Test
  void naoDeveriaCriarEmailsComEnderecosInvalidos() {
    assertThrows(IllegalArgumentException.class, () -> new Email(null));
    assertThrows(IllegalArgumentException.class, () -> new Email(""));
    assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido"));
  }

  @Test
  void deveriaCriarEmailsComEnderecosValidos() {
    String[] enderecos = { "teste@teste.com", "teste@unscrud.dev", "some.test@email.tmp" };
    List<Email> emails = new ArrayList<>();
    for (String endereco : enderecos) {
      try {
        emails.add(new Email(endereco));
      } catch (IllegalArgumentException e) {
        System.out.println(endereco);
        System.out.println(e.getMessage());
        continue;
      }
    }
    assertEquals(enderecos.length, emails.size());
  }
}
