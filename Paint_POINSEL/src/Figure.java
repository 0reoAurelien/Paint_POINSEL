import java.awt.*;

public abstract class Figure {
    private final Color color;  //this.color = new Color(0,0,0); // un entier entre 0 et 255 pour chaque couleur RGB
    protected final Point origin;
    protected int width;
    protected int height;
    protected int perimeter;
    protected int area;

    public Figure(Color color, Point origin) {
        this.color = color;
        this.origin = origin;
    }
    public Color getColor() {
        return color;
    }
    public Point getOrigin() {
        return origin;
    }

    public abstract void setBoundingBox (int height, int width);


    public abstract void draw (Graphics g);
    public abstract double getPerimeter ();
    public abstract double getSurface ();

    @Override
    public String toString() {
        return "Figure{" +
                "color=" + color +
                ", origin=" + origin +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    public abstract Figure createCopy(Color color, Point origin);

}
