package jp.sagalab.b4zemi;

public class Point {
    private final double m_x;
    private final double m_y;

    private Point(double _x, double _y){
        m_x = _x;
        m_y = _y;
    }

    public static Point create(double _x, double _y){
        return new Point(_x,_y);
    }

    public double getX(){
        return m_x;
    }
    public double getY(){
        return m_y;
    }
    public Point divide(Point _other, double t) {
        double otherX;
        double otherY;
        double divideX;
        double divideY;

        otherX = _other.getX();
        otherY = _other.getY();

        divideX = ((1-t) * m_x + t * otherX);
        divideY = ((1-t) * m_y + t * otherY);

        return Point.create(divideX, divideY);
    }
}
