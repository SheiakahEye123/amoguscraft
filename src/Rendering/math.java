package Rendering;

import Rendering.point3DRotation;
import Rendering.project3Dto2D;

public class math {
    public static point3DRotation point3DRotation(double x, double y, double z, double horangle, double verangle) {
        //leftright rot
        double newZ = z * Math.cos(horangle) - x * Math.sin(horangle);
        double newX = z * Math.sin(horangle) + x * Math.cos(horangle);
        //updown rot
        double newnewY = y * Math.cos(verangle) - newX * Math.sin(verangle);
        newX = y * Math.sin(verangle) + newX * Math.cos(verangle);
        point3DRotation returnPoint = new point3DRotation(newX,newnewY,newZ);
        return returnPoint;
    }


    public static project3Dto2D project3Dto2D(double x, double y, double z) {
        project3Dto2D returnPoint = new project3Dto2D();
        if(Math.abs(x) < 1e-4)
            x = 0.0001;
        double screeny = (y/x) * 300 + 250;
        double screenx = (z/x) * 300 + 250;
        returnPoint.screenx = screenx;
        returnPoint.screeny = screeny;
        return returnPoint;
    }
}
