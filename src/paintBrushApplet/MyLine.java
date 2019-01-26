
package paintBrushApplet;

import java.awt.Graphics;


public class MyLine extends MyShape {
    private int x2;
    private int y2;
    
    public void setx2(int x2)
    {
        this.x2 = x2;
    }
    public void sety2 (int y2)
    {
        this.y2 = y2;
    }
    
    
    @Override
    public void draw(Graphics g) {
        g.setColor(getcolor());
        g.drawLine(getx1(), gety1(), x2, y2);
    }
}
