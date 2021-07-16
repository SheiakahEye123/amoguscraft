package blocks;

import Rendering.math;
import Rendering.point;
import Rendering.point3DRotation;
import Rendering.project3Dto2D;

import java.awt.*;
import java.sql.SQLOutput;

public class Block {
    public double x;
    public double y;
    public double z;
    public double Hardness;
    point[] sussyList = new point[]{
            new point(0, 0, 0, 0),
            new point(7, 0, 0, 0),
            new point(0, 0, 7, 0),
            new point(7, 0, 7, 0),
            new point(7, 7, 0, 0),
            new point(0, 7, 7, 0),
            new point(7, 7, 7, 0),
            new point(0, 7, 0, 0)
    };
    String id;

    public void pointRendering(double testAngleHor, double testAngleVer, Graphics brush) {
        project3Dto2D[] sussy2DArray = new project3Dto2D[8];

        for (int index = 0; index < sussyList.length; index += 1) {
            point3DRotation rotation = math.point3DRotation(sussyList[index].x + x, sussyList[index].y + y, sussyList[index].z + z, testAngleHor, testAngleVer);
            project3Dto2D point = math.project3Dto2D(rotation.x,rotation.y,rotation.z);
            if (!point.behind) {
                sussy2DArray[index] = point;
            }
        }
        Polygon topFace = new Polygon(), leftFace = new Polygon(), rightFace = new Polygon(), bottomFace = new Polygon(), frontFace = new Polygon(), backFace = new Polygon();
        topFace.addPoint((int) sussy2DArray[4].screenx, (int) sussy2DArray[4].screeny);
        topFace.addPoint((int) sussy2DArray[5].screenx, (int) sussy2DArray[5].screeny);
        topFace.addPoint((int) sussy2DArray[6].screenx, (int) sussy2DArray[6].screeny);
        topFace.addPoint((int) sussy2DArray[7].screenx, (int) sussy2DArray[7].screeny);
        brush.setColor(Color.GREEN);
        brush.drawPolygon(topFace);

        //System.out.println("block is drawing. one point is at " + sussy2DArray[0].screenx + " " + sussy2DArray[0].screeny);
    }


    public Block(double x, double y, double z, double Hardness, String id){
        this.x = x;
        this.y = y;
        this.z = z;
        this.Hardness = Hardness;
        this.id = "amoguscraft:" + id;
    }
    void printName(){
        System.out.println(id);
    }
}
