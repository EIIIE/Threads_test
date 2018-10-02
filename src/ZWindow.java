

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

class DataLoad extends Thread {

    private Image image = null;
    private URL url = null;

    public DataLoad(String stringUrl){
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {}
    }


    @Override
    public void run() {
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {}
    }

    public Image getImage() {
        start();
        try {
            join();
        } catch (InterruptedException e) { }
        return image;
    }
}

class Panel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        DataLoad dLoad = new DataLoad("https://rugeroi.ru/wp-content/uploads/2016/11/prikolchiki_12.jpg");
        g.drawImage(dLoad.getImage(), 0, 0, null);
    }
}

public class ZWindow extends JFrame {

    public ZWindow() {
        this.setBounds(20, 20, 900, 900);
        setVisible(true);
        this.setContentPane(new Panel());
        setFocusable(true);
    }

}
