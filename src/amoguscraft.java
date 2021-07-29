import Rendering.*;
import World.World;
import blocks.*;
import player.MouseListener;
import player.WASDListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class amoguscraft {
    public static void main(String[] args) {
        JFrame frame = new JFrame("amogus");
        //window.setSize(1920, 1080);
        frame.setSize(500, 500);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        frame.setVisible(true);
        System.out.println("finished setup");

       World world =  new World();

        ModdedPanel canvas = new ModdedPanel(world);
        frame.addKeyListener(new WASDListener(world.blocks, canvas));
        frame.addMouseListener(new MouseListener(world.blocks, canvas));
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (true) {
            canvas.repaint();
        }
    }
}

