import blocks.*;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.security.Key;

public class amoguscraft {
    public static void main(String[] args) {
        woodPlank woodPlank = new woodPlank(0,0,0);
        stone stone = new stone(1,0,0);
        dirt dirt = new dirt(2,0,0);
        wood wood = new wood(3,0,0);
        bedrock bedrock = new bedrock(4,0,0);
        JFrame frame = new JFrame("amogus");

        //window.setSize(1920, 1080);
        frame.setSize(500, 500);

        ModdedPanel canvas = new ModdedPanel();

        frame.addKeyListener(new WASDListener(canvas));
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        System.out.println("finished setup");

        while (true) {
            canvas.repaint();
        }

    }
}
