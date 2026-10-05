package br.com.sistema.view;

import br.com.sistema.dao.FuncionarioDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaFuncionario extends javax.swing.JFrame {

    private final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private int idFuncionarioSelecionado = 0;
    private final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    public TelaFuncionario() {
        initComponents();
        carregarTabela();
        setLocationRelativeTo(null);
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtDataInclusao.setText("");
        idFuncionarioSelecionado = 0;
        tabelaFuncionarios.clearSelection();
        txtNome.requestFocus();
    }

    private Date converterData(String texto) throws ParseException {
        formatoData.setLenient(false);
        java.util.Date data = formatoData.parse(texto);
        return new Date(data.getTime());
    }

    private void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaFuncionarios.getModel();
        modelo.setRowCount(0);

        List<Object[]> funcionarios = funcionarioDAO.listarTodos();

        for (Object[] funcionario : funcionarios) {
            Object data = funcionario[3];

            if (data instanceof Date) {
                funcionario[3] = formatoData.format((Date) data);
            }

            modelo.addRow(funcionario);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtDataInclusao = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Funcionários");

        jLabel1.setText("Nome:");
        jLabel2.setText("CPF:");
        jLabel3.setText("Data de inclusão (dd/MM/yyyy):");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(evt -> btnSalvarActionPerformed(evt));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(evt -> btnEditarActionPerformed(evt));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(evt -> btnExcluirActionPerformed(evt));

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(evt -> btnLimparActionPerformed(evt));

        tabelaFuncionarios.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nome", "CPF", "Data de inclusão"}
        ));
        tabelaFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFuncionarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataInclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(15)
                        .addComponent(btnEditar)
                        .addGap(15)
                        .addComponent(btnExcluir)
                        .addGap(15)
                        .addComponent(btnLimpar)))
                .addGap(30))
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
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataInclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar))
                .addGap(20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addGap(20)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        String nome = txtNome.getText().trim();
        String cpf = txtCpf.getText().trim();
        String dataTexto = txtDataInclusao.getText().trim();

        if (nome.isEmpty() || cpf.isEmpty() || dataTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        try {
            Date data = converterData(dataTexto);
            funcionarioDAO.cadastrar(nome, cpf, data);

            JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");
            limparCampos();
            carregarTabela();

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/MM/yyyy.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        if (idFuncionarioSelecionado == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário na tabela!");
            return;
        }

        String nome = txtNome.getText().trim();
        String cpf = txtCpf.getText().trim();
        String dataTexto = txtDataInclusao.getText().trim();

        if (nome.isEmpty() || cpf.isEmpty() || dataTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        try {
            Date data = converterData(dataTexto);
            funcionarioDAO.atualizar(idFuncionarioSelecionado, nome, cpf, data);

            JOptionPane.showMessageDialog(this, "Funcionário atualizado com sucesso!");
            limparCampos();
            carregarTabela();

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/MM/yyyy.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar funcionário: " + e.getMessage());
        }
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        if (idFuncionarioSelecionado == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário na tabela!");
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir este funcionário?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                funcionarioDAO.excluir(idFuncionarioSelecionado);

                JOptionPane.showMessageDialog(this, "Funcionário excluído com sucesso!");
                limparCampos();
                carregarTabela();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir funcionário: " + e.getMessage());
            }
        }
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        limparCampos();
    }

    private void tabelaFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {
        int linha = tabelaFuncionarios.getSelectedRow();

        if (linha >= 0) {
            idFuncionarioSelecionado = Integer.parseInt(
                    tabelaFuncionarios.getValueAt(linha, 0).toString()
            );

            txtNome.setText(tabelaFuncionarios.getValueAt(linha, 1).toString());
            txtCpf.setText(tabelaFuncionarios.getValueAt(linha, 2).toString());
            txtDataInclusao.setText(tabelaFuncionarios.getValueAt(linha, 3).toString());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaFuncionario().setVisible(true));
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
    private javax.swing.JTable tabelaFuncionarios;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtDataInclusao;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
