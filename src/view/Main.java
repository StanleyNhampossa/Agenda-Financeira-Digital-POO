package view;

import com.k33ptoo.utils.ComponentMoverUtil;
import com.k33ptoo.utils.ComponentResizerUtil;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import view.entrada.PainelEntrada;

/**
 *
 * @author Grácio Macuácua, Bernabé Bila e Paulo Massingue
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        setUndecorated(true);
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        //redimensionarFrame(this);
        ComponentMoverUtil.moveFrame(this, false, this.getComponents());
    }
   
    /***
     * Faz o redimensionamento do frame segundo as necessidades do usuário
     * @param frame o frame que se deseja redimensionar
     */
    private void redimensionarFrame(JFrame frame) {
        SwingUtilities.invokeLater(() -> {

        //Para redimensionar o frame
        ComponentResizerUtil cr = new ComponentResizerUtil();
        frame.getRootPane().setBorder(new EmptyBorder(0, 0, 0, 0));
        cr.setSnapSize(new Dimension(5, 5));
        cr.setDragInsets(new Insets(5, 5, 5, 5));
       
        //always register frame to resize
        cr.registerComponent(frame); 

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

        painelControlador = new view.geral.ColorPanel();
        painelInicial = new view.inicio.PainelInicial();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1186, 621));

        painelControlador.setkEndColor(new java.awt.Color(255, 255, 255));
        painelControlador.setkStartColor(new java.awt.Color(255, 255, 255));
        painelControlador.setLayout(new java.awt.CardLayout());
        painelControlador.add(painelInicial, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelControlador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(painelControlador, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        main = new Main();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                main.setVisible(true);
            }
        });
        //main.painelInicial.iniciarContagem();
        exibirPainel(new PainelEntrada());
    }
    
    /**
     * Exibe o painel fornecido no container principal do frame
     * @param painel o painel a ser exibido
     */
    public static void exibirPainel(JPanel painel) {
        main.painelControlador.removeAll();
        main.painelControlador.repaint();
        main.painelControlador.revalidate();
        main.painelControlador.add(painel);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.geral.ColorPanel painelControlador;
    private view.inicio.PainelInicial painelInicial;
    // End of variables declaration//GEN-END:variables
    public static Main main;
}
