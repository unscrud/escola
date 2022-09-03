package dev.unscrud.escola.aluno;

public class Email {
  private String endereco;

  public String getEndereco() {
    return endereco;
  }

  public Email(String endereco) {
    if (endereco == null || isInvalido(endereco)) {
      throw new IllegalArgumentException("Email Inválido!");
    }
    this.endereco = endereco;
  }

  private boolean isInvalido(String endereco) {
    final String REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    return !endereco.matches(REGEX);
  }
}
