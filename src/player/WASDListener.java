package player;

import Rendering.*;
import blocks.Block;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class WASDListener implements KeyListener{
    ArrayList<Block> blocks = new ArrayList<>();
    double speed = 0.6;
    public WASDListener(ArrayList<Block> points, ModdedPanel canvas) {
        this.blocks = points;
        this.canvas = canvas;
    }

    ModdedPanel canvas;
    boolean hitting(double x, double y, double z) {
        return (x <= 0.75 && x >= -0.75 && z <= 0.75 && z >= -0.75 && y <= 0.75 && y >= -1.75);
    }

    boolean hittingAnyBlock(ArrayList<Block> block, double movedX, double movedZ, double movedY) {
        for (int index = 0; index < blocks.size(); index += 1){
            if (hitting(blocks.get(index).x - movedX, blocks.get(index).y - movedY,blocks.get(index).z - movedZ)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent w) {
        point3DRotation forward = new point3DRotation(speed,0,0);

        point3DRotation WASDmove = new point3DRotation(0,0,0);

        point3DRotation rotatedForward = math.point3DRotation(forward.x, forward.y, forward.z, canvas.testAngleHor * -1, 0);
        if (w.getKeyCode() == KeyEvent.VK_W) {
            WASDmove.increaseBy(rotatedForward);
        }

        forward.x = 0;
        forward.y = 0;
        forward.z = speed * -1;

        point3DRotation rotatedLeft = math.point3DRotation(forward.x, forward.y, forward.z, canvas.testAngleHor * -1, 0);
        if (w.getKeyCode() == KeyEvent.VK_A) {
            WASDmove.increaseBy(rotatedLeft);
        }
        if (w.getKeyCode() == KeyEvent.VK_S) {
            WASDmove.decreaseBy(rotatedForward);
        }
        if (w.getKeyCode() == KeyEvent.VK_D) {
            WASDmove.decreaseBy(rotatedLeft);
        }
        if (w.getKeyCode() == KeyEvent.VK_SHIFT) {
            WASDmove.decreaseBy(new point3DRotation(0.0,-1.0,0.0));
        }
        if (w.getKeyCode() == KeyEvent.VK_SPACE) {
            WASDmove.decreaseBy(new point3DRotation(0.0,1.0,0.0));
        }

        if(!hittingAnyBlock(blocks, WASDmove.x * 1.1, WASDmove.z * 1.1, WASDmove.y * 1.1)){
            System.out.println("not hitting anything");
            System.out.println("totoal move: " + WASDmove.x + " " + WASDmove.z);

            for(Block block : blocks){
                block.x -= WASDmove.x;
                block.z -= WASDmove.z;
                block.y -= WASDmove.y;
            }
        }else{
            System.out.println("hit something");
        }

        if (w.getKeyCode() == KeyEvent.VK_J) {
            canvas.testAngleHor -= 0.1;
        }
        if (w.getKeyCode() == KeyEvent.VK_L) {
            canvas.testAngleHor += 0.1;
        }
        if (w.getKeyCode() == KeyEvent.VK_I) {
            canvas.testAngleVer -= 0.1;
        }
        if (w.getKeyCode() == KeyEvent.VK_K) {
            canvas.testAngleVer += 0.1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
