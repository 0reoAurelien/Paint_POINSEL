import java.awt.*;

public class Ellipse extends Figure {

    protected int diameter;

    public Ellipse(Color color, int px, int py, int diameter) {
        super(color, new Point(px, py));
        setBoundingBox(0, 0);
        this.diameter = diameter;
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {

    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public double getPerimeter() {
        /*
        Approximation 1: This approximation is within about 5% of the true value, so long as the width is not more than 3 times longer than the length (in other words, the ellipse is not too “squashed”):

        p ≈ 2 π √(a2+b2)/2

        Approximation 2: The famous Indian mathematician Ramanujan came up with this better approximation:

        p ≈ π(a+b)(1+3h/(10+√(4-3h)))

        Approximation 3: Ramanujan also came up with this one. First we calculate “h”:

        h = (a-b)2/(a+b)2

        Then use it here:

        p ≈ π(a+b)(1+h/4)
        */
        return 1;
    }

    @Override
    public double getSurface() {
        //je ne sais plus en fait
        return 1;
    }


}
