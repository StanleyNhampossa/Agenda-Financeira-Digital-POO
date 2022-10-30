package view.menu;

import model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.Main;
import view.PainelDeclaracaoRendimentos;
import view.PainelEmuladorDeEmprestimos;
import view.PainelObjectivosFinanceiros;
import view.TelaDespesa;
import view.entrada.PainelEntrada;
import view.perfil.Perfil;

/**
 *
 * @author Grácio Macuácua, Bernabé Bila e Paulo Massingue
 */
public class MenuOptions extends javax.swing.JPanel {

    /**
     * Creates new form Menu
     */
    public MenuOptions() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
        
        listMenu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (listMenu1.getSelectedIndex()) {
                    case 1:
                        MenuView.exibirPainel(new PainelDeclaracaoRendimentos());
                        break;
                    case 2:
                        MenuView.exibirPainel(new TelaDespesa());
                        break;
                    case 3:
                        MenuView.exibirPainel(new PainelObjectivosFinanceiros());
                        break;
                    case 7:
                        MenuView.exibirPainel(new PainelEmuladorDeEmprestimos());
                        break;
                    case 11: 
                        MenuView.exibirPainel(new Perfil());
                        break;
                    case 13:
                        Main.exibirPainel(new PainelEntrada());
                        break;
                    default:
                        break;
                }
            }
            
        });
    }
    
    /**
     * Faz a adição dos elementos que compõem o menu ao painel lateral
     */
    private void init(){
        listMenu1.addItem(new Model_Menu("", "Utilitários", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("rendimentos", "Rendimentos", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("despesas", "Despesas", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("informacoes", "Objectivos Financeiros", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("estatisticas", "Estatísticas", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        
        listMenu1.addItem(new Model_Menu("", "Ferramentas Financeiras", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("informacoes", "Emulador de Empréstimos", Model_Menu.MenuType.MENU));               
        listMenu1.addItem(new Model_Menu("informacoes", "Calculadora de Juros", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        
        listMenu1.addItem(new Model_Menu("", "Outros", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("perfil", "Meu Perfil", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("ajuda", "Ajuda", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("logout", "Terminar Sessão", Model_Menu.MenuType.MENU));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelLateral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listMenu1 = new view.menu.ListMenu<>();

        painelLateral.setOpaque(false);
        painelLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Aplicação");
        jLabel1.setToolTipText("");
        painelLateral.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 9, 198, 64));

        listMenu1.setOpaque(false);
        painelLateral.add(listMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 73, 230, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth()-20, 0, getWidth(), getHeight());
        super.paintChildren(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private view.menu.ListMenu<String> listMenu1;
    private javax.swing.JPanel painelLateral;
    // End of variables declaration//GEN-END:variables
}