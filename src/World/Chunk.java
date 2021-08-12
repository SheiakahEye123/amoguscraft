package World;

import blocks.Block;
import player.Player;

import java.util.function.Consumer;

public class Chunk {
    public Block[][][] blocks = new Block[16][16][16];
    int chunkx;
    int chunky;
    int chunkz;

    Chunk (int chunkx, int chunky, int chunkz) {
        this.chunkx = chunkx;
        this.chunky = chunky;
        this.chunkz = chunkz;
    }

    public void forEveryBlock(Consumer<Block> action){
        for(var slice : blocks)
            for(var column : slice)
                for(var block : column)
                    if(block != null)
                        action.accept(block);
    }
    
    public double distanceTo(Player player){
        double deltaX = (chunkx + 0.5) - (player.x / 16.0); // chunkx is in chunk coords!
        double deltaY = (chunky + 0.5) - (player.y / 16.0); // chunky is in chunk coords!
        double deltaZ = (chunkz + 0.5) - (player.z / 16.0); // chunkz is in chunk coords!

        return Math.sqrt(deltaX*deltaX + deltaY*deltaY + deltaZ*deltaZ);
    }
}
