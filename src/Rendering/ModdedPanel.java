package Rendering;

import blocks.Block;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ModdedPanel extends JPanel {
    ArrayList<Block> blocks;
    public ModdedPanel(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }
    public double testAngleHor = 0;
    public double testAngleVer = 0;

    @Override
    protected void paintComponent(Graphics brush) {
        // call the paintComponent method in JPanel (clear screen)
        super.paintComponent(brush);

        brush.setColor(Color.black);
        for(var block : blocks) {
            block.pointRendering(testAngleHor, testAngleVer, brush);
        }
        repaint();
    }
}
