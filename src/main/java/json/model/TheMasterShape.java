package json.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * One shape to rule them all
 * 
 */
@XmlRootElement(name = "Composition")
public class TheMasterShape extends AbstractShapes {  
    
    @JsonProperty
    @XmlElement
    public List<AbstractShapes> shapes = new ArrayList<AbstractShapes>();
    
    public void addShapes(AbstractShapes s){
        shapes.add(s);
        shapeList = shapes;
    }
     
    public void remove(AbstractShapes s){
        shapeList.remove(s);
    }

}
