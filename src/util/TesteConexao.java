package util;

import dao.*;
import model.Usuarios;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();

        Usuarios usuarios = new Usuarios("João", "Souza@gmail.com", "321", 1);

        if (condb != null) {
            System.out.println("Conexão estabelcida com sucesso!");
            try {

                UsuariosDao usuariosDao = new UsuariosDao();
                usuariosDao.altenticarUsuario(usuarios);

                condb.close();
                System.out.println("Conexão encerrada!");

            } catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão: " + erro.getMessage());
            }
        } else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}