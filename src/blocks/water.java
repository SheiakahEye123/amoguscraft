package blocks;

import java.awt.*;

public class water extends Block {
    public water(double x, double y, double z) {
        super(x, y, z, 0, "blocks.water");
        top = new Color(0, 0, 139, 100);
        bottom = top;
        front = top;
        back = top;
        left = top;
        right = top;
    }
}

