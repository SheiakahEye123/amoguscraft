package World;

import blocks.Block;

public class Chunk {
    public Block[][][] blocks = new Block[16][16][16];
    double chunkx;
    double chunky;
    double chunkz;
    Chunk (double chunkx, double chunky, double chunkz) {
        this.chunkx = chunkx;
        this.chunky = chunky;
        this.chunkz = chunkz;
    }
    
    public double distance(){
        return Math.sqrt(chunkx*chunkx + chunky*chunky + chunkz*chunkz);
    }
}
