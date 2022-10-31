/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Massingue
 */
public class Rendimento {
    private String tipoRendimento;
    private double rendimento;
    private String perido;
    private String fonteRendimento;

    public String getTipoRendimento() {
        return tipoRendimento;
    }

    public void setTipoRendimento(String tipoRendimento) {
        this.tipoRendimento = tipoRendimento;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public String getPerido() {
        return perido;
    }

    public void setPerido(String perido) {
        this.perido = perido;
    }

    public String getFonteRendimento() {
        return fonteRendimento;
    }

    public void setFonteRendimento(String fonteRendimento) {
        this.fonteRendimento = fonteRendimento;
    }
    
    
}
