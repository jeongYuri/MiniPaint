import java.awt.Graphics;
public class Line extends Shape{
    public Line(int x,int y,int X, int Y){
        super(x,y,X,Y);
        pick =3;
    }
    public void paint(Graphics g){
        g.drawLine(x,y,X,Y);
    }
}
