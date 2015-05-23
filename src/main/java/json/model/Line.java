package json.model;

import java.awt.Graphics;
import java.awt.Point;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="shapeType")
@XmlRootElement(name = "Line")
public class Line extends AbstractShapes {
    private Point startPoint, endPoint;
    
    @JsonProperty
    @XmlElement
    private int start;
    
    @JsonProperty
    @XmlElement
    private int stop;
   
    public Line() {
        
    }
    
    public Line(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }
        
    public Line(Point startPoint, 
                Point endPoint) {
        super();
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }
}
