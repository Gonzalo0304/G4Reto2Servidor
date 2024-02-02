/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package encriptation;

/**
 *
 * Clase que proporciona una función de hash utilizando el algoritmo MD5. *
 *
 * @author david
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    /**
     * Calcula el hash MD5 de una cadena de texto.
     *
     * @param text Cadena de texto para la cual se calculará el hash.
     * @return Cadena hexadecimal representando el hash MD5.
     */
    public static String hashText(String text) {
        try {
            // Obtener una instancia del algoritmo de hash MD5
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            // Calcular el hash de la cadena de texto
            byte[] hashBytes = md5.digest(text.getBytes());

            // Convert the byte array to a hexadecimal representation
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = String.format("%02X", b);
                hexStringBuilder.append(hex);
            }
            // Devolver la representación hexadecimal del hash
            return hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
