package blocks;

import java.awt.*;

public class dirt extends Block {
    public dirt(int x, int y, int z) {
        super(x, y, z, 0.5, "blocks.dirt");

        top =       new Color(50,130,30);
        bottom =    new Color(100,69,29).darker();
        front =     new Color(100,69,29);
        back =      new Color(100,69,29).darker();
        left =      new Color(100,69,29);
    right =         new Color(100,69,29).darker();
    }
}
