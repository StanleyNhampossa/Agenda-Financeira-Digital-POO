/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Grácio Macuácua
 */
public class Model_Menu {

    /**
     * @return the icone
     */
    public String getIcone() {
        return icone;
    }

    /**
     * @param icone the icone to set
     */
    public void setIcone(String icone) {
        this.icone = icone;
    }

    public Model_Menu(String icone, String nome, MenuType type) {
        this.icone = icone;
        this.nome = nome;
        this.type = type;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the type
     */
    public MenuType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(MenuType type) {
        this.type = type;
    }
    
    private String icone;
    private String nome;
    private MenuType type;
    
    public Icon toIcon(){
        return new ImageIcon(getClass().getResource("/icones/" + icone + ".png"));
    }
    
    public static enum MenuType {
        TITLE, MENU, EMPTY
    }
}
