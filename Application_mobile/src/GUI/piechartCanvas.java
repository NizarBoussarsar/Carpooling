package GUI;


import Entites.statsVilles;
import Handlers.statsvillesHandler;
import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
public class piechartCanvas  extends Canvas implements Runnable, CommandListener{
    public statsVilles[] stats;
    int[] data;
    
    private Command exitCommand;

    public piechartCanvas() {
        Thread th = new Thread(this);
        th.start();
        run();
        exitCommand = new Command("exit", Command.EXIT, 1);
        this.setTitle("TOP 3 villes visitées");
        this.addCommand(exitCommand);
        this.setCommandListener(this);
        
    }
    
    protected void paint(Graphics g) {
    int colors[] = {0xC5F63E, 0x5AF9D4, 0xFD83AC};
    int width = this.getWidth();
            int height = this.getHeight();

            g.setColor(255, 255, 255);
            g.fillRect(0, 0, width, height);
            g.setColor(0xC5F63E);
            g.fillRect(10, 10, 20, 20);
            g.setColor(0x5AF9D4);
            g.fillRect(10, 40, 20, 20);
            g.setColor(0xFD83AC);
            g.fillRect(10, 70, 20, 20);
            g.setColor(000000);
            g.drawString(stats[0].ville + " : " + stats[0].nombre + " covoiturages", 40, 10,
                    Graphics.TOP | Graphics.LEFT);
            g.drawString(stats[1].ville + " : " + stats[1].nombre + " covoiturages", 40, 40,
                    Graphics.TOP | Graphics.LEFT);
            g.drawString(stats[2].ville + " : " + stats[2].nombre + " covoiturages", 40, 70,
                    Graphics.TOP | Graphics.LEFT);

            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += stats[i].getNombre();
            }
            System.out.println("somme = "+sum);
            int deltaAngle = 360 / sum;
            int x = 4;
            int y = 4;
            int diameter;

            if (width > height) {
                diameter = height - y * 2;
            } else {
                diameter = width - x * 2;
            }

            int startAngle = 0;
            int angle = 0;
            for (int i = 0; i < 3; i++) {
                g.setColor(colors[i]);
                System.out.println("angle debut:" + startAngle);
                System.out.println("angle à dessiner " + 360 * stats[i].getNombre() / sum);
                g.fillArc(x / 4 + 50, y / 4 + 120, diameter - 100, diameter - 100, startAngle, 360 * stats[i].getNombre() / sum);
                startAngle += 360 * stats[i].getNombre() / sum;
            }

    }

    public void run() {
         try {
            // this will handle our XML
            statsvillesHandler statsvillesHandler = new statsvillesHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/covoituragej2me/getXmlstatsvilles.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, statsvillesHandler);
            // display the result
            stats = statsvillesHandler.getPersonne();
            

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (c==exitCommand) {
      Midlet.getDisplay().setCurrent(new statistiquesForm(7)); 
        }
    }
    
}
