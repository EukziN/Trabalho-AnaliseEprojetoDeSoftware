package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    public void cadastrar(String nome, String descricao, double valor) {
        String sql = "INSERT INTO tb_produto (nome, descricao, valor) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setDouble(3, valor);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar produto.", e);
        }
    }

    public List<Object[]> listarTodos() {
        String sql = "SELECT * FROM tb_produto ORDER BY id";
        List<Object[]> produtos = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Object[] produto = new Object[4];
                produto[0] = rs.getInt("id");
                produto[1] = rs.getString("nome");
                produto[2] = rs.getString("descricao");
                produto[3] = rs.getDouble("valor");
                produtos.add(produto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos.", e);
        }
        return produtos;
    }

    //busca por id
    public Object[] buscarPorId(int id) {
        String sql = "SELECT * FROM tb_produto WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Object[] produto = new Object[4];
                    produto[0] = rs.getInt("id");
                    produto[1] = rs.getString("nome");
                    produto[2] = rs.getString("descricao");
                    produto[3] = rs.getDouble("valor");
                    return produto;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto.", e);
        }
        return null;
    }

    public void atualizar(int id, String nome, String descricao, double valor) {
        String sql = "UPDATE tb_produto SET nome = ?, descricao = ?, valor = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setDouble(3, valor);
            stmt.setInt(4, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto.", e);
        }
    }
    public void excluir(int id) {
        String sql = "DELETE FROM tb_produto WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir produto.", e);
        }
    }
}
