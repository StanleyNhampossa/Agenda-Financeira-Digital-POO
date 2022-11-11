package view.geral;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;

/**
 *Classe que define um círculo para a classe {@code PainelEntrada}
 * @author Grácio Macuácua
 */
public class Circulo extends JLabel {
    
    private Color corDoCirculo = getBackground();
    
    public Circulo() {
        super();
    }

    /**
     * Ajusta a cor de fundo para o círculo
     * @param corDoCirculo ou a opção {@code NADA} se a janela
     */
    public void setCorDoCirculo(Color corDoCirculo) {
        this.corDoCirculo = corDoCirculo;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(corDoCirculo);
        g2.fillOval(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
 
}
