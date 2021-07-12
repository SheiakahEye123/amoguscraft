public class math {
    static point3DRotation point3DRotation(double x, double y, double z, double angle) {
        double newZ = z * Math.cos(angle) - x * Math.sin(angle);
        double newX = z * Math.sin(angle) + x * Math.cos(angle);
        point3DRotation returnPoint = new point3DRotation();
        returnPoint.x = newX;
        returnPoint.y = y;
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
