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
    public String tipoRendimento;
    private double rendimento;
    private String periodo;
    private String fonteRendimento;
    private int utilizador_fk;    

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

    public String getFonteRendimento() {
        return fonteRendimento;
    }

    public void setFonteRendimento(String fonteRendimento) {
        this.fonteRendimento = fonteRendimento;
    }
    
    public int getUtilizador_fk() {
        return utilizador_fk;
    }

    public void setUtilizador_fk(int utilizador_fk) {
        this.utilizador_fk = utilizador_fk;
    }

    
    
}
