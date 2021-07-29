package Rendering;

import World.World;
import blocks.Block;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ModdedPanel extends JPanel {
    ArrayList<Block> blocks;
    public ModdedPanel(World world) {
        this.blocks = world.blocks;
    }
    public double testAngleHor = 0;
    public double testAngleVer = 0;

    @Override
    protected void paintComponent(Graphics brush) {
        // call the paintComponent method in JPanel (clear screen)
        super.paintComponent(brush);
        try {
            brush.drawImage(ImageIO.read(new File("C:\\Users\\kaide\\IdeaProjects\\amoguscraft\\src\\sky\\img.png")),0,0,null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        brush.setColor(Color.black);
        for(var block : blocks) {
            block.pointRendering(testAngleHor, testAngleVer, brush);
        }
        repaint();
    }
}
