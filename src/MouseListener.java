import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseListener implements java.awt.event.MouseListener {
    ArrayList<point> points = new ArrayList<point>();
    MouseListener (ArrayList<point> points, ModdedPanel canvas) {
        this.points = points;
        this.canvas = canvas;
    }

    ModdedPanel canvas = new ModdedPanel(points);

    @Override
    public void mouseClicked(MouseEvent e) {
        double mousex = e.getX();
        double mousey = e.getY();
        System.out.println(mousex + "//" + mousey);
        point sussy = new point(5,5,2,7);
        points.add(sussy);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
