package newGeoObjects;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractShapes {
    private List<AbstractShapes> shapeList = new ArrayList<AbstractShapes>();
    
    public void draw(Graphics g) {
        for (AbstractShapes item : shapeList) {
            item.draw(g);
        }
    }
    
    public void add(AbstractShapes shape) {
        if (shape != null) {
            shapeList.add(shape);
        } else {
            throw new RuntimeException("Null object passed");
        }
     }
    
    public void remove(AbstractShapes shape) {
        if (shape != null) {
            shapeList.remove(shape);
        } else {
            throw new RuntimeException("Null object passed");
        }
    }     
}
