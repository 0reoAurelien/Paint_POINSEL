import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Drawing extends JPanel {
    private Color currentColor;
    private Figure currentFigure;
    private ArrayList<Figure> figures;

    public Drawing() {
        this.setBackground(Color.white);
        this.currentColor = Color.black;
        this.currentFigure = new Rectangle(Color.black, 0, 0); // Rectangle par défaut
        this.figures = new ArrayList<>();

        addMouseListener(new MyMouseListener());

    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    public Color getColor() {
        return this.currentColor;
    }

    public void setCurrentFigure(Figure figure) {
        this.currentFigure = figure;
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("L'utilisateur a cliqué sur " + e.getPoint());
            int mouseX = e.getX();
            int mouseY = e.getY();
            Figure newFigure = currentFigure.createCopy(currentColor, new Point(mouseX, mouseY));

            figures.add(newFigure);

            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Figure figure : figures) {
            figure.draw(g);
        }
    }
}
