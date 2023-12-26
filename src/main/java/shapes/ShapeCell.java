package shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;

public class ShapeCell extends ListCell<Shape> {
    @Override
    public void updateItem(Shape item, boolean empty) {
        super.updateItem(item, empty);
        if(item != null){
            Canvas canvas = new Canvas(100, 60);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            Shape item1 = (Shape) item.clone();
            item1.drawIco(gc);
            setGraphic(canvas);
        }
    }
}
