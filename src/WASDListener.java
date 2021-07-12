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
            canvas.z += 100;
            canvas.z2 += 100;
        }
        if (w.getKeyCode() == KeyEvent.VK_S) {
            canvas.x += 1;
            canvas.x2 += 1;
        }
        if (w.getKeyCode() == KeyEvent.VK_D) {
            canvas.z -= 100;
            canvas.z2 -= 100;
        }
        if (w.getKeyCode() == KeyEvent.VK_SHIFT) {
            canvas.y -= 100;
            canvas.y2 -= 100;
        }
        if (w.getKeyCode() == KeyEvent.VK_SPACE) {
            canvas.y -= 100;
            canvas.y2 -= 100;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    WASDListener(ModdedPanel canvas) {
        this.canvas = canvas;
    }
}