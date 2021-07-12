import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class WASDListener implements KeyListener {

    ArrayList<point> points = new ArrayList<point>();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent w) {

        if (w.getKeyCode() == KeyEvent.VK_W) {
            canvas.x -= 1;
        }
        if (w.getKeyCode() == KeyEvent.VK_A) {
            canvas.z += 1;
        }
        if (w.getKeyCode() == KeyEvent.VK_S) {
            canvas.x += 1;
        }
        if (w.getKeyCode() == KeyEvent.VK_D) {
            canvas.z -= 1;
        }
        if (w.getKeyCode() == KeyEvent.VK_SHIFT) {
            canvas.y += 10;
        }
        if (w.getKeyCode() == KeyEvent.VK_SPACE) {
            canvas.y -= 10;
        }
        if (w.getKeyCode() == KeyEvent.VK_J) {
            canvas.testAngleHor -= 0.1;
        }
        if (w.getKeyCode() == KeyEvent.VK_L) {
            canvas.testAngleHor += 0.1;
        }
        if (w.getKeyCode() == KeyEvent.VK_L) {
            canvas.testAngleHor += 0.1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    WASDListener(ArrayList<point> points) {
        this.points = points;
    }
}
