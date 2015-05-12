package newGeoObjects;

import java.awt.Graphics;
import java.awt.Point;

public class Circle extends AbstractShapes {
    private Point center;
    private int width;
    private int height;
    
    public Circle(Point center, int width, int hegiht) {
        this.center = center;
        this.width = width;
        this.height = hegiht;
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawOval(center.x, center.y, width, height);
    }
    
}
