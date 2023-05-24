import java.awt.Graphics;

public class Rect extends Shape{
    public Rect(int x,int y,int w, int h){
        super(x,y,w,h);
        X=w;Y=h;
        pick=2;
    }
    public void paint(Graphics g){
        g.drawRect(x,y,X,Y);
    }
}
