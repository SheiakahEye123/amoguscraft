import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class WASDListener implements KeyListener{

    ArrayList<point> points = new ArrayList<point>();
    WASDListener(ArrayList<point> points, ModdedPanel canvas) {
        this.points = points;
        this.canvas = canvas;
    }

    ModdedPanel canvas = new ModdedPanel(points);

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent w) {

        if (w.getKeyCode() == KeyEvent.VK_W) {
            for (int index = 0; index < points.size(); index += 1) {
                points.get(index).x -= 1;
            }
        }
        if (w.getKeyCode() == KeyEvent.VK_A) {
            for (int index = 0; index < points.size(); index += 1) {
                points.get(index).z -= 1;
            }
        }
        if (w.getKeyCode() == KeyEvent.VK_S) {
            for (int index = 0; index < points.size(); index += 1) {
                points.get(index).x += 1;
            }
        }
        if (w.getKeyCode() == KeyEvent.VK_D) {
            for (int index = 0; index < points.size(); index += 1) {
                points.get(index).z += 1;
            }
        }
        if (w.getKeyCode() == KeyEvent.VK_SHIFT) {
            for (int index = 0; index < points.size(); index += 1) {
                points.get(index).y += 1;
            }
        }
        if (w.getKeyCode() == KeyEvent.VK_SPACE) {
            for (int index = 0; index < points.size(); index += 1) {
                points.get(index).y -= 1;
            }
        }
        if (w.getKeyCode() == KeyEvent.VK_J) {
            canvas.testAngleHor -= 0.1;
        }
        if (w.getKeyCode() == KeyEvent.VK_L) {
            canvas.testAngleHor += 0.1;
        }
        if (w.getKeyCode() == KeyEvent.VK_I) {
            canvas.testAngleVer += 0.1;
        }
        if (w.getKeyCode() == KeyEvent.VK_K) {
            canvas.testAngleVer -= 0.1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
