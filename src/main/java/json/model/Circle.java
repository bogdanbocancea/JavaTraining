package json.model;

import java.awt.Graphics;
import java.awt.Point;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="shapeType")
@XmlRootElement(name = "Circle")
public class Circle extends AbstractShapes {
    private Point center;
    
    @JsonProperty
    @XmlElement
    private int width;
    
    @JsonProperty
    @XmlElement
    private int height;
    
    @JsonProperty
    @XmlElement
    private int radius;
      
    public Circle() {
        
    }
    
    public Circle(Point center, int width, int height) {
        this.center = center;
        this.width = width;
        this.height = height;
    }
    
    public Circle(int radius, int width, int height) {
        this.radius = radius;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawOval(center.x, center.y, width, height);
    }
}
