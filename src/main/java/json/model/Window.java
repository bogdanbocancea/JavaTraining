package json.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Window extends JComponent {
    private static final long serialVersionUID = 5641291999761510743L;
    private AbstractShapes shape;
    
    public Window(AbstractShapes shape) {
        super();
        this.shape = shape;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(0, 0, 700, 700);
     
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.GREEN);  
        shape.draw(g2d);   
    }
}
