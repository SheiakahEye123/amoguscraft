import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ModdedPanel extends JPanel {
    double x = 5;
    double y = 500;
    double z = 200;

    double x2 = 5, y2 = -500, z2 = -200;

    @Override
    protected void paintComponent(Graphics brush) {
        // call the paintComponent method in JPanel (clear screen)
        super.paintComponent(brush);

        // project both 3D points to 2D
        project3Dto2D point = math.project3Dto2D(x,y,z);
        project3Dto2D point2 = math.project3Dto2D(x2,y2,z2);

        brush.setColor(Color.black);
        // point #1 draw
        brush.fillOval((int)point.screenx + getHeight()/2, (int)point.screeny + getWidth()/2, 10,10);
        // point #2 draw
        brush.fillOval((int)point2.screenx + getHeight()/2, (int)point2.screeny + getWidth()/2, 10,10);

        // dirty bad horrible fix
        repaint();
    }
}