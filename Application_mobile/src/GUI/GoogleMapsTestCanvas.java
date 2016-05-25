package GUI;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

abstract public class GoogleMapsTestCanvas extends Canvas implements CommandListener {

    Command back;

    public GoogleMapsTestCanvas(Displayable d) {
        this.addCommand(back = new Command("Back", Command.BACK, 0));
        this.setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == back) {
            Midlet.getDisplay().setCurrent(new Accueil(null, List.IMPLICIT));
        }
    }

    void showError(String message) {
        Alert error = new Alert("Error", message, null, AlertType.ERROR);
        Midlet.getDisplay().setCurrent(error, this);
    }
}
