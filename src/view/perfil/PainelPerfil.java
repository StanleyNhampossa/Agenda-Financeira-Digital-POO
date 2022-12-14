package view.perfil;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import view.menu.MenuView;

/**
 *Classe que define a tela de perfil do utilizador
 * @author Grácio Macuácua
 */
public final class PainelPerfil extends javax.swing.JPanel {

    /**
     * Creates new form Perfil
     */
    public PainelPerfil() {
        initComponents();   
        inicializarCampos();
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
        circulo1 = new view.geral.Circulo();
        jScrollPane1 = new javax.swing.JScrollPane();
        colorPanel2 = new view.geral.ColorPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblProfissao = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setMaximumSize(new java.awt.Dimension(957, 593));
        setMinimumSize(new java.awt.Dimension(957, 593));
        setPreferredSize(new java.awt.Dimension(957, 593));

        colorPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        colorPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        colorPanel1.setOpaque(false);

        circulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        circulo1.setCorDoCirculo(new java.awt.Color(51, 153, 255));
        circulo1.setMaximumSize(new java.awt.Dimension(359, 359));
        circulo1.setMinimumSize(new java.awt.Dimension(359, 359));
        circulo1.setPreferredSize(new java.awt.Dimension(359, 359));

        javax.swing.GroupLayout colorPanel1Layout = new javax.swing.GroupLayout(colorPanel1);
        colorPanel1.setLayout(colorPanel1Layout);
        colorPanel1Layout.setHorizontalGroup(
            colorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorPanel1Layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(circulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        colorPanel1Layout.setVerticalGroup(
            colorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorPanel1Layout.createSequentialGroup()
                .addComponent(circulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(null);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(947, 220));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(947, 220));
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(947, 220));

        colorPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        colorPanel2.setkStartColor(new java.awt.Color(255, 255, 255));
        colorPanel2.setOpaque(false);
        colorPanel2.setPreferredSize(new java.awt.Dimension(406, 800));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/idade.png"))); // NOI18N
        jLabel8.setOpaque(true);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/email.png"))); // NOI18N
        jLabel9.setOpaque(true);

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblNome.setForeground(new java.awt.Color(153, 153, 153));
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNome.setText("NOME DO UTILIZADOR");
        lblNome.setMaximumSize(new java.awt.Dimension(513, 32));
        lblNome.setMinimumSize(new java.awt.Dimension(513, 32));
        lblNome.setPreferredSize(new java.awt.Dimension(513, 32));

        lblGenero.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(153, 153, 153));
        lblGenero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGenero.setText("SEXO DO UTILIZADOR");

        lblIdade.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblIdade.setForeground(new java.awt.Color(153, 153, 153));
        lblIdade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIdade.setText("IDADE DO UTILIZADOR");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(153, 153, 153));
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmail.setText("EMAIL DO UTILIZADOR");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/genero.png"))); // NOI18N
        jLabel6.setOpaque(true);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/usuario.png"))); // NOI18N
        jLabel7.setOpaque(true);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/profissao.png"))); // NOI18N
        jLabel10.setOpaque(true);

        lblProfissao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblProfissao.setForeground(new java.awt.Color(153, 153, 153));
        lblProfissao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProfissao.setText("PROFISSÃO DO UTILIZADOR");

        javax.swing.GroupLayout colorPanel2Layout = new javax.swing.GroupLayout(colorPanel2);
        colorPanel2.setLayout(colorPanel2Layout);
        colorPanel2Layout.setHorizontalGroup(
            colorPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(colorPanel2Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(colorPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(colorPanel2Layout.createSequentialGroup()
                        .addGroup(colorPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(colorPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(colorPanel2Layout.createSequentialGroup()
                        .addGroup(colorPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(colorPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(colorPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        colorPanel2Layout.setVerticalGroup(
            colorPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(colorPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(colorPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(colorPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(colorPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGenero))
                .addGap(24, 24, 24)
                .addGroup(colorPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(499, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(colorPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(colorPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(colorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
      
    /**
     * Realiza o preenchimento dos campos da tela com os dados do utilizador que estiver logado ao sistema
     */
    private void inicializarCampos() {
        File file = new File(MenuView.user.getFotoPerfil());
        BufferedImage bffImage = null;
        try {            
            bffImage = new BufferedImage(100, 200, BufferedImage.TYPE_INT_ARGB);
            bffImage = ImageIO.read(file);            
            circulo1.setIcon(new ImageIcon(arredondar(bffImage).getScaledInstance(350, 325, 1)));
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        lblNome.setText(MenuView.user.getNome().toUpperCase());
        lblEmail.setText(MenuView.user.getEmail().toUpperCase());
        lblGenero.setText(MenuView.user.getGenero().toUpperCase());
        int data1 = Calendar.getInstance().getTime().getYear();
        int data2 = MenuView.user.getDataNascimento().getYear();
        lblIdade.setText(Integer.toString(data1 - data2) + " ANOS");
        lblProfissao.setText(MenuView.user.getProfissao().toUpperCase());
    }
    
    /**
     * Faz o arredondamento de uma imagem qualquer
     * @param imagemInicial a imagem que deve ser arredondada
     * @return a imagem já arredondada
     */
    public static BufferedImage arredondar(BufferedImage imagemInicial) {
        int largura = imagemInicial.getWidth();
        int altura = imagemInicial.getHeight();
        double raio = largura / (double) altura > 0 ? altura : largura;
        BufferedImage imagemRedonda = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = imagemRedonda.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setClip(new Area(new Ellipse2D.Double(0, 0, raio, raio)));
        graphics.drawImage(imagemInicial, 0, 0, null);
        graphics.dispose();
        
        return imagemRedonda;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.WHITE);        
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.geral.Circulo circulo1;
    private view.geral.ColorPanel colorPanel1;
    private view.geral.ColorPanel colorPanel2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblProfissao;
    // End of variables declaration//GEN-END:variables
}
