package World;

import blocks.Block;

public class Chunk {
    Block[][][] blocks = new Block[16][16][16];
    double chunkx;
    double chunky;
    double chunkz;
    Chunk (double chunkx, double chunky, double chunkz) {
        this.chunkx = chunkx;
        this.chunky = chunky;
        this.chunkz = chunkz;
    }
}
