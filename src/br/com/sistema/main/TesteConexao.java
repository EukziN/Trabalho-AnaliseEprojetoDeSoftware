package br.com.sistema.main;

import br.com.sistema.jdbc.ConnectionFactory;
import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {
        try (Connection conexao = ConnectionFactory.getConnection()) {
            System.out.println("Conexão realizada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
