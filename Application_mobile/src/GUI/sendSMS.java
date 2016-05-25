/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

import javax.microedition.io.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
import javax.wireless.messaging.*;

/**
 *
 * @author admin
 */
public class sendSMS extends Form implements CommandListener, Runnable {

    Image img;
    TextField toWhom;
    TextField message;
    Alert alert;
    Command envoyer, retour;
    MessageConnection clientConn;
    Form compose;

    public sendSMS() {
        super("sv");

        compose = new Form("Compose Message");
        try {
            img = Image.createImage("/smss.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        toWhom = new TextField("To", "5550000", 10, TextField.PHONENUMBER);
        message = new TextField("Message", "", 600, TextField.ANY);
        envoyer = new Command("envoyer", Command.SCREEN, 0);
        retour = new Command("retour", Command.EXIT, 0);
        compose.append(img);
        compose.append(toWhom);
        compose.append(message);
        compose.addCommand(envoyer);
        compose.addCommand(retour);
        compose.setCommandListener(this);
    }

    public void startApp() {
        Midlet.getDisplay().setCurrent(compose);

    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {

    }

    public void commandAction(Command cmd, Displayable disp) {
        if (cmd == retour) {

            Midlet.getDisplay().setCurrent(new FormContact().list);

        }
        if (cmd == envoyer) {
            Thread th = new Thread(this);
            th.start();

        }
    }

    public void run() {
        String mno = toWhom.getString();
        String msg = message.getString();
        if (mno.equals("")) {
            alert = new Alert("Alert");
            alert.setString("Enter Mobile Number!!!");
            alert.setTimeout(2000);
            Midlet.getDisplay().setCurrent(alert);
        } else {
            try {
                clientConn = (MessageConnection) Connector.open("sms://" + mno);
            } catch (Exception e) {
                alert = new Alert("Alert");
                alert.setString("Unable to connect to Station because of network problem");
                alert.setTimeout(2000);
                Midlet.getDisplay().setCurrent(alert);
            }
            try {
                TextMessage textmessage = (TextMessage) clientConn.newMessage(MessageConnection.TEXT_MESSAGE);
                textmessage.setAddress("sms://" + mno);
                textmessage.setPayloadText(msg);
                clientConn.send(textmessage);

            } catch (Exception e) {
                Alert alert = new Alert("Alert", "", null, AlertType.INFO);
                alert.setTimeout(Alert.FOREVER);
                alert.setString("Unable to send");
                Midlet.getDisplay().setCurrent(alert);
            }
        }
    }

}
