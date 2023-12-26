package shapes;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ShapeFactory {
    Map<Integer, Shape> shapes;
    public ShapeFactory(){
        shapes = new HashMap<>();
        shapes.put(0, new Square());
        shapes.put(1, new Circle());
        shapes.put(2, new Triangle());
    }
    public Map<Integer, Shape> getMap(){
        return shapes;
    }
    public Shape createShape(int index){
        return shapes.get(index);
    }
}
