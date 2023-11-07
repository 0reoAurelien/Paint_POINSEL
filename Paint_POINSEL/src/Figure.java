import javax.swing.*;
import java.awt.*;

public abstract class Figure {
    protected Color color;
    protected final Point origin;
    protected float width;
    protected float length;
    protected int[] boundingBox;

    /*
    public Figure() {
        this.color = new Color(0,0,0); //un entier entre 0 et 255 est donné pour chaque couleur RGB
        this.origin = new Point();
    }
    */

    public Figure(Color color, Point origin) {
        this.color = color;
        this.origin = origin;
    }


    public abstract void setBoundingBox (int heightBB, int widthBB);

    public abstract void draw (Graphics g);
    public abstract double getPerimeter ();
    public abstract double getSurface ();

}
