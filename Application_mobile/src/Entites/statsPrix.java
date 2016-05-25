package Entites;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author joe
 */
public class statsPrix {

    public int getPrice() {
        return price;
    }

    public String getDatep() {
        return datep;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDatep(String datep) {
        this.datep = datep;
    }
    public int price ;
    String datep;
    public String toString() {
        return "Mois" + this.datep + " dépenses" + this.price;
    }
}
