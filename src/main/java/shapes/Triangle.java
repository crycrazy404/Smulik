package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape{
    Color color;
    double x,y;
    String type;
    public Triangle() {
        this.type = "Triangle";
    }
    @Override
    public void draw(GraphicsContext gc, double x, double y, Color color, int strokeWid, Color strokeColor) {
        double[] xCords = new double[]{x, x+20, x+20};
        double[] yCords = new double[]{y, y, y+75};
        gc.setFill(color);
        gc.fillPolygon(xCords,yCords, 3);
        if(strokeWid != 0){
            gc.setLineWidth(strokeWid);
            gc.setStroke(strokeColor);
            gc.strokePolygon(xCords,yCords, 3);
        }
    }
    @Override
    public void drawIco(GraphicsContext gc) {
        double[] xCords = new double[]{0, 20, 20};
        double[] yCords = new double[]{0, 0, 35};
        gc.setFill(color);
        gc.fillPolygon(xCords,yCords, 3);
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
