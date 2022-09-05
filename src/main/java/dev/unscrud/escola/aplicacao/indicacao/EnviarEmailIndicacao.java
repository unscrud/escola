package dev.unscrud.escola.aplicacao.indicacao;

import dev.unscrud.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
  void enviarPara(Aluno indicado);
}
