
package paintBrushApplet;

import java.awt.Color;
import java.awt.Graphics;


public abstract class MyShape {
    private int x1;
    private int y1;
    private Color color;
    private boolean isFilled = false;
    
    public void setx1(int x1)
    {
        this.x1=x1;
    }
    public void sety1(int y1)
    {
        this.y1=y1;
    }
    public void setcolor(Color c)
    {
        this.color=c;
    }
    public void setFill (boolean isFilled)
    {
        this.isFilled = isFilled;
    }
    public int getx1()
    {
        return x1;
    }
    public int gety1()
    {
        return y1;
    }
    public Color getcolor()
    {
        return color;
    }
    public boolean getFill ()
    {
        return isFilled;
    }
            
    public abstract void draw(Graphics g);
}