import java.awt.*;

public class Rectangle extends Figure {

    public Rectangle(Color color, int px, int py) {
        super(color, new Point(px, py));
        setBoundingBox(0, 0);
    }

    @Override
    public void setBoundingBox(int h, int w) {
        this.height=h;
        this.width=w;
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public double getPerimeter() {
        return 2*this.width + 2*this.height;
    }

    @Override
    public double getSurface() {
        return this.width * this.height;
    }


}
