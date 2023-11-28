import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Drawing extends JPanel {
    private Color currentColor;
    private Figure currentFigure;
    private ArrayList<Figure> figures;

    public Drawing() {
        this.setBackground(Color.white);
        this.currentColor = Color.black;
        this.currentFigure = new Rectangle(Color.black, 0, 0); // Default to Rectangle
        this.figures = new ArrayList<>();
    }

    // Setter method for currentColor
    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    // Setter method for currentFigure
    public void setCurrentFigure(Figure figure) {
        this.currentFigure = figure;
    }
}
