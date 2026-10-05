package br.com.sistema.view;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        menuTelaPrincipal = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        menuItemClientes = new javax.swing.JMenuItem();
        menuItemProdutos = new javax.swing.JMenuItem();
        menuItemFuncionarios = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        menuItemRelatorioClientes = new javax.swing.JMenuItem();
        menuItemRelatorioProdutos = new javax.swing.JMenuItem();
        menuItemRelatorioVendas = new javax.swing.JMenuItem();
        menuSistema = new javax.swing.JMenu();
        menuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Vendas");

        menuCadastros.setText("Cadastros");
        menuItemClientes.setText("Clientes");
        menuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClientesActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemClientes);

        menuItemProdutos.setText("Produtos");
        menuItemProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProdutosActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemProdutos);

        menuItemFuncionarios.setText("Funcionários");
        menuItemFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFuncionariosActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemFuncionarios);
        menuTelaPrincipal.add(menuCadastros);

        menuRelatorios.setText("Relatórios");
        menuItemRelatorioClientes.setText("Clientes");
        menuItemRelatorioClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarRelatorio("Clientes");
            }
        });
        menuRelatorios.add(menuItemRelatorioClientes);

        menuItemRelatorioProdutos.setText("Produtos");
        menuItemRelatorioProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarRelatorio("Produtos");
            }
        });
        menuRelatorios.add(menuItemRelatorioProdutos);

        menuItemRelatorioVendas.setText("Vendas");
        menuItemRelatorioVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarRelatorio("Vendas");
            }
        });
        menuRelatorios.add(menuItemRelatorioVendas);
        menuTelaPrincipal.add(menuRelatorios);

        menuSistema.setText("Sistema");
        menuItemSair.setText("Sair");
        menuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSairActionPerformed(evt);
            }
        });
        menuSistema.add(menuItemSair);
        menuTelaPrincipal.add(menuSistema);

        setJMenuBar(menuTelaPrincipal);
        setSize(700, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {
        new TelaCliente().setVisible(true);
    }

    private void menuItemProdutosActionPerformed(java.awt.event.ActionEvent evt) {
        new TelaProduto().setVisible(true);
    }

    private void menuItemFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {
        new TelaFuncionario().setVisible(true);
    }

    private void mostrarRelatorio(String tipo) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Relatório de " + tipo + " será implementado na próxima etapa.",
                "Relatórios",
                javax.swing.JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void menuItemSairActionPerformed(java.awt.event.ActionEvent evt) {
        int resposta = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente sair?",
                "Sair",
                javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (resposta == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar menuTelaPrincipal;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuRelatorios;
    private javax.swing.JMenu menuSistema;
    private javax.swing.JMenuItem menuItemClientes;
    private javax.swing.JMenuItem menuItemProdutos;
    private javax.swing.JMenuItem menuItemFuncionarios;
    private javax.swing.JMenuItem menuItemRelatorioClientes;
    private javax.swing.JMenuItem menuItemRelatorioProdutos;
    private javax.swing.JMenuItem menuItemRelatorioVendas;
    private javax.swing.JMenuItem menuItemSair;
    // End of variables declaration//GEN-END:variables
}
