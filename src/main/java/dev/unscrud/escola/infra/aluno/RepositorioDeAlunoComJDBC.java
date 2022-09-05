package dev.unscrud.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.unscrud.escola.dominio.aluno.Aluno;
import dev.unscrud.escola.dominio.aluno.CPF;
import dev.unscrud.escola.dominio.aluno.Email;
import dev.unscrud.escola.dominio.aluno.RepositorioDeAlunos;
import dev.unscrud.escola.dominio.aluno.Telefone;

public class RepositorioDeAlunoComJDBC implements RepositorioDeAlunos {

  private final Connection con;

  public RepositorioDeAlunoComJDBC(Connection con) {
    this.con = con;
  }

  @Override
  public void matricular(Aluno aluno) {

    String sql = "INSERT INTO ALUNO VALUES (?,?,?)";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setString(1, aluno.getCpf().getNumero());
      ps.setString(2, aluno.getNome());
      ps.setString(3, aluno.getEmail().getEndereco());
      ps.execute();

      String sqlTel = "INSERT INTO TELEFONE VALUES (?,?)";
      try (PreparedStatement pst = con.prepareStatement(sqlTel)) {
        for (Telefone telefone : aluno.getTelefones()) {
          pst.setString(1, telefone.getDdd());
          pst.setString(2, telefone.getNumero());
          pst.execute();
        }
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public Aluno buscarPorCpf(CPF cpf) {
    String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setString(1, cpf.getNumero());

      ResultSet rs = ps.executeQuery();
      boolean encontrou = rs.next();
      if (!encontrou)
        throw new AlunoNaoEncontrado(cpf);

      String nome = rs.getString("nome");
      Email email = new Email(rs.getString("email"));
      Aluno encontrado = new Aluno(cpf, nome, email);
      Long id = rs.getLong("id");

      String sqlt = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
      try (PreparedStatement pst = con.prepareStatement(sqlt)) {
        ps.setLong(1, id);
        ResultSet rst = pst.executeQuery();
        while (rst.next()) {
          String ddd = rs.getString("ddd");
          String numero = rs.getString("numero");
          encontrado.adicionaTelefone(ddd, numero);
        }
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
      return encontrado;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Aluno> listarTodosAlunosMatriculados() {
    String sql = "SELECT id, cpf, nome, email FROM ALUNO";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ResultSet rs = ps.executeQuery();
      List<Aluno> alunos = new ArrayList<>();
      while (rs.next()) {
        CPF cpf = new CPF(rs.getString("cpf"));
        String nome = rs.getString("nome");
        Email email = new Email(rs.getString("email"));
        Aluno aluno = new Aluno(cpf, nome, email);
        Long id = rs.getLong("id");
        String sqlt = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
        try (PreparedStatement pst = con.prepareStatement(sqlt)) {
          pst.setLong(1, id);
          ResultSet rst = ps.executeQuery();
          while (rst.next()) {
            String ddd = rs.getString("ddd");
            String numero = rs.getString("numero");
            aluno.adicionaTelefone(ddd, numero);
          }
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
        alunos.add(aluno);
      }
      return alunos;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
