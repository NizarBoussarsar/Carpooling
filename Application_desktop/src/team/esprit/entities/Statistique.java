package team.esprit.entities;

import java.sql.Date;

public abstract class Statistique {
    
    private int _id;
    private String _nom;
    private String _type;
    private String _chemin; //Lien vers l'image ou est stocké
    private Date _dateCreation;
    
    public void setType(String _type) {
        this._type = _type;
    }

    public String getType() {
        return _type;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public void setChemin(String _chemin) {
        this._chemin = _chemin;
    }

    public void setDateCreation(Date _dateCreation) {
        this._dateCreation = _dateCreation;
    }

    public int getId() {
        return _id;
    }

    public String getNom() {
        return _nom;
    }

    public String getChemin() {
        return _chemin;
    }

    public Date getDateCreation() {
        return _dateCreation;
    }
    
}
