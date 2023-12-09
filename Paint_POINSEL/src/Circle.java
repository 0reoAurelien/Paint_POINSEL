import java.awt.*;
import java.io.Serializable;


public class Circle extends Ellipse implements Serializable {

    int radius;
    public Circle(Color color, int px, int py) {
        super(color, px, py);
    }

    //int min(int a, int b){return (a>b)?b:a;}

    @Override
    public void setBoundingBox(int mouseX, int mouseY) {
        // On impose une forme de cercle en ne retenant que le diamètre
        // Pour des tracés plus précis avec la souris, on pourra choisir de garder le plus petit coté

        int h = Math.abs(mouseX-this.getOrigin().getX());
        int w = Math.abs(mouseY-this.getOrigin().getY());
        //radius = Math.min(h, w);
        radius = Math.max(h, w); //Pour un meilleur visuel, choix temporaire du maximum plutot que du minimum

        this.origin.setX(this.origin.getX()-radius);
        this.origin.setY(this.origin.getY()-radius);
        this.height = 2*radius;
        this.width = 2*radius;

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(this.getOrigin().getX(), this.getOrigin().getY(), width, height);
    }

    @Override
    public Figure createCopy(Color c, Point p) {
        Circle copy = new Circle(c, p.getX(),p.getY());
        return copy;
    }
    public Figure createCopy() {
        Circle copy = new Circle(this.getColor(), this.getOrigin().getX(),this.getOrigin().getY());
        return copy;
    }
}
