
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author RayzerCoder
 */
public class Message {

    private int id;
    private int id_expediteur;
    private int id_destinataire;
    private String objet;
    private String contenu;
    private String date_envoie;
    private int lu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_expediteur() {
        return id_expediteur;
    }

    public void setId_expediteur(int id_expediteur) {
        this.id_expediteur = id_expediteur;
    }

    public int getId_destinataire() {
        return id_destinataire;
    }

    public void setId_destinataire(int id_destinataire) {
        this.id_destinataire = id_destinataire;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getDate_envoie() {
        return date_envoie;
    }

    public void setDate_envoie(String date_envoie) {
        this.date_envoie = date_envoie;
    }

    public int getLu() {
        return lu;
    }

    public void setLu(int lu) {
        this.lu = lu;
    }

}
