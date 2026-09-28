package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO responsável pelas operações CRUD na tabela tb_funcionario.
 *
 * @author erick
 */
public class FuncionarioDAO {

    /**
     * Cadastra um novo funcionário no banco de dados.
     *
     * @param nome          nome do funcionário
     * @param cpf           CPF do funcionário
     * @param dataInclusao  data de inclusão do funcionário
     */
    public void cadastrar(String nome, String cpf, Date dataInclusao) {
        String sql = "INSERT INTO tb_funcionario (nome, cpf, data_inclusao) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setDate(3, dataInclusao);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar funcionário.", e);
        }
    }

    /**
     * Lista todos os funcionários cadastrados.
     *
     * @return lista de arrays de objetos contendo [id, nome, cpf, data_inclusao]
     */
    public List<Object[]> listarTodos() {
        String sql = "SELECT * FROM tb_funcionario ORDER BY id";
        List<Object[]> funcionarios = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Object[] func = new Object[4];
                func[0] = rs.getInt("id");
                func[1] = rs.getString("nome");
                func[2] = rs.getString("cpf");
                func[3] = rs.getDate("data_inclusao");
                funcionarios.add(func);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar funcionários.", e);
        }
        return funcionarios;
    }

    /**
     * Busca um funcionário pelo ID.
     *
     * @param id o ID do funcionário
     * @return array de objetos [id, nome, cpf, data_inclusao] ou null se não encontrado
     */
    public Object[] buscarPorId(int id) {
        String sql = "SELECT * FROM tb_funcionario WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Object[] func = new Object[4];
                    func[0] = rs.getInt("id");
                    func[1] = rs.getString("nome");
                    func[2] = rs.getString("cpf");
                    func[3] = rs.getDate("data_inclusao");
                    return func;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar funcionário.", e);
        }
        return null;
    }

    /**
     * Atualiza os dados de um funcionário.
     *
     * @param id            o ID do funcionário a ser atualizado
     * @param nome          novo nome
     * @param cpf           novo CPF
     * @param dataInclusao  nova data de inclusão
     */
    public void atualizar(int id, String nome, String cpf, Date dataInclusao) {
        String sql = "UPDATE tb_funcionario SET nome = ?, cpf = ?, data_inclusao = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setDate(3, dataInclusao);
            stmt.setInt(4, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar funcionário.", e);
        }
    }

    /**
     * Exclui um funcionário pelo ID.
     *
     * @param id o ID do funcionário a ser excluído
     */
    public void excluir(int id) {
        String sql = "DELETE FROM tb_funcionario WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir funcionário.", e);
        }
    }
}
