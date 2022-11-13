package view.inicio;

import Dao.TabelasSQL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.Main;

/**
 *Classe que define a tela inicial do sistema
 * @author Grácio Macuácua
 */
public final class PainelInicial extends javax.swing.JPanel {

    /**
     * Creates new form PainelInicial
     */
    public PainelInicial() {
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

        colorPanel1 = new view.geral.ColorPanel();
        lblExit = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        lblIcone = new javax.swing.JLabel();
        loadingLabel = new javax.swing.JLabel();

        colorPanel1.setkEndColor(new java.awt.Color(0, 102, 255));
        colorPanel1.setkStartColor(new java.awt.Color(0, 102, 255));

        lblExit.setBackground(new java.awt.Color(153, 153, 153));
        lblExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblExit.setForeground(new java.awt.Color(153, 153, 153));
        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fechar.png"))); // NOI18N
        lblExit.setToolTipText("Fechar");
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });

        lblMinimizar.setBackground(new java.awt.Color(153, 153, 153));
        lblMinimizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMinimizar.setForeground(new java.awt.Color(153, 153, 153));
        lblMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/minimizar.png"))); // NOI18N
        lblMinimizar.setToolTipText("Minimizar");
        lblMinimizar.setIconTextGap(0);
        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
        });

        lblIcone.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblIcone.setForeground(new java.awt.Color(255, 255, 255));
        lblIcone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcone.setText("<html>AGENDA<br>FINANCEIRA DIGITAL<html>");

        loadingLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        loadingLabel.setText("A carregar...");

        javax.swing.GroupLayout colorPanel1Layout = new javax.swing.GroupLayout(colorPanel1);
        colorPanel1.setLayout(colorPanel1Layout);
        colorPanel1Layout.setHorizontalGroup(
            colorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorPanel1Layout.createSequentialGroup()
                .addGroup(colorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(colorPanel1Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(lblIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(colorPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(loadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(307, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colorPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblExit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        colorPanel1Layout.setVerticalGroup(
            colorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colorPanel1Layout.createSequentialGroup()
                .addGroup(colorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(105, 105, 105)
                .addComponent(lblIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(loadingLabel)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(colorPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(colorPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblExitMouseClicked

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        Main.main.setState(Main.ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMouseClicked
    
    /**
     *Inicia algumas ações necessárias para a inicialização do sistema,
     * mas gera também um efeito de espera antes da entrada
     */
    public void iniciarContagem() {
        try{
            
            for(int i= 0; i<= 100; i++){
                Thread.sleep(100);
                
                if(i==10){
                  loadingLabel.setText("Habilitando módulos...");
                }else if(i==20){
                  loadingLabel.setText("Carregando módulos...");
                  i = i*2;
                }else if(i == 40){
                  Thread.sleep(300);
                  loadingLabel.setText("Módulos carregados...");
                }else if(i == 45){
                  Thread.sleep(500);
                  loadingLabel.setText("Verificando serviços...");
                }else if(i==50){
                  loadingLabel.setText("Conectando ao servidor...");
                  TabelasSQL.criarBaseDeDados();
                }else if(i==70){
                  loadingLabel.setText("Conexão estabelecida...");
                }else if(i==80){
                  loadingLabel.setText("Iniciando a aplicação...");
                }else if(i == 90)
                  loadingLabel.setText("Aguarde");
                
            }
            //Atraso antes de realizar a troca das telas
            Thread.sleep(2000);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.geral.ColorPanel colorPanel1;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblIcone;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel loadingLabel;
    // End of variables declaration//GEN-END:variables
}
