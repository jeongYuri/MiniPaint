import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Mycanvas extends JPanel {
    int c;
    Vector<Shape> s;

    public Mycanvas(){
        s=new Vector<Shape>();
    }
    public void paint(Graphics g){
        super.paint(g);
        for(int k=0;k<s.size();k++){
            Shape s1 = s.elementAt(k);
            s1.paint(g);
        }
    }

    public void add(Shape s1){
        s.add(s1);
        repaint();
    }
    public Shape getShape(int n){
        return s.elementAt(n);
    }
    public Shape select(int x,int y){
        for(int i=s.size()-1;i>=0;i--){
            Shape s2 = s.elementAt(i);
            if(x>=s2.x&&x<=(s2.x+s2.X)&&y>=s2.y&&y<=(s2.y+s2.Y)){
                s.add(s2);
                s.remove(i);
                return s2;
            }
        }
        return null;
    }
    public Shape move(Shape s1){
        c = s.indexOf(s1);
        if(c!=s.size()-1){
            s.remove(c);
            s1 = s.elementAt(c);
        }else
            s.remove(s.size()-2);
        return s1;
    }
    public void clear(){
        s.removeAllElements();
        repaint();
    }
}
