package json.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import json.model.AbstractShapes;
import json.model.Circle;
import json.model.Line;
import json.model.TheMasterShape;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class GeoController {   
    
    @RequestMapping(value = "/shapes/line", method = RequestMethod.GET)                
    public AbstractShapes getLine() {
        
        Line line = new Line(444, 321);
        line.setName("Line Json");
        Date date = new Date();
        line.setCreatedDate(date);     
        saveJsonFile(line);
        return line;
    }
    
    @RequestMapping(value = "/shapes/circle", method = RequestMethod.GET)
    public AbstractShapes getCircle() {
        
        Circle circle = new Circle(687, 444, 321);
        circle.setName("The circle");
        Date date = new Date();
        circle.setCreatedDate(date);
        saveJsonFile(circle);
        return circle;
    }
    
    @RequestMapping(value = "/shapes/master", method = RequestMethod.GET)
    public AbstractShapes getMaster() {
        
        Date date = new Date();
        TheMasterShape theMaster = new TheMasterShape();
        
        Circle circle = new Circle(687, 444, 321);
        circle.setName("The circle");  
        circle.setCreatedDate(date);
        
        Line line = new Line(444, 321);
        line.setName("Line Json");
        line.setCreatedDate(date);     

        theMaster.addShapes(circle);
        theMaster.addShapes(line);
        theMaster.setName("Composite Get");
        theMaster.setCreatedDate(date);
        
        saveJsonFile(theMaster);
        
        return theMaster;
    }
    
    public void saveJsonFile(AbstractShapes shape) {
        
        ObjectMapper mapper = new ObjectMapper(); 
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        
        try {
            //eu sunt pe MAC OS nu am c: ;)
            writer.writeValue(new File(shape.getName() +".json"), shape);
            System.out.println(mapper.writeValueAsString(shape));
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
