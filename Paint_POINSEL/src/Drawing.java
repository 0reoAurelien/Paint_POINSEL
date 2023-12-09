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
    private Figure preview;
    protected static ArrayList<Figure> figures;
    //protected static Figure[] figures;
    protected static boolean isDrawing = false;
    private boolean isSaved;
    private int selectedFigure;

    public Drawing() {
        this.setBackground(Color.white);
        currentColor = Color.black;
        currentFigure = new Rectangle(Color.black, 0, 0); // Rectangle par défaut
        preview = new Rectangle(Color.black, 0, 0); // Rectangle par défaut
        figures = new ArrayList<>();
        isSaved = false;
        selectedFigure = -1;
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

        try {
            // Création d'un dossier de sauvegarde s'il n'existe pas encore
            File folder = new File("drawingFolder");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Création du fichier qui contiendra la sauvegarde
            FileOutputStream fos = new FileOutputStream("drawingFolder"+File.separator+"saveDrawing");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Ecriture dans le fichier de la taille de la liste de figures
            oos.writeInt(figures.size());
            System.out.println("\n\ncp 1\n\n");
            // Ecriture dans le fichier de la liste des figures

            for (Figure f : figures) {
                oos.writeObject(f);
            }
            oos.close(); // fin d'écriture dans le fichier
            isSaved = true;
        }
        catch (Exception e) {
            //e.printStackTrace(); // Affiche la trace de la pile dans la console
            throw new Exception(e); // Renvoie une exception qui sera traitée dans la classe Window.java
        }
    }


    public void loadFromFile() throws RuntimeException {
        figures.clear(); // l'importation écrase le dessin actuel

        try {

            FileInputStream fis = new FileInputStream("drawingFolder"+File.separator+"saveDrawing");

            ObjectInputStream ois = new ObjectInputStream(fis);

            int size = ois.readInt();
            for (int i = 0; i < size; i++) {
                Figure fig = (Figure) ois.readObject();
                figures.add(fig);
            }
            repaint();
            isSaved = true;
        }
        catch (Exception e) {
            throw new RuntimeException("Error loading from file", e);
        }
    }

    public void clearFile() {
        figures.clear();
        repaint();
    }


    boolean isEmpty() {
        return (figures.isEmpty());
    }

    boolean isSaved() {
        return isSaved;
    }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        for (Figure fig : figures) {
            fig.draw(g);
        }
        if (isDrawing) {
            preview.draw(g);
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
        //System.out.println("The user selected " + e.getPoint());
        int mouseX = e.getX();
        int mouseY = e.getY();
        if(!isDrawing) {
            this.currentFigure = this.currentFigure.createCopy(this.currentColor, new Point(mouseX, mouseY));
            figures.add(this.currentFigure);
            isDrawing = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("The user selected " + e.getPoint());
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (isDrawing){
            this.currentFigure.setBoundingBox(mouseX, mouseY);
            figures.add(this.currentFigure);
            isSaved = false;
            preview = new Rectangle(Color.black, 0, 0);
            repaint();
            isDrawing = false;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        int mouseX = e.getX();
        int mouseY = e.getY();

        if (isDrawing){
            this.preview = this.currentFigure.createCopy();
            this.preview.setBoundingBox(mouseX, mouseY);
            repaint();
        }


    }


    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
/*
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (isDrawing){
            //this.currentFigure.setBoundingBox(mouseX, mouseY);
            //this.figures.add(this.currentFigure);
            repaint();

        }
        */
    }

}
