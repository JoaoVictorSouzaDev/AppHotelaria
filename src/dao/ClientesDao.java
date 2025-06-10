package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientesDao {
    private Conexao conexao = new Conexao();

    public boolean inserirClientes() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement novoCliente = conndb.prepareStatement("INSERT INTO clientes " +
                    "(nome, cpf, telefone, email) VALUES (?, ?, ?, ?);");

            novoCliente.setString(1, "Uira");
            novoCliente.setString(2, "123.456.789-10");
            novoCliente.setString(3,"(00) 12345-6789" );
            novoCliente.setString(4, "Uircardoso123@gmail.com");

            int linhaAfetada = novoCliente.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }catch (Exception erro) {
            System.out.println("Erro ao inserir cliente: " + erro);
            return false;
        }
    }
    public boolean deletarClientes() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement removeClientes = conndb.prepareStatement("DELETE FROM clientes WHERE id = ?;");

            removeClientes.setInt(1, 1);

            int linhaAfetada = removeClientes.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar clientes: " + erro);
            return false;
        }
    }
}