import Rendering.ModdedPanel;
import World.World;
import player.Player;
import player.WASDListener;

import javax.swing.*;

public class amoguscraft {
    public static void main(String[] args) {
        JFrame frame = new JFrame("amogus");
        frame.setSize(500, 500);
        frame.setVisible(true);

        System.out.println("finished setup");

        World world =  new World();

        Player player = new Player();

        WASDListener wasdListener = new WASDListener(world.chunks, player);

        ModdedPanel canvas = new ModdedPanel(world, wasdListener, player);

        frame.addKeyListener(wasdListener);
        //frame.addMouseListener(new MouseListener(world.blocks, canvas));

        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (true) {
            canvas.repaint();
        }
    }
}

