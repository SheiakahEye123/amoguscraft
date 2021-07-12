import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ModdedPanel extends JPanel {
    double testAngleVer = 0;
    double testAngleHor = 0;
    double x = 5;
    double y = 5;
    double z = 2;

    double x2 = 5, y2 = -5, z2 = -2;

    @Override
    protected void paintComponent(Graphics brush) {
        // call the paintComponent method in JPanel (clear screen)
        super.paintComponent(brush);

        // rotate the points around the player
        point3DRotation rotation = math.point3DRotation(x,y,z,testAngleHor);
        point3DRotation rotation2 = math.point3DRotation(x2,y2,z2,testAngleHor);

        // project both 3D points to 2D
        project3Dto2D point = math.project3Dto2D(rotation.x,y,rotation.z);
        project3Dto2D point2 = math.project3Dto2D(rotation2.x,y,rotation2.z);

        // point #1 draw
        brush.setColor(Color.black);
        brush.fillOval(
                (int)(point.screenx*100) + getHeight()/2,
                (int)(point.screeny*100) + getWidth()/2,
                (int)(200*(1/x)),(int)(200*(1/x)));
        // point #2 draw
        brush.setColor(Color.red);
        brush.fillOval(
                (int)(point2.screenx*100) + getHeight()/2,
                (int)(point2.screeny*100) + getWidth()/2,
                (int)(200*(1/x)),(int)(200*(1/x)));

        // dirty bad horrible fix
        repaint();
    }
}