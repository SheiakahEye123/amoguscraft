package Rendering;

public class point3DRotation {
    public double x;
    public double y;
    public double z;

    public void increaseBy(point3DRotation change){
        x += change.x;
        y += change.y;
        z += change.z;
    }

    public void decreaseBy(point3DRotation change){
        x -= change.x;
        y -= change.y;
        z -= change.z;
    }

    public point3DRotation(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
