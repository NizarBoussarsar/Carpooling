package team.esprit.entities;

import java.sql.Time;

public class Message {
    
    private int _id;
    private Covoitureur _expediteur;
    private Covoitureur _destinataire;
    private String _objet;
    private String _contenu;
    private Time _dateEnvoie;
    private boolean _lu;

    public void setId(int _id) {
        this._id = _id;
    }

    public void setExpediteur(Covoitureur _expediteur) {
        this._expediteur = _expediteur;
    }

    public void setDestinataire(Covoitureur _destinataire) {
        this._destinataire = _destinataire;
    }

    public void setObjet(String _objet) {
        this._objet = _objet;
    }

    public void setContenu(String _contenu) {
        this._contenu = _contenu;
    }

    public void setDateEnvoie(Time _dateEnvoie) {
        this._dateEnvoie = _dateEnvoie;
    }

    public void setLu(boolean _lu) {
        this._lu = _lu;
    }

    public int getId() {
        return _id;
    }

    public Covoitureur getExpediteur() {
        return _expediteur;
    }

    public Covoitureur getDestinataire() {
        return _destinataire;
    }

    public String getObjet() {
        return _objet;
    }

    public String getContenu() {
        return _contenu;
    }

    public Time getDateEnvoie() {
        return _dateEnvoie;
    }

    public boolean isLu() {
        return _lu;
    }

    @Override
    public String toString() {
        return "Message{" + "_id=" + _id + ", _expediteur=" + _expediteur + ", _destinataire=" + _destinataire + ", _objet=" + _objet + ", _contenu=" + _contenu + ", _dateEnvoie=" + _dateEnvoie + ", _lu=" + _lu + '}';
    }
}
