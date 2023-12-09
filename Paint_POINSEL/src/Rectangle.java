import java.awt.*;
import java.io.Serializable;

public class Rectangle extends Figure implements Serializable {

    public Rectangle(Color color, int px, int py) {
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
        g.fillRect(this.getOrigin().getX(), this.getOrigin().getY(), width, height);
    }

    @Override
    public Figure createCopy(Color c, Point p) {
        Rectangle copy = new Rectangle(c, p.getX(),p.getY());
        return copy;
    }
    @Override
    public Figure createCopy() {
        Rectangle copy = new Rectangle(this.getColor(), this.getOrigin().getX(),this.getOrigin().getY());
        return copy;
    }


}
