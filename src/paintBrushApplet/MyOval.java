
package paintBrushApplet;

import java.awt.Graphics;


public class MyOval extends MyRect{
    @Override
    public void draw(Graphics g) {
        calculateDimension();
        g.setColor(getcolor());
        if (getFill())
            g.fillOval(newx1, newy1, getw(), geth());
        else
            g.drawOval(newx1, newy1, getw(), geth());
    }
    
    
}
