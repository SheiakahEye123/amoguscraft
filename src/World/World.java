package World;

import blocks.Block;
import java.util.ArrayList;

// holds all things block-related
public class World {
    Block grass = new Block(0,0,0, 0.6, "grass");
    // World holds a list of all block to be drawn
    public ArrayList<Chunk> chunks = new ArrayList<Chunk>();
    void createFlat() {
        int y = 0;
        for (int z = 0; z < 100; z += 1) {
            for (int x = 0; x < 100; x += 1)
                addBlockToChunk(new Block((double) x, (double) y, (double) z, 0.6, "grass"));
        }
    }
    void createWorld() {
        int y = 0;
        for (int z = 2; z < 100; z += 1) {
            for (int x = 2; x < 100; x += 1)
                addBlockToChunk(new Block((double) x, WorldGen.noise(x / 50.0, z / 50.0) * 5, (double) z, 0.6, "grass"));
        }
    }
    void addBlockToChunk(Block Block) {
        for(var chunk : chunks) {
            if((int) (Block.x / 16)  == chunk.chunkx && (int) (Block.y / 16)  == chunk.chunky && (int) (Block.z / 16)  == chunk.chunkz) {
                chunk.blocks
                        [(int) (blockCoordToArrayIndex(Block.x))]
                        [(int) (blockCoordToArrayIndex(Block.y))]
                        [(int) (blockCoordToArrayIndex(Block.z))] = Block;
                return;
            }
        }
        // finished search, no chunks found
        // make a new chunk
        chunks.add(new Chunk((int)(Block.x / 16), (int) (Block.y / 16), (int) (Block.z / 16)));
        // try again
        addBlockToChunk(Block);
    }

    double blockCoordToArrayIndex(double coord){
        var ret =  coord - 16 * Math.floor(coord/16);
        if(ret < 0)
            System.out.println(ret);
        return ret;
    }

    public World() {
        // when a world object is created, it adds a new block to its list of blocks
        //for (int index = 0; index < 1000; index += 1) {
            //blocks.add(new Block(0, 0, Math.random() * 1000, 0, "sussyblock"));
        createWorld();
    }
}
