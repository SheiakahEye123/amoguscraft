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
    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent w) {
        point3DRotation forward = new point3DRotation();
        forward.x = speed;
        forward.y = 0;
        forward.z = 0;

        point3DRotation rotatedForward = math.point3DRotation(forward.x, forward.y, forward.z, canvas.testAngleHor * -1, 0);
        if (w.getKeyCode() == KeyEvent.VK_W) {
            for (int index = 0; index < blocks.size(); index += 1) {
                blocks.get(index).x -= rotatedForward.x;
                blocks.get(index).z -= rotatedForward.z;
            }
        }
        point3DRotation left = new point3DRotation();
        forward.x = 0;
        forward.y = 0;
        forward.z = speed * -1;

        point3DRotation rotatedLeft = math.point3DRotation(forward.x, forward.y, forward.z, canvas.testAngleHor * -1, 0);
        if (w.getKeyCode() == KeyEvent.VK_A) {
            for (int index = 0; index < blocks.size(); index += 1) {
                blocks.get(index).x -= rotatedLeft.x;
                blocks.get(index).z -= rotatedLeft.z;
            }
        }
        if (w.getKeyCode() == KeyEvent.VK_S) {
            for (int index = 0; index < blocks.size(); index += 1) {
                blocks.get(index).x -= -rotatedForward.x;
                blocks.get(index).z -= -rotatedForward.z;
            }
        }
        if (w.getKeyCode() == KeyEvent.VK_D) {
            for (int index = 0; index < blocks.size(); index += 1) {
                blocks.get(index).x -= -rotatedLeft.x;
                blocks.get(index).z -= -rotatedLeft.z;
            }
        }
        if (w.getKeyCode() == KeyEvent.VK_SHIFT) {
            for (int index = 0; index < blocks.size(); index += 1) {
                blocks.get(index).y -= 1;
            }
        }
        if (w.getKeyCode() == KeyEvent.VK_SPACE) {
            for (int index = 0; index < blocks.size(); index += 1) {
                blocks.get(index).y += 1;
            }
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
