package player;

import Rendering.point3DRotation;

public class Player {
    public double x = 0, y = 0, z = 0, hor = 0, ver = 0;

    public void move(point3DRotation change){
        x += change.x;
        y += change.y;
        z += change.z;
    }
}
