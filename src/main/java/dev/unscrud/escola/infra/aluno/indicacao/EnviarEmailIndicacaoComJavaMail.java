package dev.unscrud.escola.infra.aluno.indicacao;

import dev.unscrud.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import dev.unscrud.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

  @Override
  public void enviarPara(Aluno indicado) {
    // logica de envio de emails com java mail

  }

}
