package paintBrushApplet;

import java.awt.Graphics;

public class MyRect extends MyShape {
    private int x2;
    private int y2;
    private int w,h;
    protected int newx1 , newy1;
    
    public void calculateDimension()
    {
        if (x2 > getx1() && y2 > gety1())
        {
            w = x2 - getx1();
            h = y2 - gety1();
            newx1 = getx1();
            newy1 = gety1();
        }
        if (x2 < getx1() && y2 > gety1())
        {
            w = getx1() - x2;
            h = y2 - gety1();
            newx1 = x2 ;
            newy1 = gety1();
        }
        if (x2 < getx1() && y2 < gety1())
        {
            w = getx1() - x2;
            h = gety1() - y2;
            newx1 = x2;
            newy1 = y2;
        }
        if (x2 > getx1() && y2 < gety1())
        {
            w = x2 - getx1();
            h = gety1() - y2;
            newy1 = y2;
            newx1 = getx1();
        }
    }
    
    public void setx2(int x2)
    {
        this.x2 = x2;
    }
    public void sety2 (int y2)
    {
        this.y2 = y2;
    }
    public int getw()
    {
        return w;
    }
    public int geth()
    {
        return h;
    }
    
     @Override
    public void draw(Graphics g) {
        calculateDimension();
        g.setColor(getcolor());
        if (getFill())
            g.fillRect(newx1, newy1, w, h);
        else
            g.drawRect(newx1, newy1, w, h);
    }
    
}