package GameOfChessFinal.model;
public class Point {
    int x;
    int y;

    public Point() {

    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCoord(int i, int j) {
        this.x = i;
        this.y = j;
    }


}
