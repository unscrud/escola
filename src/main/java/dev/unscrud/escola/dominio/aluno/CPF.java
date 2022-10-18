package dev.unscrud.escola.dominio.aluno;

public class CPF {
  private String numero;

  public String getNumero() {
    return numero;
  }

  public CPF(String numero) {
    if (numero == null || isInvalido(numero)) {
      throw new IllegalArgumentException("CPF Inválido!");
    }
    this.numero = numero;
  }

  private boolean isInvalido(String numero) {
    final String REGEX = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}";
    return !numero.matches(REGEX);
  }

  @Override
  public String toString() {
    return numero;
  }
}
