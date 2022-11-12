package view.despesas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
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

        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
         //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset( );
        barDataset.setValue( "Despesa Fixa" , totalFixas);  
        barDataset.setValue( "Despesa Variavel" , totalVariaveis);   

        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Despesas", barDataset, false, true, false);//explain
        piechart.getTitle().setPaint(new Color(153,153,153));
        PiePlot piePlot =(PiePlot) piechart.getPlot();

        //changing pie chart blocks colors
        piePlot.setSectionPaint("Despesa Fixa", new Color(255,255,102));
        piePlot.setSectionPaint("Despesa Variavel", new Color(102,255,102));


        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        barChartPanel.setSize(getWidth(), getHeight());
        add(barChartPanel, BorderLayout.CENTER);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public double totalFixas;
    public double totalVariaveis;
}
