package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void cadastrar(String nome, String cpf, String endereco) {
        String sql = "INSERT INTO tb_cliente (nome, cpf, endereco) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, endereco);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar cliente.", e);
        }
    }

    public List<Object[]> listarTodos() {
        String sql = "SELECT * FROM tb_cliente ORDER BY id";
        List<Object[]> clientes = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Object[] cliente = new Object[4];
                cliente[0] = rs.getInt("id");
                cliente[1] = rs.getString("nome");
                cliente[2] = rs.getString("cpf");
                cliente[3] = rs.getString("endereco");
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes.", e);
        }
        return clientes;
    }

    public Object[] buscarPorId(int id) {
        String sql = "SELECT * FROM tb_cliente WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Object[] cliente = new Object[4];
                    cliente[0] = rs.getInt("id");
                    cliente[1] = rs.getString("nome");
                    cliente[2] = rs.getString("cpf");
                    cliente[3] = rs.getString("endereco");
                    return cliente;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cliente.", e);
        }
        return null;
    }

    public void atualizar(int id, String nome, String cpf, String endereco) {
        String sql = "UPDATE tb_cliente SET nome = ?, cpf = ?, endereco = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, endereco);
            stmt.setInt(4, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar cliente.", e);
        }
    }
    public void excluir(int id) {
        String sql = "DELETE FROM tb_cliente WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir cliente.", e);
        }
    }
}
