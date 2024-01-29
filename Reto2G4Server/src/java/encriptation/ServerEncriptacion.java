package encriptation;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bego
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

public class ServerEncriptacion {

    public static String desencriptar(String pass) {

        String passDesencriptada = null;

        try {
            byte[] privateKeyBytes;
            // Load Public Key
            FileInputStream fis = new FileInputStream("C:\\Users\\INFORMATICA\\Desktop\\2DAM\\keys\\privateKey.der");
            privateKeyBytes = new byte[fis.available()];
            fis.read(privateKeyBytes);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

            byte[] encryptedData = DatatypeConverter.parseHexBinary(pass);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedData = cipher.doFinal(encryptedData);

            passDesencriptada = new String(decryptedData);

        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {

        }
        return passDesencriptada;

    }
}
