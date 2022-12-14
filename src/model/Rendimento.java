/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *Classe modelo para definir um rendimento
 * @author Massingue
 */
public class Rendimento {
    private int id;
    public String tipoRendimento;
    private double rendimento;
    private String fonteRendimento;
    private int utilizador_id;    

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return  fonteRendimento;   
    }

    public void setId(int id) {
        this.id = id;
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
    
    public int getUtilizador_id() {
        return utilizador_id;
    }

    public void setUtilizador_id(int utilizador_id) {
        this.utilizador_id = utilizador_id;
    }

    
    
}
