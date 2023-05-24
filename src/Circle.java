import java.awt.Graphics;

public class Circle extends Shape{
    public Circle(int x,int y,int w, int h){
        super(x,y,w,h);
        X=w;Y=h;
    }
    public void paint(Graphics g){
        g.drawOval(x,y,X,Y);
    }

}
