package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDao {
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios " +
                    "(nome, senha, email, fk_funcoes) VALUES (?, ?, md5(?), ?);");

            novoUsuario.setString(1, "João");
            novoUsuario.setString(2, "123");
            novoUsuario.setString(3,"joasouza123@gmail.com" );
            novoUsuario.setInt(4, 1);

            int linhaAfetada = novoUsuario.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }
    public boolean deletarUsuario() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement removeUsuario = conndb.prepareStatement("DELETE FROM usuarios WHERE id = ?;");

            removeUsuario.setInt(1, 1);

            int linhaAfetada = removeUsuario.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar usuario: " + erro);
            return false;
        }
    }
}
