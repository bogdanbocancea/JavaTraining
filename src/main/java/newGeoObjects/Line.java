package newGeoObjects;

import java.awt.Graphics;
import java.awt.Point;

public class Line extends AbstractShapes {
    private Point startPoint, endPoint;
    
    public Line(Point startPoint, Point endPoint) {
        super();
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }
}
