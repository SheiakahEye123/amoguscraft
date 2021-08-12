package blocks;

import java.awt.*;

public class sand extends Block {
    public sand(int x, int y, int z) {
        super(x, y, z, 0.5, "blocks.sand");

        top =     new Color(194,178,128);
        bottom =  top.darker().darker();
        front =   top.darker();
        back =    top.darker().darker();
        left =    top.darker();
        right =   top.darker().darker();
    }
}
