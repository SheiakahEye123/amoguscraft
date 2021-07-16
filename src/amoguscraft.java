import Rendering.*;
import blocks.*;
import player.MouseListener;
import player.WASDListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class amoguscraft {
    public static void main(String[] args) {
        woodPlank woodPlank = new woodPlank(0, 0, 0);
        stone stone = new stone(1, 0, 0);
        dirt dirt = new dirt(2, 0, 0);
        wood wood = new wood(3, 0, 0);
        bedrock bedrock = new bedrock(4, 0, 0);
        JFrame frame = new JFrame("amogus");
        //window.setSize(1920, 1080);
        frame.setSize(500, 500);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        frame.setVisible(true);
        System.out.println("finished setup");
        ArrayList<Block> blocks = new ArrayList<Block>();
        blocks.add(new Block(4,0,0,0, null));

        ModdedPanel canvas = new ModdedPanel(blocks);
        frame.addKeyListener(new WASDListener(blocks, canvas));
        frame.addMouseListener(new MouseListener(blocks, canvas));
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (true) {
            canvas.repaint();
        }
    }
}

