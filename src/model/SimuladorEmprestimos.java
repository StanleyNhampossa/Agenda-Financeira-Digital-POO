/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.JOptionPane;

/**
 *
 * @author berna
 */
public class SimuladorEmprestimos {

    private double taxaDeJuros, capital, juros, divida, parcelas[];
    private int nParcelas, id;
    private String titulo;

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

    public double[] getParcelas() {
        return parcelas;
    }

    public int getnParcelas() {
        return nParcelas;
    }

    public int getId() {
        return id;
    }

    public void simularEmprestimo() {
        //Declaração de variáveis internas do método.

        double capital = this.capital, divida, parcelas[] = null, taxaDeJuros = this.taxaDeJuros, juros;
        int nParcelas = this.nParcelas;

        juros = ((capital / 100) * taxaDeJuros) * nParcelas;
        divida = capital + juros;
        try {
            for (int i = 0; i < nParcelas - 1; i++) {

                parcelas[i] = divida / nParcelas;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        //Atribuindo os resultados processados aos atributos da classe.
        this.parcelas = parcelas;
        this.divida = divida;
        this.juros = juros;

        JOptionPane.showMessageDialog(null, "Processado com sucesso");

    }

}
