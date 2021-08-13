
package player;

import Rendering.*;
import World.Chunk;
import blocks.Block;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import static World.World.isInChunk;

public class WASDListener implements KeyListener{
    Player player;
    ArrayList<Chunk> chunks;
    double speed = 0.1;

    // is this key pressed
    static int MAX_KEY_CODE = 0x020D;
    boolean[] keyPressed = new boolean[MAX_KEY_CODE];

    public WASDListener(ArrayList<Chunk> chunks, Player player) {
        this.chunks = chunks;
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    boolean hitting(Block block, double playerX, double playerY, double playerZ) {
        double  relativeX =  (block.x + 0.5) - playerX,
                relativeY  = (block.y + 0.5) - playerY,
                relativeZ =  (block.z + 0.5) - playerZ;

        return
                (relativeX <= 1.2 && relativeX >= -1.2 &&
                relativeZ <= 1.2 && relativeZ >= -1.2 &&
                relativeY <= 2.1 && relativeY >= -1.2);
    }

    boolean hittingAnyBlock(List<Chunk> chunks, double x, double y, double z){
        for(int i = 0; i < chunks.size(); i++){
            var chunk = chunks.get(i);
            if(isInChunk(chunk, player.x, player.y, player.z)){
                for(var slice : chunk.blocks){
                for(var column : slice){
                for(var block : column){
                    if(block != null && hitting(block, x, y, z))
                        return true;
                }}}
            }
        }
        return false;
    }


    public void keyActionUpdate() {
        point3DRotation forward = new point3DRotation(speed,0,0);

        point3DRotation rotatedForward = math.point3DRotation(
                forward.x, forward.y, forward.z,
                -player.hor, 0);

        point3DRotation rotatedLeft = math.point3DRotation(
                forward.x, forward.y, forward.z,
                -player.hor + Math.toRadians(90), 0);

        point3DRotation WASDmove = new point3DRotation(0,0,0);

        if (keyPressed[KeyEvent.VK_W]) {
            WASDmove.increaseBy(rotatedForward);
        }
        if (keyPressed[KeyEvent.VK_A]) {
            WASDmove.increaseBy(rotatedLeft);
        }
        if (keyPressed[KeyEvent.VK_S]) {
            WASDmove.decreaseBy(rotatedForward);
        }
        if (keyPressed[KeyEvent.VK_D]) {
            WASDmove.decreaseBy(rotatedLeft);
        }
        if (keyPressed[KeyEvent.VK_SHIFT]) {
            WASDmove.decreaseBy(new point3DRotation(0.0,-speed,0.0));
        }
        if (keyPressed[KeyEvent.VK_SPACE]) {
            WASDmove.decreaseBy(new point3DRotation(0.0,speed, 0.0));
        }

        player.move(WASDmove.multiply(1.2));
        if(hittingAnyBlock(chunks,
                         player.x,
                         player.y,
                         player.z))
            player.move(WASDmove.multiply(-1.2));

        if (keyPressed[KeyEvent.VK_J]) {
            player.hor -= 0.1 * speed;
        }
        if (keyPressed[KeyEvent.VK_L]) {
            player.hor += 0.1 * speed;
        }
        if (keyPressed[KeyEvent.VK_I]) {
            player.ver -= 0.1 * speed;
        }
        if (keyPressed[KeyEvent.VK_K]) {
            player.ver += 0.1 * speed;
        }
    }

    @Override
    public void keyPressed(KeyEvent w) {
        keyPressed[w.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent w) {
        keyPressed[w.getKeyCode()] = false;
    }
}

