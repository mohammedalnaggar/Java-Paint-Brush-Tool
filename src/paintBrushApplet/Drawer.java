package paintBrushApplet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Drawer extends Applet implements MouseListener, MouseMotionListener {

    Button lineBttn, rectBttn, ovalBttn, redBttn, greenBttn, blueBttn, eraseallBttn, eraser, undo;
    public Color colorSelected;
    public Color background;
    String shapeSelected;
    Checkbox checkbox;
    ArrayList<MyShape> shapesarr;
    public MyLine newline;
    public MyRect newrect;
    public MyOval newoval;

    public void init() {
        colorSelected = Color.BLACK;
        lineBttn = new Button("Line");
        rectBttn = new Button("Rectangle");
        ovalBttn = new Button("Oval");
        redBttn = new Button("Red color");
        greenBttn = new Button("Green color");
        blueBttn = new Button("Blue color");
        checkbox = new Checkbox("Fill");
        eraser = new Button("Eraser");
        eraseallBttn = new Button("Erase All");
        undo = new Button("Undo");
        redBttn.setBackground(Color.red);
        greenBttn.setBackground(Color.green);
        blueBttn.setBackground(Color.blue);
        add(lineBttn);
        add(rectBttn);
        add(ovalBttn);
        add(redBttn);
        add(greenBttn);
        add(blueBttn);
        add(eraseallBttn);
        add(checkbox);
        add(eraser);
        add(undo);
        shapesarr = new ArrayList<MyShape>();

        redBttn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        colorSelected = Color.RED;
                    }
                }
        );
        greenBttn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        colorSelected = Color.GREEN;
                    }
                }
        );
        blueBttn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        colorSelected = Color.BLUE;
                    }
                }
        );
        lineBttn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        shapeSelected = "Line";
                    }
                }
        );
        rectBttn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        shapeSelected = "Rect";
                    }
                }
        );
        ovalBttn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        shapeSelected = "Oval";
                    }
                }
        );
        eraser.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        shapeSelected = "Recteraser";
                    }
                }
        );
        eraseallBttn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        shapesarr.clear();
                        repaint();
                    }
                }
        );
        undo.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (!shapesarr.isEmpty()) {
                            shapesarr.remove(shapesarr.size() - 1);
                            repaint();
                        }
                    }
                }
        );

        addMouseMotionListener(this);
        addMouseListener(this);

        background = Drawer.this.getBackground();
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {

        if (shapeSelected == "Line") {
            newline = new MyLine();
            newline.setx1( e.getX());
            newline.sety1(e.getY());
            shapesarr.add(newline);

        } 
        if (shapeSelected == "Rect") {
            newrect = new MyRect();
            newrect.setx1( e.getX());
            newrect.sety1(e.getY());
            shapesarr.add(newrect);

        } 
        if (shapeSelected == "Oval") {
            newoval = new MyOval();
            newoval.setx1( e.getX());
            newoval.sety1(e.getY());
            shapesarr.add(newoval);

        } 
        if (shapeSelected == "Recteraser") {
            newrect = new MyRect();
            newrect.setx1( e.getX());
            newrect.sety1(e.getY());
            shapesarr.add(newrect);
        } 
        else {
            System.out.println("Nothing is selected");
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (shapeSelected == "Line") {
            newline.setx2 (e.getX());
            newline.sety2 (e.getY());
            newline.setcolor (colorSelected);
        }
        if (shapeSelected == "Rect") {
            newrect.setx2(e.getX());
            newrect.sety2(e.getY());
            newrect.setcolor(colorSelected);
            newrect.setFill(checkbox.getState());
        }
        if (shapeSelected == "Oval") {
            newoval.setx2(e.getX());
            newoval.sety2(e.getY());
            newoval.setcolor(colorSelected);
            newoval.setFill(checkbox.getState());
        }
        if (shapeSelected == "Recteraser") {
            newrect.setx2(e.getX());
            newrect.sety2(e.getY());
            newrect.setcolor(background);
            newrect.setFill(true);
        }
        repaint();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        if (shapeSelected == "Line") {
            newline.setx2 (e.getX());
            newline.sety2 (e.getY());
            newline.setcolor (colorSelected);
        }
        if (shapeSelected == "Rect") {
            newrect.setx2(e.getX());
            newrect.sety2(e.getY());
            newrect.setcolor(colorSelected);
            newrect.setFill(checkbox.getState());
        }
        if (shapeSelected == "Oval") {
            newoval.setx2(e.getX());
            newoval.sety2(e.getY());
            newoval.setcolor(colorSelected);
            newoval.setFill(checkbox.getState());
        }
        if (shapeSelected == "Recteraser") {
            newrect.setx2(e.getX());
            newrect.sety2(e.getY());
            newrect.setcolor(background);
            newrect.setFill(true);
        }
        repaint();

    }

    public void mouseMoved(MouseEvent e) {
    }

    public void paint(Graphics g) {
        for (int i = 0; i < shapesarr.size(); i++) {
            shapesarr.get(i).draw(g);
        }
    }
}