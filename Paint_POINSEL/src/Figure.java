import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable {
    private final Color color;  //this.color = new Color(0,0,0); // un entier entre 0 et 255 pour chaque couleur RGB
    protected final Point origin;
    protected int width;
    protected int height;


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
    public void sortCoordinates(){  //modifie Origin pour avoir toujours Height et Width positives
        if (this.width<0) {
            this.width= -this.width;
            this.origin.setX(this.origin.getX()-width);
        }
        if (this.height<0) {
            this.height= -this.height;
            this.origin.setY(this.origin.getY()-height);
        }
    }
    public abstract void setBoundingBox (int mouseX, int mouseY);

    public abstract void draw (Graphics g);


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

    public abstract double getPerimeter();
    public abstract double getSurface();

}
