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
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import World.Chunk;

public class ModdedPanel extends JPanel {
    ArrayList<Chunk> chunks;
    public ModdedPanel(World world) {
        this.chunks = world.chunks;
    }
    public double testAngleHor = 0;
    public double testAngleVer = 0;

    @Override
    protected void paintComponent(Graphics brush) {
        // call the paintComponent method in JPanel (clear screen)
        super.paintComponent(brush);
        try {
            brush.drawImage(ImageIO.read(new File("C:\\Users\\kaide\\IdeaProjects\\amoguscraft\\src\\sky\\img.png")), 0, 0, null);
        }catch (IOException e) {
            e.printStackTrace();
        }

        chunks.sort((c1,  c2) -> -Double.compare(c1.distance(), c2.distance()));
        for(var chunk : chunks){
            var blocks = chunk.blocks;

            Arrays.stream(blocks)
                    .flatMap(Arrays::stream)
                    .flatMap(Arrays::stream)
                    .filter(Objects::nonNull)
                    .sorted((b1, b2) -> -Double.compare(b1.distance(), b2.distance()))
                    .forEach(block -> block.pointRendering(testAngleHor, testAngleVer, brush));
        }

        repaint();
    }
}
