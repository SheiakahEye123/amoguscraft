import blocks.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;

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
        System.out.println("finished setup");
        ArrayList<point> points = new ArrayList<point>();
        point first = new point(5,5,2,7);
        points.add(first);

        ModdedPanel canvas = new ModdedPanel(points);
        frame.addKeyListener(new WASDListener(points, canvas));
        frame.addMouseListener(new MouseListener(points, canvas));
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (true) {
            canvas.repaint();
        }
    }
}
