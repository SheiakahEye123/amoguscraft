package player;

import Rendering.ModdedPanel;
import Rendering.point;
import blocks.Block;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class WASDListener implements KeyListener{

    ArrayList<Block> blocks = new ArrayList<>();
    public WASDListener(ArrayList<Block> points, ModdedPanel canvas) {
        this.blocks = points;
        this.canvas = canvas;
    }

    ModdedPanel canvas;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent w) {

        if (w.getKeyCode() == KeyEvent.VK_W) {
            for (int index = 0; index < blocks.size(); index += 1) {
                blocks.get(index).x -= 1;
            }
        }
        if (w.getKeyCode() == KeyEvent.VK_A) {
            for (int index = 0; index < blocks.size(); index += 1) {
                blocks.get(index).z += 1;
            }
        }
        if (w.getKeyCode() == KeyEvent.VK_S) {
            for (int index = 0; index < blocks.size(); index += 1) {
                blocks.get(index).x += 1;
            }
        }
        if (w.getKeyCode() == KeyEvent.VK_D) {
            for (int index = 0; index < blocks.size(); index += 1) {
                blocks.get(index).z -= 1;
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
