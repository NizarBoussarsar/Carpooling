package team.esprit.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import team.esprit.dao.AdministrateurDAO;
import team.esprit.entities.Administrateur;

public class MailSender {

    public boolean repondreReclamation(String destinataire, String msg) {
        AdministrateurDAO administrateurDAO = new AdministrateurDAO();
        Administrateur administrateur = administrateurDAO.afficherInformations();

        final String email = administrateur.getEmail();
        final String motPasse = "admincovoiturage";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, motPasse);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(administrateur.getEmail()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
            message.setSubject("Réponse à votre réclamation");
            message.setText(msg);

            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            return false;
        }
    }
    
    public boolean envoyerEmailConfimation(String destinataire, String msg) {
        AdministrateurDAO administrateurDAO = new AdministrateurDAO();
        Administrateur administrateur = administrateurDAO.afficherInformations();

        final String email = administrateur.getEmail();
        final String motPasse = "admincovoiturage";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, motPasse);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(administrateur.getEmail()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
            message.setSubject("Bienvenue sur www.covoiturage-tn.com");
            message.setText(msg);

            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            return false;
        }
    }
    
    public boolean envoyerEmailBienvenue(String destinataire, String msg) {
        AdministrateurDAO administrateurDAO = new AdministrateurDAO();
        Administrateur administrateur = administrateurDAO.afficherInformations();

        final String email = administrateur.getEmail();
        final String motPasse = "admincovoiturage";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, motPasse);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(administrateur.getEmail()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
            message.setSubject("Félicitation !");
            message.setText(msg);

            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            return false;
        }
    }
    
    public boolean envoyerEmailReinitialisationMotPasse(String destinataire, String msg) {
        AdministrateurDAO administrateurDAO = new AdministrateurDAO();
        Administrateur administrateur = administrateurDAO.afficherInformations();

        final String email = administrateur.getEmail();
        final String motPasse = "admincovoiturage";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, motPasse);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(administrateur.getEmail()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
            message.setSubject("Réinitialisation de mot de passe");
            message.setText(msg);

            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            return false;
        }
    }
}