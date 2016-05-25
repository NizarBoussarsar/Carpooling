package GUI;

/**
 *
 * @author Nizar
 */
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;

public class SplashScreen_D extends Canvas implements Runnable {

    private Authentification authentification;
    private Player player = null;
    private Image mImage;

    /**
     * The constructor attempts to load the named image and begins a timeout
     * thread. The splash screen can be dismissed with a key press, a pointer
     * press, or a timeout
     *
     * @param projectMIDlet instance of MIDlet
     */
    public SplashScreen_D() {
        try {
            //Create the image
            mImage = Image.createImage("/covoiturage.png");
            Thread t = new Thread(this);
            t.start();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }

    /**
     * Paints the image centered on the screen.
     */
    public void paint(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        //set background color to overdraw what ever was previously displayed
        g.setColor(0x000000);
        g.fillRect(0, 0, width, height);
        g.drawImage(mImage, width / 2, height / 2,
                Graphics.HCENTER | Graphics.VCENTER);
    }

    /**
     * Dismisses the splash screen with a key press or a pointer press
     */
    public void dismiss() {
        if (isShown()) {
            authentification = new Authentification("Authentification Covoiturage");
            Midlet.getDisplay().setCurrent(authentification);
            //Midlet.getDisplay().setCurrent(new CovoituragesRecents().accueilForm);
        }
    }

    /**
     * Default timeout with thread
     */
    public void run() {
        try {
            //Play the sound
            player = Manager.createPlayer(getClass().getResourceAsStream("/bmw.wav"), "audio/x-wav");
            player.setLoopCount(1);
            player.start();
            Thread.sleep(1500);//set for 5 seconds
            player.close();
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
        dismiss();
    }
    /**
     * A key release event triggers the dismiss() method to be called.
     */
}
