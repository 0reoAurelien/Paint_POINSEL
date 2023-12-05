import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

// bibliothèques pour sauvegarder le fichier
import java.util.ArrayList;
import java.util.List;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener {
    private Color currentColor;
    private Figure currentFigure;
    protected ArrayList<Figure> figures;
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

    public void saveToFile() throws Exception {
        /*
        File folder = new File("/drawingFolder");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        */
        // Pas encore réussi à créer un dossier de sauvegarde automatiquement

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("drawingFolder\\sauveDessin"))) {
            oos.writeInt(figures.size());
            for (Figure f : figures) {
                oos.writeObject(f);
            }
        }
    }


    public void loadFromFile() throws RuntimeException {
        figures.clear(); // l'importantion écrase le dessin actuel

        try (
                FileInputStream fis = new FileInputStream("/drawingFolder/sauveDessin");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            int size = ois.readInt();
            for (int i = 0; i < size; i++) {
                Figure fig = (Figure) ois.readObject();
                figures.add(fig);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error loading from file", e);
        }

        repaint();
    }

    public void clearFile() {
        figures.clear(); // l'importantion écrase le dessin actuel
        repaint();
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
        /*
        System.out.println("The user clicked " + e.getPoint());
        int mouseX = e.getX();
        int mouseY = e.getY();
        if (!isDrawing){
            this.currentFigure = this.currentFigure.createCopy(this.currentColor, new Point(mouseX, mouseY));
        }
        isDrawing = !isDrawing;

         */
        // not compatible yet with a mouse drag
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("The user clicked " + e.getPoint());
        int mouseX = e.getX();
        int mouseY = e.getY();
        if(!isDrawing) {
            this.currentFigure = this.currentFigure.createCopy(this.currentColor, new Point(mouseX, mouseY));
            isDrawing = true;
        }
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
            isDrawing = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("The user clicked " + e.getPoint());
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (isDrawing){
            this.currentFigure.setBoundingBox(mouseX, mouseY);
            this.figures.add(this.currentFigure);
            repaint();
        }
    }


    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
