package model;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Grácio Macuácua
 */

/**
 * Esta classe contém regras de formatação para campos de entrada de texto
 */
public final class Formatador extends PlainDocument{
    public enum TipoEntrada{
        NUMERO_INTEIRO, NUMERO_DECIMAL, TEXTO, EMAIL, SENHA, TEXTO_COM_NUMEROS;
    };
    
    private int qtdCaracteres;
    private TipoEntrada tipoEntrada;

    public Formatador(int qtdCaracteres, TipoEntrada tipoEntrada) {
        this.qtdCaracteres = qtdCaracteres;
        this.tipoEntrada = tipoEntrada;
    }

    @Override
    public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
        if(string == null || getLength() == qtdCaracteres){
            return;
        }
        int totalCaractere = getLength() + string.length(); 
        
        //FILTRA OS CARACTERES

        String regex = "";
        
        switch(tipoEntrada){
            case NUMERO_INTEIRO:    regex = "[^0-9]";break;
            case NUMERO_DECIMAL:    regex = "[^0-9.]";break;
            case TEXTO:             regex = "[^\\p{IsLatin} ]";break;
            case TEXTO_COM_NUMEROS: regex = "[^\\p{IsLatin} 0-9 -+/*<>!/]";break;
            case EMAIL:             regex = "[^0-9a-zA-Z@._-]";break;
            case SENHA:             regex = "[^0-9a-zA-Z?!#%$*&-@]";break;
        }
        
        //SUBSTITUICAO
        
        string = string.replaceAll(regex, "");
        
        if(totalCaractere <= qtdCaracteres){
            super.insertString(i, string, as); 
        }else {
            String nova = string.substring(0, qtdCaracteres);
            super.insertString(i, string, as); 
        }
    }
    
}
