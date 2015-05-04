package training;

import java.awt.Color;
import java.awt.Graphics;

public class DrawOval extends GeoObjects
{
    int defaultDiameter = getDiameter();

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setColor(Color.GREEN);
        g.setColor(getColor());
        g.fillOval(10, 10, defaultDiameter, defaultDiameter);
        g.drawString("Date Created: " + getDateCreated(), 25, 290);
    }

    public void setD(int newD)
    {
        defaultDiameter = (newD >= 0 ? newD : 10);
        repaint();
    }
}
