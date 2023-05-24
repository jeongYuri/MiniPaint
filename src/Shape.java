import java.awt.Graphics;
public abstract class Shape {
    int x, y, X, Y, pick;

    public Shape(int x, int y, int X, int Y) {
        this.x = x;
        this.y = y;
        this.X = X;
        this.Y = Y;
    }

    public abstract void paint(Graphics g);

    public void moveBy(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }

    public void moveTo(int newx, int newy) {
        x = newx;
        y = newy;
    }

    public boolean isIn(int tx, int ty) {
        if (x >= tx && tx <= X) {
            if (y <= ty && ty <= Y) {
                return true;
            }
        }
        return false;
    }

}
