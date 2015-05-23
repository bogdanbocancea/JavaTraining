package json.model;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

public class ShapeApp extends JFrame {
    private static final long serialVersionUID = -1153054605661306227L;

    public ShapeApp() {
        super("Composite Pattern");
        setSize(new Dimension(700, 700));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        Rectangle rectangleOne = new Rectangle(new Point(250,50), 150, 100);
        Rectangle rectangleTwo = new Rectangle(new Point(125,200), 150, 100); 
        Circle circle = new Circle(new Point(250,385), 150, 100);     
        Line lineOne = new Line(new Point(330,150), new Point(330,385));
        Line lineTwo = new Line(new Point(275,250), new Point(330,250)); 
        int x[] = {25, 145, 25, 145, 90};
        int y[] = {25, 25, 145, 145, 90};
        int n = 5;
        Polygon poly = new Polygon(x, y, n);
        TheMasterShape theMaster = new TheMasterShape();
        theMaster.addShapes(rectangleOne);
        theMaster.addShapes(rectangleTwo);
        theMaster.addShapes(circle);
        theMaster.addShapes(lineOne);
        theMaster.addShapes(lineTwo);
        theMaster.addShapes(lineTwo);
        theMaster.addShapes(poly);
        
        Window component = new Window(theMaster);         
        ShapeApp application = new ShapeApp();
        application.getContentPane().add(component);
        application.setVisible(true);
    }
}
