
import java.awt.*;

public class Square extends Rectangle {

    private int side;
    public Square(Color color, int px, int py) {
        super(color, px, py);
        setBoundingBox(0, 0);
    }

    //int min(int a, int b){return (a>b)?b:a;}

    @Override
    public void setBoundingBox(int h, int w) {
        // On impose une forme carrée en ne retenant que la longueur du côté
        // Pour des tracés plus précis avec la souris, on choisit de garder le plus petit coté
        side = Math.min(h, w);
        this.height = side;
        this.width = side;
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public double getPerimeter() {
        return 4*this.side;
    }

    @Override
    public double getSurface() {
        return this.side * this.side;
    }
    @Override
    public Figure createCopy(Color c, Point p) {
        Square copy = new Square(c, p.getX(),p.getY());
        return copy;
    }
}
