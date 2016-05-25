package GUI;

import Entites.Covoiturage;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 *
 * @author Hhussein
 */
public class Splashscreen extends Canvas implements Runnable {

    Image img[] = new Image[19];
    int imgIndex = 0;
    public Thread th;
    private Midlet projectMIDlet;
    Covoiturage covoiturage;

    public Splashscreen(Covoiturage covoiturage) {
        this.covoiturage = covoiturage;
        this.projectMIDlet = projectMIDlet;
        try {
            img[0] = Image.createImage("/frame-01.gif");
            img[1] = Image.createImage("/frame-02.gif");
            img[2] = Image.createImage("/frame-03.gif");
            img[3] = Image.createImage("/frame-04.gif");
            img[4] = Image.createImage("/frame-05.gif");
            img[5] = Image.createImage("/frame-06.gif");
            img[6] = Image.createImage("/frame-07.gif");
            img[7] = Image.createImage("/frame-08.gif");
            img[8] = Image.createImage("/frame-09.gif");
            img[9] = Image.createImage("/frame-10.gif");
            img[10] = Image.createImage("/frame-11.gif");
            img[11] = Image.createImage("/frame-12.gif");
            img[12] = Image.createImage("/frame-13.gif");
            img[13] = Image.createImage("/frame-14.gif");
            img[14] = Image.createImage("/frame-15.gif");
            img[15] = Image.createImage("/frame-16.gif");
            img[16] = Image.createImage("/frame-17.gif");
            img[17] = Image.createImage("/frame-18.gif");
            Thread th = new Thread(this);
            th.start();
        } catch (Exception e) {
        }
    }

//Display GIF image
    public void paint(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        System.out.println("  height" + height);
        System.out.println("  width" + width);
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, width, height);

        if (imgIndex <= 17) {
            g.drawImage(img[imgIndex], width / 2, height / 2,
                    Graphics.HCENTER | Graphics.VCENTER);

            repaint();
        }

    }

//Handling keyEvents
    protected void keyPressed(int keyCode) {
    }

    public void dismiss() {
        if (isShown()) {
            System.out.println("stop stop");
            Midlet.getDisplay().setCurrent(new GoogleMapsCanvas(covoiturage));
            th.interrupt();
        }
    }

    public void run() {
        while (true) {
            System.out.println("INDEX" + imgIndex);
            imgIndex++;
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
            if (imgIndex == 17) {
                dismiss();
            }
        }
    }
}
