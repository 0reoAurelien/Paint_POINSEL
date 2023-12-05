
import java.awt.*;

public class Square extends Rectangle {

    private int side;
    public Square(Color color, int px, int py) {
        super(color, px, py);
    }

    //int min(int a, int b){return (a>b)?b:a;}

    @Override
    public void setBoundingBox(int mouseX, int mouseY) {
        sortCoordinates();
        // On impose une forme carrée en ne retenant que la longueur du côté
        // Pour des tracés plus précis avec la souris, on choisit de garder le plus petit coté
        int h = mouseX-this.getOrigin().getX();
        int w = mouseY-this.getOrigin().getY();
        //side = Math.min(h, w);
        side = Math.max(Math.abs(h), Math.abs(w)); //Pour un meilleur visuel, on garde temporairement le maximum plutot que le minimum
        this.height = (h>0)?side:-side;
        this.width = (w>0)?side:-side;
        sortCoordinates();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(this.getOrigin().getX(), this.getOrigin().getY(), width, height);
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
