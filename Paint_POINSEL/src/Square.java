
import java.awt.*;
import java.io.Serializable;

public class Square extends Rectangle implements Serializable {

    private int side;
    public Square(Color color, int px, int py) {
        super(color, px, py);
    }

    //int min(int a, int b){return (a>b)?b:a;}

    @Override
    public void setBoundingBox(int mouseX, int mouseY) {
        sortCoordinates();
        // On impose une forme carrée en ne retenant que la longueur du côté de carré
        // Pour des tracés plus précis avec la souris, on pourra choisir de garder le plus petit coté
        int w = mouseX-this.getOrigin().getX();
        int h = mouseY-this.getOrigin().getY();
        //side = Math.min(Math.abs(h), Math.abs(w));
        side = Math.max(Math.abs(h), Math.abs(w)); //Pour un meilleur visuel, choix temporaire du maximum plutot que du minimum
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
    public Figure createCopy(Color c, Point p) {
        Square copy = new Square(c, p.getX(),p.getY());
        return copy;
    }
    public Figure createCopy() {
        Square copy = new Square(this.getColor(), this.getOrigin().getX(),this.getOrigin().getY());
        return copy;
    }
}
