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
            new point(0, 7, 0, 0),
            new point(0, 7, 6, 0),
            new point(6, 7, 6, 0),
            new point(6, 7, 0, 0),
            new point(0, 1, 0, 0),
            new point(0, 1, 6, 0),
            new point(6, 1, 6, 0),
            new point(6, 1, 0, 0)
    };
    String id;
    boolean localbehind;

    public void pointRendering(double testAngleHor, double testAngleVer, Graphics brush) {
        project3Dto2D[] sussy2DArray = new project3Dto2D[8];

        for (int index = 0; index < sussyList.length; index += 1) {
            point3DRotation rotation = math.point3DRotation(sussyList[index].x + x, sussyList[index].y + y, sussyList[index].z + z, testAngleHor, testAngleVer);
            project3Dto2D pointforpoly = math.project3Dto2D(rotation.x,rotation.y,rotation.z);
            sussy2DArray[index] = pointforpoly;
            if (x > 0) {
                localbehind = false;
            }
            else if (x <= 0) {
                localbehind = true;
            }
        }
        Polygon topFace = new Polygon(), leftFace = new Polygon(), rightFace = new Polygon(), bottomFace = new Polygon(), backFace = new Polygon(), frontFace = new Polygon();
        topFace.addPoint((int) sussy2DArray[4].screenx, (int) sussy2DArray[4].screeny);
        topFace.addPoint((int) sussy2DArray[5].screenx, (int) sussy2DArray[5].screeny);
        topFace.addPoint((int) sussy2DArray[6].screenx, (int) sussy2DArray[6].screeny);
        topFace.addPoint((int) sussy2DArray[7].screenx, (int) sussy2DArray[7].screeny);
        brush.setColor(new Color(102,51,0));
        if (!localbehind) {
            brush.fillPolygon(topFace);
        }
        else if (localbehind) {
        }

        bottomFace.addPoint((int) sussy2DArray[0].screenx, (int) sussy2DArray[0].screeny);
        bottomFace.addPoint((int) sussy2DArray[1].screenx, (int) sussy2DArray[1].screeny);
        bottomFace.addPoint((int) sussy2DArray[2].screenx, (int) sussy2DArray[2].screeny);
        bottomFace.addPoint((int) sussy2DArray[3].screenx, (int) sussy2DArray[3].screeny);
        brush.setColor(new Color(102,51,0));
        if (!localbehind) {
            brush.fillPolygon(bottomFace);
        }
        else if (localbehind) {
        }
        backFace.addPoint((int) sussy2DArray[7].screenx, (int) sussy2DArray[7].screeny);
        backFace.addPoint((int) sussy2DArray[3].screenx, (int) sussy2DArray[3].screeny);
        backFace.addPoint((int) sussy2DArray[2].screenx, (int) sussy2DArray[2].screeny);
        backFace.addPoint((int) sussy2DArray[6].screenx, (int) sussy2DArray[6].screeny);
        brush.setColor(new Color(102,51,0));
        if (!localbehind) {
            brush.fillPolygon(backFace);
        }
        else if (localbehind) {
        }
        frontFace.addPoint((int) sussy2DArray[4].screenx, (int) sussy2DArray[4].screeny);
        frontFace.addPoint((int) sussy2DArray[0].screenx, (int) sussy2DArray[0].screeny);
        frontFace.addPoint((int) sussy2DArray[1].screenx, (int) sussy2DArray[1].screeny);
        frontFace.addPoint((int) sussy2DArray[5].screenx, (int) sussy2DArray[5].screeny);
        brush.setColor(new Color(102,51,0));
        if (!localbehind) {
            brush.fillPolygon(frontFace);
        }
        else if (localbehind) {
        }
        leftFace.addPoint((int) sussy2DArray[4].screenx, (int) sussy2DArray[4].screeny);
        leftFace.addPoint((int) sussy2DArray[7].screenx, (int) sussy2DArray[7].screeny);
        leftFace.addPoint((int) sussy2DArray[3].screenx, (int) sussy2DArray[3].screeny);
        leftFace.addPoint((int) sussy2DArray[0].screenx, (int) sussy2DArray[0].screeny);
        brush.setColor(new Color(102,51,0));
        if (!localbehind) {
            brush.fillPolygon(leftFace);
        }
        else if (localbehind) {
        }
        rightFace.addPoint((int) sussy2DArray[5].screenx, (int) sussy2DArray[5].screeny);
        rightFace.addPoint((int) sussy2DArray[6].screenx, (int) sussy2DArray[6].screeny);
        rightFace.addPoint((int) sussy2DArray[2].screenx, (int) sussy2DArray[2].screeny);
        rightFace.addPoint((int) sussy2DArray[1].screenx, (int) sussy2DArray[1].screeny);
        brush.setColor(new Color(102,51,0));
        if (!localbehind) {
            brush.fillPolygon(leftFace);
        }
        else if (localbehind) {
        }
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
