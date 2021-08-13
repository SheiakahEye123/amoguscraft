package World;

import blocks.Block;
import blocks.sand;
import blocks.dirt;

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
                addBlockToChunk(new dirt(x, y, z));
        }
    }
    void createWorld() {
        for (int z = 2; z < 30; z += 1) {
            for (int x = 2; x < 30; x += 1) {
                int yHeight = (int) (WorldGen.noise(x / 30.0, z / 30.0) * 7) + 10;

                if(yHeight < 12) addBlockToChunk(new dirt(x, yHeight, z));
                else             addBlockToChunk(new sand(x, yHeight, z));
            }
        }
    }
    public static boolean isInChunk(Chunk chunk, double x, double y, double z){
        return ((int)x/16) == chunk.chunkx && ((int)y/16) == chunk.chunky && ((int)z/16) == chunk.chunkz;
    }

    void addBlockToChunk(Block block) {
        for(var chunk : chunks) {
            if(isInChunk(chunk, block.x, block.y, block.z)) {
                chunk.blocks
                        [(int) (blockCoordToArrayIndex(block.x))]
                        [(int) (blockCoordToArrayIndex(block.y))]
                        [(int) (blockCoordToArrayIndex(block.z))] = block;
                return;
            }
        }
        // finished search, no chunks found
        // make a new chunk
        chunks.add(new Chunk((int)(block.x / 16), (int)(block.y / 16), (int)(block.z / 16)));
        // try again
        addBlockToChunk(block);
    }

    double blockCoordToArrayIndex(double coord){
        var ret =  coord - 16 * Math.floor(coord/16);
        if(ret < 0)
            System.out.println(ret);
        return ret;
    }

    public World() {
        createWorld();
    }
}
