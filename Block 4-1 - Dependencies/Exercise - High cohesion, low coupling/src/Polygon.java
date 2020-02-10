import javax.swing.*;
import java.awt.*;
import java.awt.font.GraphicAttribute;

/**
 * Created by Niklas on 2016-01-19.
 */
public abstract class Polygon extends JComponent{
    public Point centerPoint;
    public DrawPolygons drawer;

    public Polygon(Point center, DrawPolygons drawer){
        this.centerPoint = center;
        this.drawer = drawer;
    }
    public Polygon(int x, int y, DrawPolygons drawer){
        this(new Point(x,y), drawer);
    }

    public void updateCenter(int x, int y){
        this.centerPoint = new Point(x,y);
        drawer.frame.repaint();
    }

    @Override
    public abstract void paint(Graphics g)//paint
    ;
}
