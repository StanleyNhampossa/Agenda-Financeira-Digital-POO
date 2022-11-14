/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.despesas;

import Banco.Conectar;
import Dao.DespesaDao;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import model.Despesa;
import model.Rendimento;
import net.proteanit.sql.DbUtils;
import org.apache.commons.lang3.StringUtils;
import view.Main;
import view.declaracaoderendimentos.PainelDeclaracaoRendimentos;
import view.geral.Notificacao;
import view.menu.MenuView;

/**
 *
 * @author Massingue
 */
public class PainelDespesas extends javax.swing.JPanel {

    /**
     * Creates new form Despeza
     */
    public PainelDespesas() {
        initComponents();
        preencherTabela();
        inserirValores();
       
    }

    public void preencherTabela() {
        List<Despesa> lista = DespesaDao.listar(MenuView.user.getId(), "");
        DefaultTableModel modeloTabela = (DefaultTableModel) tbDespesa.getModel();
        modeloTabela.setRowCount(0);
        lista.forEach((p) -> {
            modeloTabela.addRow(new Object[]{p.getId(), p.getTipoDespesa(), p.getCusto(), p.getCategoria(), p.getPrioridade()});
            if (p.getTipoDespesa().equalsIgnoreCase("Fixa")) {
                grafico1.totalFixas += p.getCusto();
            } else {
                grafico1.totalVariaveis += p.getCusto();
            }
            painelGrafico.removeAll();
            painelGrafico.repaint();
            painelGrafico.revalidate();
            painelGrafico.add(grafico1);
        });
    }

    public void pesquisar() {
        List<Despesa> lista = DespesaDao.listar(MenuView.user.getId(), txtPesquisaDespesa.getText());
        DefaultTableModel modeloTabela = (DefaultTableModel) tbDespesa.getModel();
        modeloTabela.setRowCount(0);
        lista.forEach((p) -> {
            modeloTabela.addRow(new Object[]{p.getId(), p.getTipoDespesa(), p.getCusto(), p.getCategoria()});
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbTipoDespesa = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        spCusto = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDespesa = new javax.swing.JTable();
        txtPesquisaDespesa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        graficoCircularDespesa = new javax.swing.JPanel();
        lblDespesaTotal = new javax.swing.JLabel();
        lblDespesaFixa = new javax.swing.JLabel();
        lblDespesaVariavel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbPrioridade = new javax.swing.JComboBox<>();
        painelGrafico = new javax.swing.JPanel();
        grafico1 = new view.despesas.Grafico();
        btnSalvarDespesa = new javax.swing.JButton();
        btnActualizarDespesa = new javax.swing.JButton();
        btnExcluirDespesa = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(950, 594));
        setMinimumSize(new java.awt.Dimension(950, 594));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(950, 594));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Tipo");

        cbTipoDespesa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbTipoDespesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fixa", "Variavel" }));
        cbTipoDespesa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbTipoDespesaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbTipoDespesaFocusLost(evt);
            }
        });
        cbTipoDespesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbTipoDespesaKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Custo");

        spCusto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spCusto.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 200));
        spCusto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                spCustoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                spCustoFocusLost(evt);
            }
        });
        spCusto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spCustoKeyPressed(evt);
            }
        });

        tbDespesa.getTableHeader().setBackground(Color.WHITE);
        tbDespesa.getTableHeader().setForeground(new Color(104,104,104));
        tbDespesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tipo", "Custo", "Categoria", "Prioridade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDespesa.setOpaque(false);
        tbDespesa.setRowHeight(30);
        tbDespesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDespesaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDespesa);
        tbDespesa.setRowHeight(30);
        if (tbDespesa.getColumnModel().getColumnCount() > 0) {
            tbDespesa.getColumnModel().getColumn(0).setResizable(false);
            tbDespesa.getColumnModel().getColumn(1).setResizable(false);
            tbDespesa.getColumnModel().getColumn(2).setResizable(false);
            tbDespesa.getColumnModel().getColumn(3).setResizable(false);
            tbDespesa.getColumnModel().getColumn(4).setResizable(false);
        }

        txtPesquisaDespesa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPesquisaDespesa.setText("Pesquisar despesas");
        txtPesquisaDespesa.setToolTipText("Pesquisar");
        txtPesquisaDespesa.setBorder(null);
        txtPesquisaDespesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtPesquisaDespesa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPesquisaDespesaFocusLost(evt);
            }
        });
        txtPesquisaDespesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisaDespesaMouseClicked(evt);
            }
        });
        txtPesquisaDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaDespesaActionPerformed(evt);
            }
        });
        txtPesquisaDespesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaDespesaKeyReleased(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/lupa.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Total:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Despesa Fixa");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Despesa Variável");

        graficoCircularDespesa.setOpaque(false);

        javax.swing.GroupLayout graficoCircularDespesaLayout = new javax.swing.GroupLayout(graficoCircularDespesa);
        graficoCircularDespesa.setLayout(graficoCircularDespesaLayout);
        graficoCircularDespesaLayout.setHorizontalGroup(
            graficoCircularDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        graficoCircularDespesaLayout.setVerticalGroup(
            graficoCircularDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblDespesaTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDespesaTotal.setForeground(new java.awt.Color(102, 102, 102));
        lblDespesaTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDespesaTotal.setText("0.0");

        lblDespesaFixa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDespesaFixa.setForeground(new java.awt.Color(102, 102, 102));
        lblDespesaFixa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDespesaFixa.setText("0.0");

        lblDespesaVariavel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDespesaVariavel.setForeground(new java.awt.Color(102, 102, 102));
        lblDespesaVariavel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDespesaVariavel.setText("0.0");

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(1, 3, 100, 0));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Categoria");

        txtCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCategoria.setForeground(new java.awt.Color(51, 51, 51));
        txtCategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCategoriaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCategoriaFocusLost(evt);
            }
        });
        txtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCategoriaKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Prioridade");

        cbPrioridade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbPrioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Emergencia", "Muito importante", "Importante ", "Lazer", "Opcional" }));
        cbPrioridade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbPrioridadeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbPrioridadeFocusLost(evt);
            }
        });
        cbPrioridade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbPrioridadeKeyPressed(evt);
            }
        });

        painelGrafico.setOpaque(false);
        painelGrafico.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout grafico1Layout = new javax.swing.GroupLayout(grafico1);
        grafico1.setLayout(grafico1Layout);
        grafico1Layout.setHorizontalGroup(
            grafico1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        grafico1Layout.setVerticalGroup(
            grafico1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        painelGrafico.add(grafico1, "card2");

        btnSalvarDespesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/adicionar-botao.png"))); // NOI18N
        btnSalvarDespesa.setContentAreaFilled(false);
        btnSalvarDespesa.setMaximumSize(new java.awt.Dimension(30, 40));
        btnSalvarDespesa.setPreferredSize(new java.awt.Dimension(30, 40));
        btnSalvarDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDespesaActionPerformed(evt);
            }
        });
        btnSalvarDespesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalvarDespesaKeyPressed(evt);
            }
        });

        btnActualizarDespesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/atualizar-pares-de-setas-em-circulo.png"))); // NOI18N
        btnActualizarDespesa.setContentAreaFilled(false);
        btnActualizarDespesa.setMaximumSize(new java.awt.Dimension(30, 40));
        btnActualizarDespesa.setPreferredSize(new java.awt.Dimension(30, 40));
        btnActualizarDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDespesaActionPerformed(evt);
            }
        });

        btnExcluirDespesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/excluir.png"))); // NOI18N
        btnExcluirDespesa.setContentAreaFilled(false);
        btnExcluirDespesa.setMaximumSize(new java.awt.Dimension(30, 40));
        btnExcluirDespesa.setPreferredSize(new java.awt.Dimension(30, 40));
        btnExcluirDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirDespesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPesquisaDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblDespesaFixa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDespesaVariavel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDespesaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21))
                                    .addComponent(painelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTipoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(spCusto)
                                        .addGap(56, 56, 56)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(cbPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(graficoCircularDespesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvarDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(btnActualizarDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(btnExcluirDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel12)))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPesquisaDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDespesaVariavel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDespesaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDespesaFixa)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(graficoCircularDespesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvarDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluirDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void despesaOptimizada() {
        /*
        metdodo serve para nao perimitir o ususrio gastar mais que o seu rendimento
         */
        PainelDeclaracaoRendimentos rendiments = new PainelDeclaracaoRendimentos();
        if (Double.parseDouble(rendiments.lblRendimentoTotal.toString()) < Double.parseDouble(lblDespesaVariavel.toString())) {
            JOptionPane.showMessageDialog(null, "insere despesa infereior ");

        }

    }
    private void btnSalvarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDespesaActionPerformed
      
            if (Double.parseDouble(spCusto.getValue().toString()) != 0.0
                    && (!txtCategoria.getText().isBlank() && !cbTipoDespesa.getSelectedItem().equals("") && !cbPrioridade.getSelectedItem().equals(""))) {
                Despesa p = new Despesa();
                p.setTipoDespesa(cbTipoDespesa.getSelectedItem().toString());
                p.setCusto(Double.parseDouble(spCusto.getValue().toString()));
                p.setCategoria(txtCategoria.getText());
                p.setUtilizador_id(MenuView.user.getId());
                p.setPrioridade(cbPrioridade.getSelectedItem().toString());
                if (DespesaDao.cadastrar(p)) {
                    Notificacao.mostrarDialogoDeOpcaoSingular(Main.main, "Despesa adicionada com sucesso!", Notificacao.ICONE_SUCESSO);
                    limparCampos();
                    preencherTabela();
                    inserirValores();
                } else {
                    Notificacao.mostrarDialogoDeOpcaoSingular(Main.main, "A operação falhou!\nOcorreu um erro ao adicionar a despesa.", Notificacao.ICONE_ERRO);
                }
            } else
                Notificacao.mostrarDialogoDeOpcaoSingular(Main.main, "Preencha todos os campos para prosseguir!", Notificacao.ICONE_INFORMACAO);
    }//GEN-LAST:event_btnSalvarDespesaActionPerformed
    

    private void btnActualizarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDespesaActionPerformed
        Despesa p = new Despesa();
        p.setId(Integer.parseInt(tbDespesa.getValueAt(0, 0).toString()));
        p.setTipoDespesa(cbTipoDespesa.getSelectedItem().toString());
        p.setCusto(Double.parseDouble(spCusto.getValue().toString()));
        p.setCategoria(txtCategoria.getText());
        p.setPrioridade(String.valueOf(cbPrioridade.getSelectedItem()));
        p.setUtilizador_id(MenuView.user.getId());
        if (DespesaDao.actualizar(p)) {
            limparCampos();
            Notificacao.mostrarDialogoDeOpcaoSingular(Main.main, "Actualização efectuada com sucesso!", Notificacao.ICONE_SUCESSO);
        } else {
            Notificacao.mostrarDialogoDeOpcaoSingular(Main.main, "A actualização falhou!\nOcorreu um erro ao actualizar a despesa.", Notificacao.ICONE_ERRO);
        }
        preencherTabela();
        inserirValores();
    }//GEN-LAST:event_btnActualizarDespesaActionPerformed

    private void btnExcluirDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirDespesaActionPerformed
        int linha = tbDespesa.getSelectedRow();
        if (linha >= 0) {
            Despesa p = new Despesa();
            p.setId(Integer.parseInt(tbDespesa.getValueAt(linha, 0).toString()));
            if (DespesaDao.excluir(p)) {
                limparCampos();
                preencherTabela();
                inserirValores();
                Notificacao.mostrarDialogoDeOpcaoSingular(Main.main, "Despesa excluída com sucesso!!", Notificacao.ICONE_SUCESSO);
            } else {
                Notificacao.mostrarDialogoDeOpcaoSingular(Main.main, "A exclusão falhou!\nOcorreu um erro ao excluir a despesa.", Notificacao.ICONE_ERRO);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }
    }//GEN-LAST:event_btnExcluirDespesaActionPerformed

    private void inserirValores() {
        Double fixaDespesa = 0.0;
        Double variavelDespesa = 0.0;
        Double somaDespesa = 0.0;

        for (int i = 0; i < tbDespesa.getRowCount(); i++) {
            if (tbDespesa.getValueAt(i, 2).toString().equalsIgnoreCase("Fixa")) {
                fixaDespesa += Double.parseDouble(tbDespesa.getValueAt(i, 2).toString());
            } else {
                variavelDespesa += Double.parseDouble(tbDespesa.getValueAt(i, 2).toString());
            };
        }
        somaDespesa = variavelDespesa + fixaDespesa;
        lblDespesaFixa.setText(fixaDespesa.toString());
        lblDespesaVariavel.setText(variavelDespesa.toString());
        lblDespesaTotal.setText(somaDespesa.toString());
    }

    private void limparCampos() {
        txtCategoria.setText("");
        spCusto.setValue(0);
        txtPesquisaDespesa.setText("Pesquisar despesas");
    }
    private void txtPesquisaDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaDespesaActionPerformed
        pesquisar();
    }//GEN-LAST:event_txtPesquisaDespesaActionPerformed

    private void txtPesquisaDespesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaDespesaKeyReleased
        pesquisar();
    }//GEN-LAST:event_txtPesquisaDespesaKeyReleased

    private void txtPesquisaDespesaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPesquisaDespesaFocusLost
        if (txtPesquisaDespesa.getText().equals("Pesquisar despesas")) {
            txtPesquisaDespesa.setText("");
            txtPesquisaDespesa.setForeground(new Color(152, 153, 153));
        }
    }//GEN-LAST:event_txtPesquisaDespesaFocusLost

    private void cbTipoDespesaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbTipoDespesaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            spCusto.requestFocus();
    }//GEN-LAST:event_cbTipoDespesaKeyPressed

    private void spCustoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spCustoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            txtCategoria.requestFocus();
    }//GEN-LAST:event_spCustoKeyPressed

    private void txtCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            cbPrioridade.requestFocus();
    }//GEN-LAST:event_txtCategoriaKeyPressed

    private void txtPesquisaDespesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisaDespesaMouseClicked
        if (txtPesquisaDespesa.getText().equalsIgnoreCase("Pesquisar despesas"))
            txtPesquisaDespesa.setText("");
        else if (evt.getClickCount() == 2) {
            txtPesquisaDespesa.setText("");
            preencherTabela();
        }
    }//GEN-LAST:event_txtPesquisaDespesaMouseClicked

    private void tbDespesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDespesaMouseClicked
        if (tbDespesa.getSelectedRow() != -1) {
            cbTipoDespesa.setSelectedItem(tbDespesa.getValueAt(tbDespesa.getSelectedRow(), 1));
            spCusto.setValue(tbDespesa.getValueAt(tbDespesa.getSelectedRow(), 2));
            txtCategoria.setText(tbDespesa.getValueAt(tbDespesa.getSelectedRow(), 3).toString());
            cbPrioridade.setSelectedItem(tbDespesa.getValueAt(tbDespesa.getSelectedRow(), 4));
        }
    }//GEN-LAST:event_tbDespesaMouseClicked

    private void btnSalvarDespesaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalvarDespesaKeyPressed

    }//GEN-LAST:event_btnSalvarDespesaKeyPressed

    private void txtCategoriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCategoriaFocusLost
        if (txtCategoria.getText().toString().isEmpty())
            txtCategoria.setBorder(new LineBorder(Color.RED));
    }//GEN-LAST:event_txtCategoriaFocusLost

    private void cbPrioridadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbPrioridadeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSalvarDespesa.requestFocus();
        }

    }//GEN-LAST:event_cbPrioridadeKeyPressed

    private void spCustoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spCustoFocusLost
        if (spCusto.getValue().toString().isEmpty())
            spCusto.setBorder(new LineBorder(Color.RED));
    }//GEN-LAST:event_spCustoFocusLost

    private void txtCategoriaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCategoriaFocusGained
        txtCategoria.setBorder(new LineBorder(Color.white));
    }//GEN-LAST:event_txtCategoriaFocusGained

    private void spCustoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spCustoFocusGained
        spCusto.setBorder(new LineBorder(Color.white));
    }//GEN-LAST:event_spCustoFocusGained

    private void cbTipoDespesaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbTipoDespesaFocusLost
        if (cbTipoDespesa.getSelectedItem().toString().isEmpty())
            cbTipoDespesa.setBorder(new LineBorder(Color.RED));
    }//GEN-LAST:event_cbTipoDespesaFocusLost

    private void cbTipoDespesaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbTipoDespesaFocusGained
        cbTipoDespesa.setBorder(new LineBorder(Color.white));
    }//GEN-LAST:event_cbTipoDespesaFocusGained

    private void cbPrioridadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbPrioridadeFocusLost
        if (cbPrioridade.getSelectedItem().toString().isEmpty())
            cbPrioridade.setBorder(new LineBorder(Color.RED));
    }//GEN-LAST:event_cbPrioridadeFocusLost

    private void cbPrioridadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbPrioridadeFocusGained
        cbPrioridade.setBorder(new LineBorder(Color.white));
    }//GEN-LAST:event_cbPrioridadeFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarDespesa;
    private javax.swing.JButton btnExcluirDespesa;
    private javax.swing.JButton btnSalvarDespesa;
    private javax.swing.JComboBox<String> cbPrioridade;
    private javax.swing.JComboBox<String> cbTipoDespesa;
    private view.despesas.Grafico grafico1;
    private javax.swing.JPanel graficoCircularDespesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDespesaFixa;
    private javax.swing.JLabel lblDespesaTotal;
    private javax.swing.JLabel lblDespesaVariavel;
    private javax.swing.JPanel painelGrafico;
    private javax.swing.JSpinner spCusto;
    private javax.swing.JTable tbDespesa;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtPesquisaDespesa;
    // End of variables declaration//GEN-END:variables
}
