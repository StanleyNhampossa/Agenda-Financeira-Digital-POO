package view.geral;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;

/**
 *
 * @author Grácio Macuácua
 */
public class Circulo extends JLabel {
    
    private Color corDoCirculo = getBackground();
    
    public Circulo() {
        super();
    }

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
