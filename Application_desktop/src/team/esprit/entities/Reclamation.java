package team.esprit.entities;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Reclamation {

    private int _id;
    private String _email;
    private String _nomUtilisateur;
    private String _type;
    private boolean _vue;
    private String _message;

    public boolean isVue() {
        return _vue;
    }

    public void setVue(boolean _etat) {
        this._vue = _etat;
    }

    public void setType(String _type) {
        this._type = _type;
    }

    public String getType() {
        return _type;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getId() {
        return _id;
    }

    public void setNomUtilisateur(String _nomUtilisateur) {
        this._nomUtilisateur = _nomUtilisateur;
    }

    public String getNomUtilisateur() {
        return _nomUtilisateur;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getEmail() {
        return _email;
    }

    public void setMessage(String _message) {
        this._message = _message;
    }

    public String getMessage() {
        return _message;
    }

    public boolean repondreReclamation(String destinataire, String msg) {
        final String username = "covoiturage.1314.3a8@gmail.com";
        final String password = "admincovoiturage";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("covoiturage.1314.3a8@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
            message.setSubject("COVOITURAGE - Repondre réclamation");
            message.setText(msg);

            Transport.send(message);

            return true;

        } catch (MessagingException e) {
            return false;
        }
    }
}