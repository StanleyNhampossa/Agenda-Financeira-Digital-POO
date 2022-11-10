package model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author berna
 */
public class SimuladorEmprestimos {
//Declaração de variáveis
    public double taxaDeJuros, capital, juros, divida,valorParcela;
    private int nParcelas, id;
    private String titulo;

    public SimuladorEmprestimos() {
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }
 
    
    public String getTitulo() {
        return titulo;
    }

    public SimuladorEmprestimos(double taxaDeJuros, double capital, int nParcelas) {
        this.taxaDeJuros = taxaDeJuros;
        this.capital = capital;
        this.nParcelas = nParcelas;

    }

    

    public double getTaxaDeJuros() {
        return taxaDeJuros;
    }

    public double getCapital() {
        return capital;
    }

    public double getJuros() {
        return juros;
    }

    public double getDivida() {
        return divida;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

  
    public int getnParcelas() {
        return nParcelas;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return titulo;
    }

    public void simularEmprestimo() {
        
        this.juros = ((this.capital / 100) * this.taxaDeJuros) * this.nParcelas;
        this.divida = this.capital + this.juros;
        this.valorParcela=divida/nParcelas;
        //Notificação de simulação bem sucedida.
        JOptionPane.showMessageDialog(null, "Processado com sucesso");

    }

}
