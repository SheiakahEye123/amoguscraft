public class math {
    static point3DRotation point3DRotation(double x, double y, double z, double horangle, double verangle) {
        double newZ = z * Math.cos(horangle) - x * Math.sin(horangle);
        double newX = z * Math.sin(horangle) + x * Math.cos(horangle);
        double newY = z * Math.sin(verangle) + x * Math.cos(verangle);
        point3DRotation returnPoint = new point3DRotation();
        returnPoint.x = newX;
        returnPoint.y = newY;
        returnPoint.z = newZ;
        return returnPoint;
    }
    static project3Dto2D project3Dto2D (double x, double y, double z) {
        double screeny = y/x;
        double screenx = z/x;
        project3Dto2D returnPoint = new project3Dto2D();
        returnPoint.screenx = screenx;
        returnPoint.screeny = screeny;
        return returnPoint;
    }
}
