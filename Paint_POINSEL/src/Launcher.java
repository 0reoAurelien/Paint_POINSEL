import javax.swing.*;

public class Launcher {

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            Window win = new Window("Paint it black", 1200, 1000);
        });
    }
}