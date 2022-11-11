/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.simuladorDeGastos;

//import Backup.*;

import Backup.*;




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
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbListaObjectivos = new javax.swing.JLabel();
        lbPrioridadeV = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbFonte = new javax.swing.JComboBox<>();
        btnAplicarValor = new javax.swing.JButton();
        lbValorDisponível = new javax.swing.JLabel();
        lbObjectivo = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lbDescricao = new javax.swing.JLabel();
        taDescricao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(950, 594));
        setMinimumSize(new java.awt.Dimension(950, 594));
        setPreferredSize(new java.awt.Dimension(950, 594));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 938, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Gerir Objectivos", jPanel2);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbListaObjectivos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbListaObjectivos.setText("Lista de Gastos realizados");
        jPanel1.add(lbListaObjectivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        lbPrioridadeV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPrioridadeV.setText("Prioridade do Gasto:");
        jPanel1.add(lbPrioridadeV, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Fonte de valor");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));

        cbFonte.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbFonte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Venda de Livros", "Aulas Particulares", "Salário UEM", "Ações Cahora Bhassa" }));
        jPanel1.add(cbFonte, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, -1, -1));

        btnAplicarValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAplicarValor.setText("Confirmar Gasto");
        btnAplicarValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarValorActionPerformed(evt);
            }
        });
        jPanel1.add(btnAplicarValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        lbValorDisponível.setText("Valor Disponível:");
        jPanel1.add(lbValorDisponível, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        lbObjectivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbObjectivo.setText("Categoria");
        jPanel1.add(lbObjectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, -1, -1));

        lbDescricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDescricao.setText("Descrição do Gasto");
        jPanel1.add(lbDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        taDescricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taDescricao.setToolTipText("Descrição do Objectivo Financeiro");
        taDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taDescricaoActionPerformed(evt);
            }
        });
        jPanel1.add(taDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 190, 80));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Valor Gasto");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, -1));

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField3.setText("0,00Mt");
        jTextField3.setToolTipText("Ex:10000");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Categoria", "Tipo de Gasto", "Descrição", "Valor", "Prioridade"
            }
        ));
        jScrollPane5.setViewportView(jTable1);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 410, 300));

        jTabbedPane1.addTab("Objectivos Financeiros", jPanel1);

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

    private void btnAplicarValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAplicarValorActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void taDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taDescricaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarValor;
    private javax.swing.JComboBox<String> cbFonte;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbListaObjectivos;
    private javax.swing.JLabel lbObjectivo;
    private javax.swing.JLabel lbPrioridadeV;
    private javax.swing.JLabel lbValorDisponível;
    private javax.swing.JTextField taDescricao;
    // End of variables declaration//GEN-END:variables
}
