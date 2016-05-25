package Entites;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author joe
 */
public class statsVilles {

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getNombre() {
        return nombre;
    }
   public String ville;
   public int nombre;

    public String toString() {
        return "ville" + this.ville + " nombre visites" + this.nombre;
    }
}
