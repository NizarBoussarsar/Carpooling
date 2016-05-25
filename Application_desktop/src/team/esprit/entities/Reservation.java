package team.esprit.entities;

import java.util.Date;

public class Reservation {

    private int _id;
    private Covoitureur _covoitureur;
    private Covoiturage _covoiturage;
    private Date _dateReservation;
    private boolean _etat;

    public int getId() {
        return _id;
    }

    public Covoitureur getCovoitureur() {
        return _covoitureur;
    }

    public Covoiturage getCovoiturage() {
        return _covoiturage;
    }

    public Date getDateReservation() {
        return _dateReservation;
    }

    public boolean getEtat() {
        return _etat;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public void setCovoitureur(Covoitureur _covoitureur) {
        this._covoitureur = _covoitureur;
    }

    public void setCovoiturage(Covoiturage _covoiturage) {
        this._covoiturage = _covoiturage;
    }

    public void setDateReservation(Date _dateReservation) {
        this._dateReservation = _dateReservation;
    }

    public void setEtat(boolean _etat) {
        this._etat = _etat;
    }

    public boolean isEtat() {
        return _etat;
    }

    @Override
    public String toString() {
        return "Reservation{" + "_id=" + _id + ", _covoitureur=" + _covoitureur + ", _covoiturage=" + _covoiturage + ", _dateReservation=" + _dateReservation + ", _etat=" + _etat + '}';
    }
}