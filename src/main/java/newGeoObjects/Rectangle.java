package newGeoObjects;

import java.awt.Point;

public class Rectangle extends AbstractShapes
{
    private Point topLeft;
    private Point topRight;
    private Point bottomLeft;
    private Point bottomRight;
    
    public Rectangle(int x, int y, int width, int height) {
        setPoint(new Point(x,y), height, width);
        createRactangle();
    }
    
    public Rectangle(Point startPoint, int width, int height) {
        setPoint(startPoint, height, width);
        createRactangle();
    }
    
    private void createRactangle() {
        Line a = new Line(topLeft, topRight);
        Line b = new Line(topLeft, bottomLeft);
        Line c = new Line(bottomLeft, bottomRight);
        Line d = new Line(topRight, bottomRight);
         
        add(a);
        add(b);
        add(c);
        add(d);
     }
    
    public void setPoint(Point startPoint, int height, int width) {
        this.topLeft = startPoint;
        this.topRight = new Point((topLeft.x + width), topLeft.y);
        this.bottomLeft = new Point(topLeft.x, (topLeft.y + height));
        this.bottomRight = new Point(topLeft.x + width, topLeft.y + height);
    }
}
