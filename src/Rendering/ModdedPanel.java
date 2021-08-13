package Rendering;

import World.World;
import player.Player;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import World.Chunk;
import player.WASDListener;

public class ModdedPanel extends JPanel {
    Player player;
    WASDListener wasdListener;
    ArrayList<Chunk> chunks;
    BufferedImage background;

    public ModdedPanel(World world, WASDListener wasdListener, Player player) {
        this.chunks = world.chunks;
        this.player = player;
        this.wasdListener = wasdListener;

        File imageLocation = new File("src/sky/img.png");
        try {
            background = ImageIO.read(imageLocation);
        }catch (IOException e) {
            System.out.println("Could not find image. Looked in " + imageLocation.getAbsolutePath());
            e.printStackTrace();
        }

    }

    @Override
    protected void paintComponent(Graphics brush) {
        // call the paintComponent method in JPanel (clear screen)
        super.paintComponent(brush);

        brush.drawImage(background, 0, 0, null);

        chunks.sort((c1,  c2) -> -Double.compare(c1.distanceTo(player), c2.distanceTo(player)));
        for(var chunk : chunks){
            var blocks = chunk.blocks;

            Arrays.stream(blocks)
                    .flatMap(Arrays::stream)
                    .flatMap(Arrays::stream)
                    .filter(Objects::nonNull)
                    .sorted((b1, b2) -> -Double.compare(b1.distanceTo(player), b2.distanceTo(player)))
                    .forEach(block -> block.pointRendering(player, player.hor, player.ver, brush));
        }

        wasdListener.keyActionUpdate();

    }
}
