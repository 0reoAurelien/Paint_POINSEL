import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serial;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Drawing extends JPanel implements MouseListener {
    private Color currentColor;
    private Figure currentFigure;
    private ArrayList<Figure> figures;
    protected static boolean isDrawing = false;

    public Drawing() {
        this.setBackground(Color.white);
        currentColor = Color.black;
        currentFigure = new Rectangle(Color.black, 0, 0); // Rectangle par défaut
        this.figures = new ArrayList<>();
    }

    public void setCurrentColor(Color color) { //Action liée aux boutons de couleurs
        currentColor = color;
    }

    public Color getColor() {
        return currentColor;
    }

    public void setCurrentFigure(Figure figure) { //Action liée aux boutons de figures
        currentFigure = figure;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Figure figure : figures) {
            figure.draw(g);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("The user clicked " + e.getPoint());
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (isDrawing){
            this.currentFigure.setBoundingBox(mouseX, mouseY);
            this.figures.add(this.currentFigure);
            repaint();
        }
        else{
            this.currentFigure = this.currentFigure.createCopy(this.currentColor, new Point(mouseX, mouseY));
        }
        isDrawing = !isDrawing;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
