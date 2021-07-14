import org.w3c.dom.ls.LSOutput;
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

public class ModdedPanel<first> extends JPanel {
    ArrayList<point> points;
    ModdedPanel(ArrayList<point> points) {
        this.points = points;
    }
    double testAngleHor = 0;
    double testAngleVer = 0;

    @Override
    protected void paintComponent(Graphics brush) {
        // call the paintComponent method in JPanel (clear screen)
        super.paintComponent(brush);
        // rotate the points around the player
        //point3DRotation rotation = math.point3DRotation(x,y,z,testAngleHor);
        //point3DRotation rotation2 = math.point3DRotation(x2,y2,z2,testAngleHor);

        // project both 3D points to 2D
        //project3Dto2D point = math.project3Dto2D(rotation.x,y,rotation.z);
        //project3Dto2D point2 = math.project3Dto2D(rotation2.x,y,rotation2.z);

        // point #1 draw
        for (int index = 0; index < points.size(); index += 1) {
            point3DRotation rotation = math.point3DRotation(points.get(index).x,points.get(index).y,points.get(index).z,testAngleHor,testAngleVer);
            project3Dto2D point = math.project3Dto2D(rotation.x,rotation.y,rotation.z);
            brush.setColor(Color.black);
            brush.fillOval(
                    (int)(point.screenx*100) + getHeight()/2,
                    (int)(point.screeny*100) + getWidth()/2,
                    (int)(200*(1/points.get(index).x)),(int)(200*(1/points.get(index).x)));
        }
        repaint();
    }

}