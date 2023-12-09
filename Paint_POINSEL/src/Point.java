import java.io.Serializable;

public class Point implements Serializable {
    private int X;
    private int Y;

    public Point() {
        this.X = 0;
        this.Y = 0;
    }

    public Point(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int x) {
        this.X = x;
    }

    public void setY(int y) {
        this.Y = y;
    }

    @Override
    public String toString() {
        return "(" + this.X + ", " + this.Y + ")";
    }
}
