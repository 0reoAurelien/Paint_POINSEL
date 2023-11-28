import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private JPanel colorPanel;
    private JPanel figurePanel;

    public Window(String title, int x, int y) {
        super(title);
        this.setSize(x, y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the southPanel
        Container southPanel = new Container();
        southPanel.setLayout(new GridLayout(1, 2));

        colorPanel = new JPanel();
        colorPanel.setLayout(new GridLayout(2, 4));
        // Add buttons to colorPanel
        JButton colorButton1 = new JButton("Color Button");
        JButton colorButton2 = new JButton("Color Button");
        JButton colorButton3 = new JButton("Color Button");
        JButton colorButton4 = new JButton("Color Button");
        JButton colorButton5 = new JButton("Color Button");
        JButton colorButton6 = new JButton("Color Button");
        JButton colorButton7 = new JButton("Color Button");
        JButton colorButton8 = new JButton("Color Button");
        colorPanel.add(colorButton1);
        colorPanel.add(colorButton2);
        colorPanel.add(colorButton3);
        colorPanel.add(colorButton4);
        colorPanel.add(colorButton5);
        colorPanel.add(colorButton6);
        colorPanel.add(colorButton7);
        colorPanel.add(colorButton8);
        southPanel.add(colorPanel);


        figurePanel = new JPanel();
        figurePanel.setLayout(new GridLayout(2, 2));
        // Add buttons to colorPanel
        JButton figureButton1 = new JButton("Figure Button");
        JButton figureButton2 = new JButton("Figure Button");
        JButton figureButton3 = new JButton("Figure Button");
        JButton figureButton4 = new JButton("Figure Button");
        figurePanel.add(figureButton1);
        figurePanel.add(figureButton2);
        figurePanel.add(figureButton3);
        figurePanel.add(figureButton4);
        southPanel.add(figurePanel);


        Container contentPanel = this.getContentPane();
        contentPanel.setLayout(new BorderLayout());

        // Add southPanel to the SOUTH position
        contentPanel.add(southPanel, BorderLayout.SOUTH);

        JMenuBar m = new JMenuBar();

        JMenu menu1 = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        menu1.add(open);
        m.add(menu1);
        setJMenuBar(m);

        JButton okButton = new JButton("Que viva ENSEA !");
        contentPanel.add(okButton, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            Window win = new Window("Paint it black", 800, 600);
        });
    }
}
