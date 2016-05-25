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
public class Covoitureur {

    private int id;
    private String id_facebook;
    private String email;
    private String mdp;
    private String nom_utilisateur;
    private String nom;
    private String prenom;
    private char sexe;
    private int fumeur;
    private String date_naissance;
    private String date_enregistrement;
    private int note;
    private int etat;
    private String avatar;
    private String skype;
    private String facebook;
    private String date_derniere_visite;
    private String cle_activation;
    private double _latitude;
    private double _longitude;
    private boolean _connecte;

    public double getLatitude() {
        return _latitude;
    }

    public double getLongitude() {
        return _longitude;
    }

    public boolean isConnecte() {
        return _connecte;
    }

    public void setLatitude(double _latitude) {
        this._latitude = _latitude;
    }

    public void setLongitude(double _longitude) {
        this._longitude = _longitude;
    }

    public void setConnecte(boolean _connecte) {
        this._connecte = _connecte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_facebook() {
        return id_facebook;
    }

    public void setId_facebook(String id_facebook) {
        this.id_facebook = id_facebook;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public int getFumeur() {
        return fumeur;
    }

    public void setFumeur(int fumeur) {
        this.fumeur = fumeur;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getDate_enregistrement() {
        return date_enregistrement;
    }

    public void setDate_enregistrement(String date_enregistrement) {
        this.date_enregistrement = date_enregistrement;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getDate_derniere_visite() {
        return date_derniere_visite;
    }

    public void setDate_derniere_visite(String date_derniere_visite) {
        this.date_derniere_visite = date_derniere_visite;
    }

    public String getCle_activation() {
        return cle_activation;
    }

    public void setCle_activation(String cle_activation) {
        this.cle_activation = cle_activation;
    }

    public String toString() {
        return "+++++++++++++++Objet Covoitureur : " + this.id + " " + this.nom_utilisateur;
    }

}
