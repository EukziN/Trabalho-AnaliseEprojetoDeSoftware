package br.com.sistema.view;

import br.com.sistema.dao.ProdutosDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaProduto extends javax.swing.JFrame {

    private final ProdutosDAO produtosDAO = new ProdutosDAO();
    private int idProdutoSelecionado = 0;

    public TelaProduto() {
        initComponents();
        carregarTabela();
        setLocationRelativeTo(null);
    }

    private void limparCampos() {
        txtNome.setText("");
        txtDescricao.setText("");
        txtValor.setText("");
        idProdutoSelecionado = 0;
        tabelaProdutos.clearSelection();
        txtNome.requestFocus();
    }

    private void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaProdutos.getModel();
        modelo.setRowCount(0);

        List<Object[]> produtos = produtosDAO.listarTodos();
        for (Object[] produto : produtos) {
            modelo.addRow(produto);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produtos");

        jLabel1.setText("Nome:");
        jLabel2.setText("Descrição:");
        jLabel3.setText("Valor:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(evt -> btnSalvarActionPerformed(evt));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(evt -> btnEditarActionPerformed(evt));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(evt -> btnExcluirActionPerformed(evt));

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(evt -> btnLimparActionPerformed(evt));

        tabelaProdutos.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nome", "Descrição", "Valor"}
        ));
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProdutos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(15)
                        .addComponent(btnEditar)
                        .addGap(15)
                        .addComponent(btnExcluir)
                        .addGap(15)
                        .addComponent(btnLimpar)))
                .addGap(35))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar))
                .addGap(20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(20)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void btnExcluirMouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void btnLimparMouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        String nome = txtNome.getText().trim();
        String descricao = txtDescricao.getText().trim();
        String valorTexto = txtValor.getText().trim();

        if (nome.isEmpty() || descricao.isEmpty() || valorTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        try {
            double valor = Double.parseDouble(valorTexto.replace(",", "."));

            if (valor < 0) {
                JOptionPane.showMessageDialog(this, "O valor não pode ser negativo!");
                return;
            }

            produtosDAO.cadastrar(nome, descricao, valor);
            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
            limparCampos();
            carregarTabela();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um valor válido!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        if (idProdutoSelecionado == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela!");
            return;
        }

        String nome = txtNome.getText().trim();
        String descricao = txtDescricao.getText().trim();
        String valorTexto = txtValor.getText().trim();

        if (nome.isEmpty() || descricao.isEmpty() || valorTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        try {
            double valor = Double.parseDouble(valorTexto.replace(",", "."));

            if (valor < 0) {
                JOptionPane.showMessageDialog(this, "O valor não pode ser negativo!");
                return;
            }

            produtosDAO.atualizar(idProdutoSelecionado, nome, descricao, valor);
            JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
            limparCampos();
            carregarTabela();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um valor válido!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar produto: " + e.getMessage());
        }
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        if (idProdutoSelecionado == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela!");
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir este produto?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                produtosDAO.excluir(idProdutoSelecionado);
                JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
                limparCampos();
                carregarTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir produto: " + e.getMessage());
            }
        }
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        limparCampos();
    }

    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {
        int linha = tabelaProdutos.getSelectedRow();

        if (linha >= 0) {
            idProdutoSelecionado = Integer.parseInt(
                    tabelaProdutos.getValueAt(linha, 0).toString()
            );
            txtNome.setText(tabelaProdutos.getValueAt(linha, 1).toString());
            txtDescricao.setText(tabelaProdutos.getValueAt(linha, 2).toString());
            txtValor.setText(tabelaProdutos.getValueAt(linha, 3).toString());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaProduto().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
