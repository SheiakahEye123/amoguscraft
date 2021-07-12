public class math {
    static project3Dto2D project3Dto2D (double x, double y, double z) {
        double screeny = y/x;
        double screenx = z/x;
        project3Dto2D returnpoint = new project3Dto2D();
        returnpoint.screenx = screenx;
        returnpoint.screeny = screeny;
        return returnpoint;
    }
}
