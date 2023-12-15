import javax.swing.*;
import java.io.*;


public class FileManager extends File {
    private static final File folder = new File("DrawingsFolder");
    private static String currentFileName = "Drawing";
    private static String currentPath = folder.getAbsolutePath();
    private boolean isNew;

    public FileManager(String pathname) {
        super(pathname);
    }


    public static void quickSaveToFile() throws Exception {

        try {
            // Création d'un dossier général de sauvegarde s'il n'existe pas encore
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Création d'un dossier de sauvegarde rapide s'il n'existe pas encore
            File quickSaves = new File(folder,"QuickSaves");
            if (!quickSaves.exists()) {
                quickSaves.mkdirs();
            }

            // Création du fichier qui contiendra la sauvegarde
            String originFileName = "Drawing";
            File checkFile = new File(quickSaves.getAbsolutePath(), originFileName);
            int i = 1;
            while (checkFile.exists()){  // Trouver un nom approprié pour le fichier
                checkFile = new File(quickSaves.getAbsolutePath(), originFileName+i);
                i++;
            }
            currentFileName = checkFile.getName();
            //FileOutputStream fos = new FileOutputStream("drawingFolder"+File.separator+currentFileName);
            FileOutputStream fos = new FileOutputStream(checkFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Ecriture dans le fichier de la taille de la liste de figures
            oos.writeInt(Drawing.figures.size());

            // Ecriture dans le fichier de la liste des figures
            for (Figure f : Drawing.figures) {
                oos.writeObject(f);
            }
            oos.close(); // fin d'écriture dans le fichier
        }
        catch (Exception e) {
            throw new RuntimeException("Error saving file", e); // Renvoie une exception qui sera traitée dans la classe Window.java
        }
    }

    public static void loadFromFile() throws RuntimeException {

        Drawing.figures.clear(); // l'importation écrase le dessin actuel

        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(folder);
            // Afficher la boîte de dialogue de sélection de fichiers
            int result = fileChooser.showOpenDialog(null);
            File selectedFile = null;
            if (result == JFileChooser.APPROVE_OPTION) {
                // Utilisateur a sélectionné un fichier
                selectedFile = fileChooser.getSelectedFile();
                currentFileName = selectedFile.getName();
                currentPath = selectedFile.getAbsolutePath();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            }
            else {
                throw new RuntimeException("No file selected");
            }
            if (selectedFile==null){
                throw new RuntimeException("File not selected properly");
            }
            FileInputStream fis = new FileInputStream(selectedFile.getAbsolutePath());

            ObjectInputStream ois = new ObjectInputStream(fis);

            int size = ois.readInt();
            for (int i = 0; i < size; i++) {
                Figure fig = (Figure) ois.readObject();
                Drawing.figures.add(fig);
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Error loading from file", e);
        }
    }
}
