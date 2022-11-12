/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *Classe modelo para definir uma despesa
 * @author Massingue
 */
public class Despesa {
    private int id;
    private String tipoDespesa;
    private double custo;
    private String categoria;
    private int utilizador_id;
    private String prioridade;

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public String getTipoRendimento() {
        return tipoDespesa;
    }

    public void setTipoRendimento(String tipoRendimento) {
        this.tipoDespesa = tipoRendimento;
    }

    @Override
    public String toString() {
        return categoria ;}

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getUtilizador_id() {
        return utilizador_id;
    }

    public void setUtilizador_id(int utilizador_id) {
        this.utilizador_id = utilizador_id;
    }
        
}
