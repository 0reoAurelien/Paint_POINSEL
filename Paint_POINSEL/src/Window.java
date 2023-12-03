import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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


        Container southPanel = new Container();
        southPanel.setLayout(new GridLayout(1, 2));

        colorPanel = new JPanel();
        colorPanel.setLayout(new GridLayout(2, 4));

        JButton colorButtonBlack = new JButton("Black");
        JButton colorButtonRed = new JButton("Red");
        JButton colorButtonGreen = new JButton("Green");
        JButton colorButtonBlue = new JButton("Blue");
        JButton colorButtonYellow = new JButton("Yellow");
        JButton colorButtonPink = new JButton("Pink");
        JButton colorButtonMagenta = new JButton("Magenta");
        JButton colorButtonOrange = new JButton("Orange");
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


        figurePanel = new JPanel();
        figurePanel.setLayout(new GridLayout(2, 2));
        // Add buttons to colorPanel
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

/*
        JButton okButton = new JButton("Que viva ENSEA !");
        okButton.setPreferredSize(new Dimension(200, 50));
        contentPanel.add(okButton, BorderLayout.CENTER);
*/

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "Rectangle":
                drawingPanel.setCurrentFigure(new Rectangle(drawingPanel.getColor(), 0, 0));
                break;

            case "Square":
                drawingPanel.setCurrentFigure(new Square(drawingPanel.getColor(), 0, 0));
                break;

            case "Ellipse":
                drawingPanel.setCurrentFigure(new Ellipse(drawingPanel.getColor(), 0, 0));
                break;

            case "Circle":
                drawingPanel.setCurrentFigure(new Circle(drawingPanel.getColor(), 0, 0, 0));
                break;

            case "Black":
                drawingPanel.setCurrentColor(Color.BLACK);
                break;

            case "Red":
                drawingPanel.setCurrentColor(Color.RED);
                break;

            case "Green":
                drawingPanel.setCurrentColor(Color.GREEN);
                break;

            case "Blue":
                drawingPanel.setCurrentColor(Color.BLUE);
                break;

            case "Yellow":
                drawingPanel.setCurrentColor(Color.YELLOW);
                break;

            case "Pink":
                drawingPanel.setCurrentColor(Color.PINK);
                break;

            case "Magenta":
                drawingPanel.setCurrentColor(Color.MAGENTA);
                break;

            case "Orange":
                drawingPanel.setCurrentColor(Color.ORANGE);
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



