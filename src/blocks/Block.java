package blocks;

import Rendering.math;
import Rendering.point;
import Rendering.point3DRotation;
import Rendering.project3Dto2D;
import player.Player;

import java.awt.*;

public class Block {
    public double x;
    public double y;
    public double z;
    private double hardness;

    Color top = new Color(218, 247, 166),
            bottom = new Color(34,139,34),
            front = new Color(255, 87, 51),
            back = new Color(255, 87, 51),
            left = new Color(199, 0, 57),
            right = new Color(144, 12, 63);
    point[] sussyList = new point[]{
            new point(0, 0, 0, 0),
            new point(0, 0, 1, 0),
            new point(1, 0, 1, 0),
            new point(1, 0, 0, 0),
            new point(0, 1, 0, 0),
            new point(0, 1, 1, 0),
            new point(1, 1, 1, 0),
            new point(1, 1, 0, 0)
    };
    String id;
    boolean isVisible;

    /**
    * Calculates the distance between this block and the player
    *
    * @param player the player to get the distance from
     * @return the distance from that player calculated using the distance formula
    */
    public double distanceTo(Player player){
        double deltaX = x - (int) player.x;
        double deltaY = y - (int) player.y;
        double deltaZ = z - (int) player.z;

        return Math.sqrt(deltaX*deltaX + deltaY*deltaY + deltaZ*deltaZ);
    }

    public void pointRendering(Player player, double testAngleHor, double testAngleVer, Graphics brush) {
        project3Dto2D[] sussy2DArray = new project3Dto2D[8];
        point3DRotation[] sussy3DArray = new point3DRotation[8];

        // we'll be optimistic and assume that the block is visible
        // but if something in the for loop shows that the block is behind player,
        // this will be set to false
        isVisible = true;

        // loop through all 8 points
        for (int index = 0; index < sussyList.length; index += 1) {
            // rotate the point based on the player's rotation (x and y)
            point3DRotation rotation = math.point3DRotation(
                    sussyList[index].x + x - player.x,
                    sussyList[index].y + y - player.y,
                    sussyList[index].z + z - player.z,
                    testAngleHor, testAngleVer);
            sussy3DArray[index] = rotation;

            // is the point visible?
            if (rotation.x > 0) {
                // yes, we can proceed to project it
                project3Dto2D pointforpoly = math.project3Dto2D(rotation.x, rotation.y, rotation.z);
                sussy2DArray[index] = pointforpoly;
            } else {
                // no; in this case, don't draw the whole block
                isVisible = false;
            }

        }

        Polygon topFace = new Polygon(), leftFace = new Polygon(), rightFace = new Polygon(), bottomFace = new Polygon(), backFace = new Polygon(), frontFace = new Polygon();
        if (isVisible) {
            if (sussyList[4].y + y - player.y <= 0) {
                topFace.addPoint((int) sussy2DArray[4].screenx, (int) sussy2DArray[4].screeny);
                topFace.addPoint((int) sussy2DArray[5].screenx, (int) sussy2DArray[5].screeny);
                topFace.addPoint((int) sussy2DArray[6].screenx, (int) sussy2DArray[6].screeny);
                topFace.addPoint((int) sussy2DArray[7].screenx, (int) sussy2DArray[7].screeny);
                brush.setColor(bottom);
                brush.fillPolygon(topFace);
            }
            if (sussyList[0].y + y - player.y >= 0) {
                bottomFace.addPoint((int) sussy2DArray[0].screenx, (int) sussy2DArray[0].screeny);
                bottomFace.addPoint((int) sussy2DArray[1].screenx, (int) sussy2DArray[1].screeny);
                bottomFace.addPoint((int) sussy2DArray[2].screenx, (int) sussy2DArray[2].screeny);
                bottomFace.addPoint((int) sussy2DArray[3].screenx, (int) sussy2DArray[3].screeny);
                brush.setColor(top);
                brush.fillPolygon(bottomFace);
            }
            if (sussyList[7].x + x - player.x <= 0) {
                backFace.addPoint((int) sussy2DArray[7].screenx, (int) sussy2DArray[7].screeny);
                backFace.addPoint((int) sussy2DArray[3].screenx, (int) sussy2DArray[3].screeny);
                backFace.addPoint((int) sussy2DArray[2].screenx, (int) sussy2DArray[2].screeny);
                backFace.addPoint((int) sussy2DArray[6].screenx, (int) sussy2DArray[6].screeny);
                brush.setColor(back);
                brush.fillPolygon(backFace);
            }
            if (sussyList[4].x + x - player.x >= 0) {
                frontFace.addPoint((int) sussy2DArray[4].screenx, (int) sussy2DArray[4].screeny);
                frontFace.addPoint((int) sussy2DArray[0].screenx, (int) sussy2DArray[0].screeny);
                frontFace.addPoint((int) sussy2DArray[1].screenx, (int) sussy2DArray[1].screeny);
                frontFace.addPoint((int) sussy2DArray[5].screenx, (int) sussy2DArray[5].screeny);
                brush.setColor(front);
                brush.fillPolygon(frontFace);
            }
            if (sussyList[4].z + z - player.z >= 0) {
                leftFace.addPoint((int) sussy2DArray[4].screenx, (int) sussy2DArray[4].screeny);
                leftFace.addPoint((int) sussy2DArray[7].screenx, (int) sussy2DArray[7].screeny);
                leftFace.addPoint((int) sussy2DArray[3].screenx, (int) sussy2DArray[3].screeny);
                leftFace.addPoint((int) sussy2DArray[0].screenx, (int) sussy2DArray[0].screeny);
                brush.setColor(left);
                brush.fillPolygon(leftFace);
            }
            if (sussyList[5].z + z - player.z <= 0){
                rightFace.addPoint((int) sussy2DArray[5].screenx, (int) sussy2DArray[5].screeny);
                rightFace.addPoint((int) sussy2DArray[6].screenx, (int) sussy2DArray[6].screeny);
                rightFace.addPoint((int) sussy2DArray[2].screenx, (int) sussy2DArray[2].screeny);
                rightFace.addPoint((int) sussy2DArray[1].screenx, (int) sussy2DArray[1].screeny);
                brush.setColor(right);
                brush.fillPolygon(rightFace);
            }
        }
    }

    public Block(double x, double y, double z, double Hardness, String id){
        this.x = x;
        this.y = y;
        this.z = z;
        this.hardness = Hardness;
        this.id = "amoguscraft:" + id;
    }
    void printName(){
        System.out.println(id);
    }

    public double getHardness() {
        return hardness;
    }

    public void setHardness(double hardness) {
        if(hardness > 0){
            this.hardness = hardness;
        }else{
            throw new IllegalArgumentException("hardness must be greater than 0 and less than bedrock");
        }
    }

}
