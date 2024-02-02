/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptation;

import static encriptation.Simetrico.descifrarTexto;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * Clase para enviar correos electrónicos utilizando JavaMail y Zoho Mail. La
 * contraseña necesaria para autenticar el correo electrónico se descifra. Se
 * utiliza cifrado simétrico para descifrar la contraseña.
 *
 * @author Inigo y David
 *
 * @author David
 */
public class EnvioEmail {

    /**
     * Envía un correo electrónico a la dirección especificada con el asunto y
     * el mensaje dados.
     *
     * @param receptor Dirección de correo electrónico del destinatario.
     * @param subject Asunto del correo electrónico.
     * @param message Cuerpo del correo electrónico.
     * @return Cadena vacía (puede modificarse según sea necesario).
     */
    public static String enviarEmail(String receptor, String subject, String message) {
        // Configuración para el servidor de correo Zoho Mail
        final String ZOHO_HOST = "smtp.zoho.eu";
        final String TLS_PORT = "897";

        // Descifrar la contraseña utilizando cifrado simétrico
        String descifrado = descifrarTexto("Clave");

        // Separar el correo y la contraseña de la cadena descifrada
        String correo = descifrado.substring(0, descifrado.indexOf("&&"));
        String password = descifrado.substring(descifrado.indexOf("&&") + 2, descifrado.length());

        // Configuración de las propiedades para la conexión SMTP
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", ZOHO_HOST);
        props.setProperty("mail.smtp.port", TLS_PORT);
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtps.auth", "true");

        props.put("mail.smtps.quitwait", "false");

        // Crear una sesión de correo con las propiedades configuradas
        Session session = Session.getInstance(props, null);

        String cadena = "";

        try {
            // Crear un mensaje MIME para el correo electrónico

            final MimeMessage msg = new MimeMessage(session);

            // Configurar el remitente, destinatario, asunto, cuerpo y fecha del mensaje
            msg.setFrom(new InternetAddress(correo));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receptor, false));
            msg.setSubject(subject);
            msg.setText(message, "utf-8", "html");
            msg.setSentDate(new Date());

            // Obtener un objeto Transport y conectar al servidor de correo
            Transport transport = session.getTransport("smtps");
            transport.connect(ZOHO_HOST, correo, password);

            // Enviar el mensaje
            transport.sendMessage(msg, msg.getAllRecipients());

        } catch (MessagingException e) {
            throw new RuntimeException(e);

        }
        return cadena;
    }

    /**
     * Genera una contraseña aleatoria.
     *
     * @return Contraseña aleatoria generada.
     */
    public static String generateRandomPassword() {
        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String cadena = "";

        // Generar una cadena aleatoria concatenando caracteres del conjunto definido
        for (int x = 0; x < 8; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, caracteres.length() - 1);
            char caracterAleatorio = caracteres.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }

    /**
     * Genera un número aleatorio en el rango especificado.
     *
     * @param minimo Valor mínimo del rango.
     * @param maximo Valor máximo del rango.
     * @return Número aleatorio generado.
     */
    private static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

}
