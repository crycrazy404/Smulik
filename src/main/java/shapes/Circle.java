package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    Color color;
    double x,y;
    String type;
    double radius;
    public Circle() {
        this.type = "Circle";
    }
    @Override
    public void draw(GraphicsContext gc, double x, double y, Color color,int strokeWid, Color strokeColor) {
        gc.setFill(color);
        double rad = 50;
        gc.fillOval(x , y, rad , rad);
        if (strokeWid != 0){
            gc.setLineWidth(strokeWid);
            gc.setStroke(strokeColor);
            gc.strokeOval(x, y, rad, rad);
        }
    }
    @Override
    public void drawIco(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        double rad = 20;
        gc.fillOval(0 , 0, rad , rad);
    }
    @Override
    public String toString() {
        return type;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
