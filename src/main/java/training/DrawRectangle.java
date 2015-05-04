package training;

import java.awt.Color;
import java.awt.Graphics;

public class DrawRectangle extends GeoObjects
{
    int defaultDiameter = getDiameter();

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setColor(Color.YELLOW);
        g.setColor(getColor());
        g.fill3DRect(10, 10, defaultDiameter, defaultDiameter, true);
        g.drawString("Date Created: " +  getDateCreated(), 5, 290);
    }

    public void setD(int newD)
    {
        defaultDiameter = (newD >= 0 ? newD : 10);
        repaint();
    }
}
