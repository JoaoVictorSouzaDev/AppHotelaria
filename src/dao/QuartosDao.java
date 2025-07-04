package dao;

import model.Quartos;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuartosDao {
    private Conexao conexao = new Conexao();

    public boolean inserirQuartos() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement novoQuarto = conndb.prepareStatement("INSERT INTO quartos " +
                    "(nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel)" +
                    "VALUES (?, ?, ?, ?, ?, ?);");

            novoQuarto.setString(1, "Suíte");
            novoQuarto.setInt(2, 1);
            novoQuarto.setInt(3,1);
            novoQuarto.setInt(4, 2);
            novoQuarto.setDouble(5, 1500.00);
            novoQuarto.setBoolean(6, true);

            int linhaAfetada = novoQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }catch (Exception erro) {
            System.out.println("Erro ao inserir quarto: " + erro);
            return false;
        }
    }
    public boolean deletarQuartos() {
        try{
            Connection conndb = conexao.conectar();
            PreparedStatement removeQuarto = conndb.prepareStatement("DELETE FROM quartos WHERE id = ?;");

            removeQuarto.setInt(1, 1);

            int linhaAfetada = removeQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar quarto: " + erro);
            return false;
        }
    }
    public boolean alterarQuartos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarQuarto = conndb.prepareStatement("UPDATE quartos" + "SET nome = ?, numero = ?, qtd_cama_casal = ?, " +
                    "qtd_cama_solteiro = ?, preco = ?, disponivel = ?  WHERE id = ?;");

            alterarQuarto.setString(1, "Quarto Grande");
            alterarQuarto.setInt(2, 45);
            alterarQuarto.setInt(3, 2);
            alterarQuarto.setInt(4, 2);
            alterarQuarto.setDouble(5, 1500.00);
            alterarQuarto.setInt(6, 2);
            alterarQuarto.setInt(7, 1);

            int linhaAfetada = alterarQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar quartos: " + erro);
        }
        return false;
    }

    public void pesquisarQuartos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement pesquisarQuartos = conndb.prepareStatement("SELECT nome, numero, preco FROM quartos WHERE preco < ?;");
            pesquisarQuartos.setInt(1, 2000);
            ResultSet resultado = pesquisarQuartos.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String numero = resultado.getString("numero");
                double preco = resultado.getDouble("preco");
                System.out.println("Nome: " + nome +"\nNumero: " + numero +"\nPreco: " + preco);

            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar quarto: " + erro);
        }
    }
    public boolean inserirQuartos(Quartos quartos) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement stmt = conndb.prepareStatement("INSERT INTO quartos (nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel) VALUES (?, ?, ?, ?, ?, ?);");
            stmt.setString(1, quartos.getNome());
            stmt.setString(2, quartos.getNumero());
            stmt.setInt(3, quartos.getQtdCamaCasal());
            stmt.setInt(4, quartos.getQtdCamaSolteiros());
            stmt.setDouble(5, quartos.getPreco());
            stmt.setBoolean(6, quartos.isDisponivel());

            int linhaAfetada = stmt.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir quarto: " + erro);
            return false;
        }
    }
}
