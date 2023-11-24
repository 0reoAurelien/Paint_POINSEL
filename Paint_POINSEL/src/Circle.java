import java.awt.*;


public class Circle extends Ellipse {

    private int diameter;
    public Circle(Color color, int px, int py, int d) {
        super(color, px, py, d);
        setBoundingBox(0, 0);
    }

    //int min(int a, int b){return (a>b)?b:a;}

    @Override
    public void setBoundingBox(int h, int w) {
        // On impose une forme carrée en ne retenant que la longueur du côté
        diameter = Math.min(h, w);
        this.height = diameter;
        this.width = diameter;
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * diameter;
    }

    @Override
    public double getSurface() {
        return Math.PI * diameter * diameter / 4;
    }
}
