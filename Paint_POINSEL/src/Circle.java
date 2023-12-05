import java.awt.*;


public class Circle extends Ellipse {

    int radius;
    public Circle(Color color, int px, int py) {
        super(color, px, py);
    }

    //int min(int a, int b){return (a>b)?b:a;}

    @Override
    public void setBoundingBox(int mouseX, int mouseY) {
        // On impose une forme de cercle en ne retenant que le diamètre
        // Pour des tracés plus précis avec la souris, on choisit de garder le plus petit coté

        int h = Math.abs(mouseX-this.getOrigin().getX());
        int w = Math.abs(mouseY-this.getOrigin().getY());
        //radius = Math.min(h, w);
        radius = Math.max(h, w); //Pour un meilleur visuel, on garde temporairement le maximum plutot que le minimum

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
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getSurface() {
        return Math.PI * radius * radius;
    }

    @Override
    public Figure createCopy(Color c, Point p) {
        Circle copy = new Circle(c, p.getX(),p.getY());
        return copy;
    }
}
