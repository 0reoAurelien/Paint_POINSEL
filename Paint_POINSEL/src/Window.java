import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    private JPanel colorPanel;
    private JPanel figurePanel;
    private Drawing drawingPanel;


    public Window(String title, int x, int y) {
        super(title);
        this.setSize(x, y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawingPanel = new Drawing();
        Container contentPanel = this.getContentPane();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(drawingPanel, BorderLayout.CENTER);


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

        colorButton1.addActionListener(this);
        colorButton2.addActionListener(this);
        colorButton3.addActionListener(this);
        colorButton4.addActionListener(this);
        colorButton5.addActionListener(this);
        colorButton6.addActionListener(this);
        colorButton7.addActionListener(this);
        colorButton8.addActionListener(this);


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

        figureButton1.addActionListener(this);
        figureButton2.addActionListener(this);
        figureButton3.addActionListener(this);
        figureButton4.addActionListener(this);

        // Add southPanel to the SOUTH position
        contentPanel.add(southPanel, BorderLayout.SOUTH);

        JMenuBar m = new JMenuBar();

        JMenu menu1 = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem about = new JMenuItem("About/Authors");
        about.addActionListener(this);
        menu1.add(open);
        menu1.add(about);
        m.add(menu1);
        setJMenuBar(m);

        JButton okButton = new JButton("Que viva ENSEA !");
        contentPanel.add(okButton, BorderLayout.CENTER);

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "Change Figure":
                // Change the current figure in the Drawing panel
                // Example: drawingPanel.setCurrentFigure(new Rectangle(0, 0, Color.black));
                break;

            case "Change Color":
                // Change the current color in the Drawing panel
                // Example: drawingPanel.setCurrentColor(Color.RED);
                break;

            case "About/Authors":
                // Display an information popup
                JOptionPane.showMessageDialog(this,
                        "Authors:\nAurélien POINSEL\nIn collaboration with internet\nSpecial thanks to Tauvel and chatGPT",
                        "About/Authors",
                        JOptionPane.INFORMATION_MESSAGE);
                break;

            default:
                System.out.println("Button/Menu Action not handled: " + cmd);
        }
    }
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            Window win = new Window("Paint it black", 800, 600);
        });
    }
}



