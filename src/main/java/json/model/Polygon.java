package json.model;

import java.awt.Graphics;

public class Polygon extends AbstractShapes {

    int xpoints[];
    int ypoints[];
    int npoints;
    
    public Polygon(int[] x, int[] y, int n) {
        this.xpoints = x;
        this.ypoints = y;
        this.npoints = n;   
    }
    
    @Override
    public void draw(Graphics g) {   
        g.drawPolygon(xpoints, ypoints, npoints);
    }
}
