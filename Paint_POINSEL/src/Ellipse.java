import java.awt.*;

public class Ellipse extends Figure {


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
