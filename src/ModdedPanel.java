import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ModdedPanel extends JPanel {
    double x = 5;
    double y = 500;
    double z = 200;
    @Override
    protected void paintComponent(Graphics brush) {
        super.paintComponent(brush);
        project3Dto2D point = math.project3Dto2D(x,y,z);
        //System.out.println(point.screenx + "//" + point.screeny);
        brush.setColor(Color.black);
        brush.fillOval((int)point.screenx + getHeight()/2, (int)point.screeny + getWidth()/2, 10,10);
        repaint();
    }
}