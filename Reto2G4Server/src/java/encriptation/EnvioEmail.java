/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptation;

import static encriptation.CredentialDescifrator.descifrarTexto;
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
 * @author David
 */
public class EnvioEmail {

    public static String enviarEmail(String receptor) {
        final String ZOHO_HOST = "smtp.zoho.eu";
        final String TLS_PORT = "897";

        String descifrado = descifrarTexto("Clave");

        String correo = descifrado.substring(0, descifrado.indexOf("&&"));
        String password = descifrado.substring(descifrado.indexOf("&&") + 2, descifrado.length());

        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", ZOHO_HOST);
        props.setProperty("mail.smtp.port", TLS_PORT);
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtps.auth", "true");

        props.put("mail.smtps.quitwait", "false");

        Session session = Session.getInstance(props, null);

        String cadena = "";

        try {
            String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

            for (int x = 0; x < 8; x++) {
                int indiceAleatorio = numeroAleatorioEnRango(0, caracteres.length() - 1);
                char caracterAleatorio = caracteres.charAt(indiceAleatorio);
                cadena += caracterAleatorio;
            }

            final MimeMessage msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(correo));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receptor, false));
            msg.setSubject("Nueva Contraseña");
            msg.setText("Ésta es su nueva contraseña: \n" + cadena, "utf-8", "html");
            msg.setSentDate(new Date());

            Transport transport = session.getTransport("smtps");

            transport.connect(ZOHO_HOST, correo, password);
            transport.sendMessage(msg, msg.getAllRecipients());

        } catch (MessagingException e) {
            throw new RuntimeException(e);

        }
        return cadena;
    }

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

}
