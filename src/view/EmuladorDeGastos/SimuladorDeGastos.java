/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.EmuladorDeGastos;

import Dao.DespesaDao;
import Dao.GastosDAO;
import com.sun.source.tree.BreakTree;
import java.awt.Color;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Despesa;
import model.Formatador;
import model.Gasto;
import model.Rendimento;
import view.Main;
import view.geral.Notificacao;

/**
 *
 * @author berna
 */
public class SimuladorDeGastos extends javax.swing.JPanel {

    /**
     * Creates new form PainelObjectivosFinanceiros
     */
    public SimuladorDeGastos() {

        initComponents();
        tableModel = (DefaultTableModel) tbGastos.getModel();

        GastosDAO.carregarDespesas().forEach((p) -> {
            DefaultComboBoxModel modelCbCat = (DefaultComboBoxModel) cbCategoria.getModel();
            modelCbCat.addElement(p);

        });

        GastosDAO.carregarRendimentos().forEach((p) -> {

            DefaultComboBoxModel modelCbFont = (DefaultComboBoxModel) cbFonte.getModel();
            modelCbFont.addElement(p);

        });

        preencherTabela();
        despesaGasto= (Despesa) cbCategoria.getSelectedItem();
        rendimento= (Rendimento) cbFonte.getSelectedItem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lbListaObjectivos = new javax.swing.JLabel();
        lbPrioridadeV = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbFonte = new javax.swing.JComboBox<>();
        btnAplicarValor = new javax.swing.JButton();
        lbValorDisponível = new javax.swing.JLabel();
        lbObjectivo = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        lbDescricao = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfValorGasto = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbGastos = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();

        setMaximumSize(new java.awt.Dimension(950, 594));
        setMinimumSize(new java.awt.Dimension(950, 594));
        setPreferredSize(new java.awt.Dimension(950, 594));

        lbListaObjectivos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbListaObjectivos.setText("Lista de Gastos realizados");

        lbPrioridadeV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPrioridadeV.setText("Prioridade:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Fonte de valor");

        cbFonte.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbFonte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFonteItemStateChanged(evt);
            }
        });

        btnAplicarValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAplicarValor.setText("Confirmar Gasto");
        btnAplicarValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAplicarValorMouseEntered(evt);
            }
        });
        btnAplicarValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarValorActionPerformed(evt);
            }
        });

        lbValorDisponível.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbValorDisponível.setText("Valor Disponível: ");

        lbObjectivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbObjectivo.setText("Categoria");

        cbCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCategoriaItemStateChanged(evt);
            }
        });

        lbDescricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDescricao.setText("Descrição do Gasto");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Valor Gasto");

        tfValorGasto.setDocument(new Formatador(10, Formatador.TipoEntrada.NUMERO_DECIMAL));
        tfValorGasto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfValorGasto.setText("0");
        tfValorGasto.setToolTipText("Ex:10000");
        tfValorGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValorGastoActionPerformed(evt);
            }
        });

        tbGastos.getTableHeader().setSize(tbGastos.getWidth(), 30);
        tbGastos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoria", "Descrição", "Valor", "Prioridade", "Poupado", "Fonte"
            }
        ));
        tbGastos.setRowHeight(30);
        jScrollPane5.setViewportView(tbGastos);

        taDescricao.setColumns(10);
        taDescricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taDescricao.setLineWrap(true);
        taDescricao.setRows(3);
        jScrollPane1.setViewportView(taDescricao);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbPrioridadeV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbObjectivo)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDescricao))
                        .addGap(92, 92, 92)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(cbFonte, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(145, 145, 145)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfValorGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAplicarValor)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                                .addComponent(lbValorDisponível)))))
                .addGap(124, 124, 124))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbListaObjectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(379, 379, 379))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbObjectivo)
                                    .addComponent(jLabel13))
                                .addGap(0, 0, 0)
                                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbFonte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbDescricao)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(lbPrioridadeV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lbValorDisponível))
                        .addComponent(tfValorGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnAplicarValor)))
                .addGap(15, 15, 15)
                .addComponent(lbListaObjectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Emulador de Gastos", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void preencherTabela() {
        this.tableModel.setNumRows(0);
        GastosDAO.fillTable().forEach((p) -> {
            this.tableModel.addRow(new Object[]{p.getCategoria(), p.getDescricao(),
                p.getValorGasto(), p.getPrioridade(), p.getValorPoupado(), p.getFonteValor()});
        });
    }

    private void tfValorGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorGastoActionPerformed
    }//GEN-LAST:event_tfValorGastoActionPerformed

    private void btnAplicarValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarValorActionPerformed
        if (!tfValorGasto.getText().isBlank()) {
            if (Double.valueOf(tfValorGasto.getText()) > despesaGasto.getCusto() || Double.valueOf(tfValorGasto.getText()) <= 0.0) {
                Notificacao.mostrarDialogoDeOpcaoSingular(Main.main, "O valor gasto não deve ser menor ou igual a zero ou maior que o alocado para esta despesa", Notificacao.ICONE_ERRO);
                tfValorGasto.setText("");
            } else {
                String descricao = taDescricao.getText();
                double valorGasto = Double.valueOf(tfValorGasto.getText());

                this.gasto.setDescricao(descricao);
                this.gasto.setValorGasto(valorGasto);
                this.gasto.setValorPoupado(despesaGasto.getCusto() - valorGasto);
                this.gasto.setValorGasto(Double.valueOf(tfValorGasto.getText()));
                this.gasto.setFonteValor(this.rendimento.getFonteRendimento());
                despesaGasto.setCusto(gasto.getValorPoupado());
                GastosDAO.actualizarCusto(despesaGasto);
                if (GastosDAO.guardar(gasto)) {
                    preencherTabela();
                    Notificacao.mostrarDialogoDeOpcaoSingular(Main.main, "Gasto registado com sucesso!", Notificacao.ICONE_SUCESSO);
                } else {
                    Notificacao.mostrarDialogoDeOpcaoSingular(Main.main, "A operação falhou!\nOcorreu um erro ao registar o gasto.", Notificacao.ICONE_ERRO);
                }
            }
        }
    }//GEN-LAST:event_btnAplicarValorActionPerformed

    private void cbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCategoriaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
//            Despesa despesaTemp = (Despesa) cbCategoria.getSelectedItem();
//            lbValorDisponível.setText("Valor Disponível: " + String.valueOf(despesaTemp.getCusto()));
//            this.despesaGasto.setCusto(despesaTemp.getCusto());
//            this.gasto.setPrioridade(despesaTemp.getPrioridade());
//            lbPrioridadeV.setText("Prioridade: " + despesaTemp.getPrioridade());
//            this.gasto.setCategoria(despesaTemp.getCategoria());
//            this.despesaGasto.setId(despesaTemp.getId());


 despesaGasto = (Despesa) cbCategoria.getSelectedItem();
            lbValorDisponível.setText("Valor Disponível: " + String.valueOf(despesaGasto.getCusto()));
            this.gasto.setPrioridade(despesaGasto.getPrioridade());
            lbPrioridadeV.setText("Prioridade: " + despesaGasto.getPrioridade());
            this.gasto.setCategoria(despesaGasto.getCategoria());
            

        }
    }//GEN-LAST:event_cbCategoriaItemStateChanged

    private void cbFonteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFonteItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Rendimento rendimentoTemp = (Rendimento) cbFonte.getSelectedItem();
            this.rendimento.setFonteRendimento(rendimentoTemp.getFonteRendimento());
        }
    }//GEN-LAST:event_cbFonteItemStateChanged

    private void btnAplicarValorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAplicarValorMouseEntered
        if (!tfValorGasto.getText().isBlank())
            if (Double.valueOf(tfValorGasto.getText()) > despesaGasto.getCusto() || Double.valueOf(tfValorGasto.getText()) <= 0) {
                Notificacao.mostrarDialogoDeOpcaoSingular(Main.main, "O valor gasto não deve ser menor ou igual a zero ou maior que o alocado para esta despesa", Notificacao.ICONE_ERRO);
                tfValorGasto.setText("");

            }
    }//GEN-LAST:event_btnAplicarValorMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarValor;
    private javax.swing.JComboBox<Despesa> cbCategoria;
    private javax.swing.JComboBox<Rendimento> cbFonte;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbListaObjectivos;
    private javax.swing.JLabel lbObjectivo;
    private javax.swing.JLabel lbPrioridadeV;
    private javax.swing.JLabel lbValorDisponível;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTable tbGastos;
    private javax.swing.JTextField tfValorGasto;
    // End of variables declaration//GEN-END:variables
   public static Gasto gasto = new Gasto();
    public static Despesa despesaGasto = new Despesa();
    Rendimento rendimento = new Rendimento();
    DefaultTableModel tableModel;

}
