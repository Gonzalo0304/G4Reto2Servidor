package encriptation;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * Clase para desencriptar contraseñas utilizando cifrado asimétrico (RSA).
 * Requiere una clave privada almacenada en un archivo. La clave privada debe
 * estar en formato DER.
 *
 * @author David
 */
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;

public class Asimetrico {

    /**
     * Desencripta una contraseña cifrada utilizando la clave privada.
     *
     * @param encryptedPass Contraseña cifrada en formato hexadecimal.
     * @return Contraseña desencriptada.
     */
    public static String desencriptar(String pass) {

        String passDesencriptada = null;

        try {
            // Cargar clave privada desde un archivo DER
            byte[] privateKeyBytes;
            // Load Public Key
            FileInputStream fis = new FileInputStream(System.getProperty("user.home") + File.separator + "Documents\\MarketMaker\\privateKey.der");
            privateKeyBytes = new byte[fis.available()];
            fis.read(privateKeyBytes);

            // Crear una instancia de la factory de claves y generar la clave privada
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

            // Convertir la contraseña cifrada de formato hexadecimal a bytes
            byte[] encryptedData = DatatypeConverter.parseHexBinary(pass);

            // Inicializar el cifrado y desencriptar los datos
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedData = cipher.doFinal(encryptedData);

            // Convertir los datos desencriptados a una cadena
            passDesencriptada = new String(decryptedData);

        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {

        }
        return passDesencriptada;

    }
}
