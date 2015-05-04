package training;

import java.awt.Graphics;

public class DrawArc extends GeoObjects
{
    int diameter = getDiameter();
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawArc(5, 25, 200, 220, diameter, diameter);
    }

    public void setD(int newD)
    {  
        diameter = (newD >= 0 ? newD : 10);
        repaint();
    }
}
