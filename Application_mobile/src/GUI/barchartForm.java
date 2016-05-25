package GUI;

import Entites.statsPrix;
import Handlers.statsprixHandler;
import java.io.DataInputStream;
import java.util.Random;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Spacer;
import javax.microedition.lcdui.Ticker;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.beanizer.j2me.charts.ChartItem;
import org.beanizer.j2me.charts.VBarChart;

/**
 *
 * @author joe
 */
public class barchartForm extends Form implements Runnable, CommandListener {

    private final static Command CMD_EXIT = new Command("Exit", Command.EXIT, 1);
    final VBarChart item2 = new VBarChart("");
    statsPrix[] stats;
    int id;

    public barchartForm(int x) {
        super("titre");
        this.id = x;
        System.out.println("BAR chAR FoRM" + this.id);
        this.setTitle("Mes dépenses");
        Thread th = new Thread(this);
        th.start();
        run();
        Ticker ticker = new Ticker("Mes Dépenses");
        initItem(item2);
        this.setTicker(ticker);
        this.append(new Spacer(50, 50));
        this.append(item2);
        this.addCommand(CMD_EXIT);
        this.setCommandListener(this);
        System.out.println("je suis ici j'ai f tout correct");
    }

    public int max(statsPrix[] p) {
        int max = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i].getPrice() > max) {
                max = p[i].price;
            }
        }
        return max;
    }

    /**
     * Initializes given chart item
     *
     *
     */
    private void initItem(ChartItem item) {

        item.setFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
        item.setDrawAxis(true);
        item.setPreferredSize(this.getWidth(), 120);
        item.setMargins(5, 45, 10, 15);

        item.showShadow(true);
        item.setShadowColor(20, 20, 20);
        item.setColor(40, 40, 200);
        item.resetData();
        int x;
        int y;
        int w;
        Random rand = new Random();
        for (int i = 0; i < stats.length; i++) {

            x = rand.nextInt(255);
            y = rand.nextInt(255);
            w = rand.nextInt(255);

            System.out.println(x);

            item.addElement(stats[i].getDatep(), stats[i].getPrice(), x, y, w);
        }

        item.setMaxValue(max(stats));
    }

    public void run() {
        try {
            // this will handle our XML
            statsprixHandler statsprixHandler = new statsprixHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/covoituragej2me/getXmlstatsPrix.php?id=" + id);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, statsprixHandler);
            // display the result
            stats = statsprixHandler.getPersonne();
            System.out.println("handler length " + stats.length);

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (c == CMD_EXIT) {
            Midlet.getDisplay().setCurrent(new statistiquesForm(id));
        }
    }
}
