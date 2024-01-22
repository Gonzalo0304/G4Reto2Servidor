package encription;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bego
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

public class KeyGenerator {

    public static void main(String[] args) {
        try {
            // Especificamos el algoritmo de encriptación
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            // Especificamos el tamaño en bits de las claves
            keyPairGenerator.initialize(2048);
            // Se genera el par de claves
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // La clase KeyPair tiene dos atributos:
            // publicKey y privateKey
            // PublicKey y PrivateKey son interfaces implementadas por las
            // clases X509Key y PKCS8Key respectivamente
            // dichas clases (X509Key y PKCS8Key) contienen como atributos:
            //   private static final long serialVersionUID = -5359250853002055002L;
            //   informacion del algoritmo
            //   protected AlgorithmId algid;
            //   La representacion de la clave como BitArray
            //   private transient BitArray bitStringKey = null;
            //   La representacion de la clave como byte[]
            //   protected byte[] encodedKey;
            PublicKey publicKeyAndMore = keyPair.getPublic();
            byte[] publicKeyBytes = publicKeyAndMore.getEncoded();

            try (FileOutputStream publicKeyFile = new FileOutputStream("C:\\Users\\Daviz\\Desktop\\clave\\publicKey.der")) {
                publicKeyFile.write(publicKeyBytes);
            }

            PrivateKey privateKey = keyPair.getPrivate();
            byte[] privateKeyBytes = privateKey.getEncoded();
            try (FileOutputStream privateKeyFile = new FileOutputStream("C:\\Users\\Daviz\\Desktop\\clave\\privateKey.der")) {
                privateKeyFile.write(privateKeyBytes);
            }

            System.out.println("Ficheros de Clave Generados!");
        } catch (IOException | NoSuchAlgorithmException e) {
        }
    }
}
