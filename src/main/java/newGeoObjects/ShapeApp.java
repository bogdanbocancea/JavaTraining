package newGeoObjects;

import java.awt.Dimension;

import javax.swing.JFrame;

public class ShapeApp extends JFrame {
    
    public ShapeApp() {
        super("Composite Pattern");
        setSize(new Dimension(700, 700));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        TheMasterShape one = new TheMasterShape();
        Window component = new Window(one);
         
        ShapeApp application = new ShapeApp();
        application.getContentPane().add(component);
        application.setVisible(true);
    }
}
