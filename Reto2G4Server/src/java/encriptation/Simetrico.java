package encriptation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.BadPaddingException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Clase para realizar operaciones de encriptación y desencriptación simétrica
 * utilizando AES en modo CBC. Los datos confidenciales se almacenan en un
 * archivo cifrado.
 *
 * @author David
 */
public class Simetrico {

    private static byte[] salt = "esta es la salt!".getBytes();

    private static String rutaFichero = System.getProperty("user.home") + File.separator + "Documents\\MarketMaker\\credenciales.dat";

    /**
     * Desencripta el texto almacenado en el archivo cifrado utilizando la clave
     * proporcionada.
     *
     * @param clave Clave para desencriptar el texto.
     * @return Texto desencriptado.
     */
    public static String descifrarTexto(String clave) {
        String ret = null;

        //Busca el fichero .dat en el fichero de configuracion en documentos con una ruta relativa
        byte[] fileContent = fileReader(rutaFichero);
        KeySpec keySpec = null;
        SecretKeyFactory secretKeyFactory = null;
        try {
            // Creamos un SecretKey usando la clave + salt
            keySpec = new PBEKeySpec(clave.toCharArray(), salt, 65536, 128); // AES-128
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] key = secretKeyFactory.generateSecret(keySpec).getEncoded();
            SecretKey privateKey = new SecretKeySpec(key, 0, key.length, "AES");

            // Desciframos lo que ponga en el fichero
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivParam = new IvParameterSpec(Arrays.copyOfRange(fileContent, 0, 16)); // La IV est� aqu�
            cipher.init(Cipher.DECRYPT_MODE, privateKey, ivParam);
            byte[] decodedMessage = cipher.doFinal(Arrays.copyOfRange(fileContent, 16, fileContent.length));
            ret = new String(decodedMessage);

        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * Lee el contenido de un archivo y lo devuelve como un array de bytes.
     *
     * @param path Ruta del archivo.
     * @return Contenido del archivo como un array de bytes.
     */
    private static byte[] fileReader(String path) {
        byte ret[] = null;
        File file = new File(path);
        try {
            ret = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

}
