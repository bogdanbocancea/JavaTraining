package json.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({@JsonSubTypes.Type(value=Line.class),
               @JsonSubTypes.Type(value=Circle.class),
               @JsonSubTypes.Type(value=Rectangle.class)})
public abstract class AbstractShapes {
    
    @JsonIgnore
    public List<AbstractShapes> shapeList = new ArrayList<AbstractShapes>();
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
    private Date createdDate;
    private String shapeName;
    
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

    @JsonSerialize(using=DateSerializer.class)
    public Date getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    @XmlElement
    public String getName() {
        return shapeName;
    }
    
    public void setName(String name) {
        this.shapeName = name;
    }
}
