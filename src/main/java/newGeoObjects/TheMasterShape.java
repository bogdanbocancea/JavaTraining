package newGeoObjects;

import java.awt.Point;

/**
 * One shape to rule them all
 * 
 */

public class TheMasterShape extends AbstractShapes {

    public TheMasterShape() {
        Rectangle one = new Rectangle(new Point(250,50), 150, 100);
        Rectangle two = new Rectangle(new Point(125,200), 150, 100); 
        Circle five = new Circle(new Point(250,385), 150, 100);     
        Line lineOne = new Line(new Point(330,150), new Point(330,385));
        Line lineTwo = new Line(new Point(275,250), new Point(330,250));       
        add(one);
        add(two);
        add(five);
        add(lineOne);
        add(lineTwo);  
        int x[] = {25, 145, 25, 145, 90};
        int y[] = {25, 25, 145, 145, 90};
        int n = 5;
        Polygon poly = new Polygon(x, y, n);
        add(poly);
    }
}
