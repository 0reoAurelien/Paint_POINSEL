import java.awt.*;


public class Circle extends Ellipse {

    private int diameter;
    public Circle(Color color, int px, int py, int d) {
        super(color, px, py);
        this.diameter = d;
        setBoundingBox(0, 0);
    }

    //int min(int a, int b){return (a>b)?b:a;}

    @Override
    public void setBoundingBox(int h, int w) {
        // On impose une forme de cercle en ne retenant que le diamètre
        // Pour des tracés plus précis avec la souris, on choisit de garder le plus petit coté
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

    @Override
    public Figure createCopy(Color c, Point p) {
        Circle copy = new Circle(c, p.getX(),p.getY(), 0);
        return copy;
    }
}
