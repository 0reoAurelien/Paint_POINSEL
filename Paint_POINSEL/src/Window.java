import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener {
    private Drawing drawingPanel;


    public Window(String title, int x, int y) {
        super(title);
        this.setSize(900, 600);
        this.setMinimumSize(new Dimension(1200, 1000));  // Set the minimum size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configuration du contentPanel avec GridBagLayout
        Container contentPanel = getContentPane();
        contentPanel.setBackground(Color.BLACK);
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.NONE;

        // Configuration du drawingPanel
        drawingPanel = new Drawing();
        drawingPanel.setPreferredSize(new Dimension(900, 600));
        drawingPanel.setBackground(Color.WHITE);
        drawingPanel.addMouseListener(drawingPanel);

        // Ajout du drawingPanel au contentPanel
        contentPanel.add(drawingPanel, gbc);

        Container southPanel = new Container();
        southPanel.setBackground(Color.BLACK);
        southPanel.setLayout(new GridLayout(1, 2));

        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(Color.BLACK);
        colorPanel.setLayout(new GridLayout(2, 4));

        JButton colorButtonBlack = new JButton("Black");
        colorButtonBlack.setBackground(Color.BLACK);
        colorButtonBlack.setForeground(Color.WHITE);
        JButton colorButtonRed = new JButton("Red");
        colorButtonRed.setBackground(Color.RED);
        colorButtonRed.setForeground(Color.BLACK);
        JButton colorButtonGreen = new JButton("Green");
        colorButtonGreen.setBackground(Color.GREEN);
        colorButtonGreen.setForeground(Color.BLACK);
        JButton colorButtonBlue = new JButton("Blue");
        colorButtonBlue.setBackground(Color.BLUE);
        colorButtonBlue.setForeground(Color.BLACK);
        JButton colorButtonYellow = new JButton("Yellow");
        colorButtonYellow.setBackground(Color.YELLOW);
        colorButtonYellow.setForeground(Color.BLACK);
        JButton colorButtonPink = new JButton("Pink");
        colorButtonPink.setBackground(Color.PINK);
        colorButtonPink.setForeground(Color.BLACK);
        JButton colorButtonMagenta = new JButton("Magenta");
        colorButtonMagenta.setBackground(Color.MAGENTA);
        colorButtonMagenta.setForeground(Color.BLACK);
        JButton colorButtonOrange = new JButton("Orange");
        colorButtonOrange.setBackground(Color.ORANGE);
        colorButtonOrange.setForeground(Color.BLACK);

        colorPanel.add(colorButtonBlack);
        colorPanel.add(colorButtonRed);
        colorPanel.add(colorButtonGreen);
        colorPanel.add(colorButtonBlue);
        colorPanel.add(colorButtonYellow);
        colorPanel.add(colorButtonPink);
        colorPanel.add(colorButtonMagenta);
        colorPanel.add(colorButtonOrange);
        southPanel.add(colorPanel);

        colorButtonBlack.addActionListener(this);
        colorButtonRed.addActionListener(this);
        colorButtonGreen.addActionListener(this);
        colorButtonBlue.addActionListener(this);
        colorButtonYellow.addActionListener(this);
        colorButtonPink.addActionListener(this);
        colorButtonMagenta.addActionListener(this);
        colorButtonOrange.addActionListener(this);

        JPanel figurePanel = new JPanel();
        figurePanel.setLayout(new GridLayout(2, 2));

        JButton figureButtonRectangle = new JButton("Rectangle");
        JButton figureButtonSquare = new JButton("Square");
        JButton figureButtonEllipse = new JButton("Ellipse");
        JButton figureButtonCircle = new JButton("Circle");
        figurePanel.add(figureButtonRectangle);
        figurePanel.add(figureButtonSquare);
        figurePanel.add(figureButtonEllipse);
        figurePanel.add(figureButtonCircle);
        southPanel.add(figurePanel);

        figureButtonRectangle.addActionListener(this);
        figureButtonSquare.addActionListener(this);
        figureButtonEllipse.addActionListener(this);
        figureButtonCircle.addActionListener(this);


        // GridBagConstraints pour ajouter southPanel au contentPanel
        gbc.gridy = 1; // Set the row to 1 for southPanel
        gbc.fill = GridBagConstraints.BOTH;

        contentPanel.add(southPanel, gbc);

        JMenuBar m = new JMenuBar();

        JMenu menu1 = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem about = new JMenuItem("About/Authors");
        about.addActionListener(this);
        menu1.add(open);
        menu1.add(about);
        m.add(menu1);
        setJMenuBar(m);

/*
        JButton okButton = new JButton("Que viva ENSEA !");
        okButton.setPreferredSize(new Dimension(200, 50));
        contentPanel.add(okButton, BorderLayout.CENTER);
*/

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Drawing.isDrawing = false;
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "Rectangle":
                drawingPanel.setCurrentFigure(new Rectangle(drawingPanel.getColor(), 0, 0));
                System.out.println("The user picked a Rectangle");
                break;

            case "Square":
                drawingPanel.setCurrentFigure(new Square(drawingPanel.getColor(), 0, 0));
                System.out.println("The user picked a Square");
                break;

            case "Ellipse":
                drawingPanel.setCurrentFigure(new Ellipse(drawingPanel.getColor(), 0, 0));
                System.out.println("The user picked an Ellipse");
                break;

            case "Circle":
                drawingPanel.setCurrentFigure(new Circle(drawingPanel.getColor(), 0, 0));
                System.out.println("The user picked a Circle");
                break;

            case "Black":
                drawingPanel.setCurrentColor(Color.BLACK);
                System.out.println("The user selected the color Black");
                break;

            case "Red":
                drawingPanel.setCurrentColor(Color.RED);
                System.out.println("The user selected the color Red");
                break;

            case "Green":
                drawingPanel.setCurrentColor(Color.GREEN);
                System.out.println("The user selected the color Green");
                break;

            case "Blue":
                drawingPanel.setCurrentColor(Color.BLUE);
                System.out.println("The user selected the color Blue");
                break;

            case "Yellow":
                drawingPanel.setCurrentColor(Color.YELLOW);
                System.out.println("The user selected the color Yellow");
                break;

            case "Pink":
                drawingPanel.setCurrentColor(Color.PINK);
                System.out.println("The user selected the color Pink");
                break;

            case "Magenta":
                drawingPanel.setCurrentColor(Color.MAGENTA);
                System.out.println("The user selected the color Magenta");
                break;

            case "Orange":
                drawingPanel.setCurrentColor(Color.ORANGE);
                System.out.println("The user selected the color Orange");
                break;

            case "About/Authors":
                JOptionPane.showMessageDialog(this,
                        "Authors:\nAurélien POINSEL\nIn collaboration with Internet\nSpecial thanks to Tauvel and ChatGPT",
                        "About/Authors",
                        JOptionPane.INFORMATION_MESSAGE);
                break;

            default:
                System.out.println("Button/Menu Action not handled: " + cmd);
        }
    }
}



