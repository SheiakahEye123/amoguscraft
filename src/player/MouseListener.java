package player;

import Rendering.ModdedPanel;
import Rendering.point;
import blocks.Block;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseListener implements java.awt.event.MouseListener {
    ArrayList<Block> blocks = new ArrayList<>();
    public MouseListener(ArrayList<Block> points, ModdedPanel canvas) {
        this.blocks = points;
        this.canvas = canvas;
    }

    ModdedPanel canvas = new ModdedPanel(blocks);

    @Override
    public void mouseClicked(MouseEvent e) {
        //double mousex = e.getX();
        //double mousey = e.getY();
        //System.out.println(mousex + "//" + mousey);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
