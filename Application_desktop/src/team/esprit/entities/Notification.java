package team.esprit.entities;

import java.sql.Time;

public class Notification {

    private int _id;
    private Covoitureur _expediteur;
    private Covoitureur _destinataire;
    private Time _dateCreation;
    private String _contenu;
    private int _type;
    private boolean _lu;

    //0 : annulé par le conducteur
    //1 : confirmé par le conducteur
    //2 : en tant que passager j'ai annulé ma réservation
    //3 : Le covoiturage a été supprimé
    //4 : en tant que passager j'ai réservé une place donc tji demande lel conducteur
    //5 : Le conducteur a modifié le covoiturage
    public boolean isLu() {
        return _lu;
    }

    public void setLu(boolean _lu) {
        this._lu = _lu;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public void setExpediteur(Covoitureur _expediteur) {
        this._expediteur = _expediteur;
    }

    public void setDestinataire(Covoitureur _destinataire) {
        this._destinataire = _destinataire;
    }

    public void setDateCreation(Time _dateCreation) {
        this._dateCreation = _dateCreation;
    }

    public void setContenu(String _contenu) {
        this._contenu = _contenu;
    }

    public void setType(int _type) {
        this._type = _type;
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

    public Time getDateCreation() {
        return _dateCreation;
    }

    public String getContenu() {
        return _contenu;
    }

    public int getType() {
        return _type;
    }

    @Override
    public String toString() {
        return "Notification{" + "_id=" + _id + ", _expediteur=" + _expediteur + ", _destinataire=" + _destinataire + ", _dateCreation=" + _dateCreation + ", _contenu=" + _contenu + ", _type=" + _type + '}';
    }
}