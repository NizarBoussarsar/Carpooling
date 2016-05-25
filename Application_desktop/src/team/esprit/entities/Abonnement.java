
package team.esprit.entities;


public class Abonnement {
    private int _id;
    private Covoitureur _covoitureur;
    private Ville _villeDepart;
    private Ville _villeArrivee;
    private boolean _etat;

    public int getId() {
        return _id;
    }

    @Override
    public String toString() {
        return "Abonnement{" + "_id=" + _id + ", _covoitureur=" + _covoitureur + ", _villeDepart=" + _villeDepart + ", _villeArrivee=" + _villeArrivee + ", _etat=" + _etat + '}';
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public void setCovoitureur(Covoitureur _covoitureur) {
        this._covoitureur = _covoitureur;
    }

    public void setVilleDepart(Ville _villeDepart) {
        this._villeDepart = _villeDepart;
    }

    public void setVilleArrivee(Ville _villeArrivee) {
        this._villeArrivee = _villeArrivee;
    }

    public void setEtat(boolean _etat) {
        this._etat = _etat;
    }

    public Covoitureur getCovoitureur() {
        return _covoitureur;
    }

    public Ville getVilleDepart() {
        return _villeDepart;
    }

    public Ville getVilleArrivee() {
        return _villeArrivee;
    }

    public boolean isEtat() {
        return _etat;
    }
    
}
