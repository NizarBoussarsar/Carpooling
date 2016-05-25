/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entites.Covoitureur;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author RayzerCoder
 */
public class Midlet extends MIDlet {
    
    public static Display display;
    public static Covoitureur covoitureurConnecte;
    
    public void startApp() {
        display = Display.getDisplay(this);
//        display.setCurrent(new CovoitureurConnecteList("Test", List.IMPLICIT).lst); //Tra
//        display.setCurrent(new SaisieCovoiturage(this, null)); //hussein7
//        display.setCurrent(new FormContact().list); // wejd
//        display.setCurrent(new statistiquesForm(7)); //JOE stats
//        display.setCurrent(new notificationForm(1));
        display.setCurrent(new SplashScreen_D());
    }
    
    public static Display getDisplay() {
        return display;
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
        
    }
    
    public void callme(String number) {
        try {
            platformRequest("tel:" + number);
        } catch (ConnectionNotFoundException ex) {
            System.out.println("    no connection found ");
        }
    }
}
