package blocks;

import java.awt.*;

public class stone extends Block {
    public stone(double x, double y, double z) {
        super(x, y, z, 2, "blocks.stone");
        top = new Color(139, 140, 141);
        bottom =  top.darker().darker();
        front =   top.darker();
        back =    top.darker().darker();
        left =    top.darker();
        right =   top.darker().darker();
    }

}
