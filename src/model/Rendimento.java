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
    private int id;
    private String tipoRendimento;
    private double rendimento;
    private String periodo;
    private String fonteRendimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

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
        return periodo;
    }

    public void setPerido(String perido) {
        this.periodo = perido;
    }

    public String getFonteRendimento() {
        return fonteRendimento;
    }

    public void setFonteRendimento(String fonteRendimento) {
        this.fonteRendimento = fonteRendimento;
    }
    
    
}
