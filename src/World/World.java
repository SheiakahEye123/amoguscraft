package World;

import Rendering.ModdedPanel;
import blocks.Block;

import java.util.ArrayList;

// holds all things block-related
public class World {
    Block grass = new Block(0,0,0, 0.6, "grass");
    // World holds a list of all block to be drawn
    public ArrayList<Block> blocks = new ArrayList<Block>();


    public World() {
        // when a world object is created, it adds a new block to its list of blocks
        //for (int index = 0; index < 1000; index += 1) {
            //blocks.add(new Block(0, 0, Math.random() * 1000, 0, "sussyblock"));
        blocks.add(new Block(0,0,0, 0, "sussyblock"));
    }
}
