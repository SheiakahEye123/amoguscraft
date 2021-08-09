package blocks;

import java.awt.*;

public class dirt extends Block {
    public dirt(double x, double y, double z) {
        super(x, y, z, 0.5, "blocks.dirt");
        top = (new Color(0,74,0));
        bottom = (new Color(139,69,19));
        front = (new Color(139,69,19));
        back = (new Color(139,69,19));
        left = (new Color(139,69,19));
        right = (new Color(139,69,19));
    }
}
