import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WASDListener implements KeyListener {
    ModdedPanel canvas;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent w) {
        if (w.getKeyCode() == KeyEvent.VK_W) {
            canvas.x -= 1;
            canvas.x2 -= 1;
        }
        if (w.getKeyCode() == KeyEvent.VK_A) {
            canvas.z += 1;
            canvas.z2 += 1;
        }
        if (w.getKeyCode() == KeyEvent.VK_S) {
            canvas.x += 1;
            canvas.x2 += 1;
        }
        if (w.getKeyCode() == KeyEvent.VK_D) {
            canvas.z -= 1;
            canvas.z2 -= 1;
        }
        if (w.getKeyCode() == KeyEvent.VK_SHIFT) {
            canvas.y += 10;
            canvas.y2 += 10;
        }
        if (w.getKeyCode() == KeyEvent.VK_SPACE) {
            canvas.y -= 10;
            canvas.y2 -= 10;
        }
        if (w.getKeyCode() == KeyEvent.VK_J) {
            canvas.testAngleHor -= 0.01;
        }
        if (w.getKeyCode() == KeyEvent.VK_L) {
            canvas.testAngleHor += 0.01;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    WASDListener(ModdedPanel canvas) {
        this.canvas = canvas;
    }
}