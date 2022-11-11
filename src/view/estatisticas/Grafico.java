package view.estatisticas;

import java.awt.Color;
import java.awt.Graphics;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *Classe que faz o desenho do gráfico da tela de estatísticas
 * @author Grácio Macuácua
 */
public class Grafico extends javax.swing.JPanel {

    /**
     * Creates new form Grafico
     */
    public Grafico() {
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 155, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(100,"Emergência", "Dado 1");
        dataset.setValue(80,"Muito Importante", "Dado 2");
        dataset.setValue(60, "Importante", "Dado 3");
        dataset.setValue(40, "Lazer", "Dado 4"); 
        dataset.setValue(20, "Opcional", "Dado 5");                     

        //Criação do gráfico
        JFreeChart linechart = ChartFactory.createLineChart("Estatísticas de uso das finanças", "Classificação", "Percentagem",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        linechart.getTitle().setPaint(new Color(153,153,153));
        //create plot object
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
        // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);

        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204, 0, 51);
        lineRenderer.setSeriesPaint(0, lineChartColor);

        //Criação do painel para exibição do gráfico
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        lineChartPanel.setSize(getWidth(), getHeight());
        add(lineChartPanel);
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
