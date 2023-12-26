package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements Cloneable {
    public abstract void draw(GraphicsContext gc, double x, double y, Color color, int strokeWid, Color strokeColor);
    public abstract void drawIco(GraphicsContext gc);
    public abstract String toString();
    public abstract void setColor(Color color);
    public abstract void setXY(double x, double y);
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}
