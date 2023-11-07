import javax.swing.*;
import java.awt.*;

public class Rectangle extends Figure {

    public Rectangle(Color color, Point origin) {
        super(color, origin);
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        this.boundingBox = new int[]{this.origin.getX() + heightBB, this.origin.getY() + widthBB};
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public double getPerimeter() {
        return 2*this.width + 2*this.length;
    }

    @Override
    public double getSurface() {
        return this.width * this.length;
    }


}
