import java.awt.*;
import java.io.Serializable;

public class Ellipse extends Figure implements Serializable {


    public Ellipse(Color color, int px, int py) {
        super(color, new Point(px, py));
    }

    @Override
    public void setBoundingBox(int mouseX, int mouseY) {
        this.width=mouseX-this.getOrigin().getX();
        this.height=mouseY-this.getOrigin().getY();
        sortCoordinates();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(this.getOrigin().getX(), this.getOrigin().getY(), width, height);
    }

    @Override
    public Figure createCopy(Color c, Point p) {
        Ellipse copy = new Ellipse(c, p.getX(),p.getY());
        return copy;
    }
    public Figure createCopy() {
        Ellipse copy = new Ellipse(this.getColor(), this.getOrigin().getX(),this.getOrigin().getY());
        return copy;
    }

}
