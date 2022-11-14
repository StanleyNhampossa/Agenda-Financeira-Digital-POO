package model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaSHA256 {

    /**
     * Transforma o conteúdo de uma string em uma string criptografada
     * @param texto o texto a ser criptografado
     */
    public static String criptografar(String texto) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(texto.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            texto = hexString.toString();
        } catch(NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch(UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }

        return texto;
    }

}