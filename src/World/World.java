package World;

import Rendering.ModdedPanel;
import blocks.Block;
import java.util.ArrayList;

// holds all things block-related
public class World {
    Block grass = new Block(0,0,0, 0.6, "grass");
    // World holds a list of all block to be drawn
    public ArrayList<Block> blocks = new ArrayList<Block>();
    void createFlat() {
        int y = 0;
        for (int z = 0; z < 100; z += 1) {
            for (int x = 0; x < 100; x += 1)
                blocks.add(new Block((double) x, (double) y, (double) z, 0.6, "grass"));
        }
    }
    void createWorld() {
        int y = 0;
        for (int z = 2; z < 100; z += 1) {
            for (int x = 2; x < 100; x += 1)
                blocks.add(new Block((double) x, WorldGen.noise(x/50.0,z/50.0) * 5, (double) z, 0.6, "grass"));
        }
    }
    public World() {
        // when a world object is created, it adds a new block to its list of blocks
        //for (int index = 0; index < 1000; index += 1) {
            //blocks.add(new Block(0, 0, Math.random() * 1000, 0, "sussyblock"));
        createWorld();
    }
}
