package jp.sagalab.b4zemi;

/**
 * 平面上の点を表す．平面上の点のｘ座標とy座標を保持するクラス
 * @author Nirei Yutaro
 */
public class Point {
    private final double m_x;
    private final double m_y;

    /**
     * 指定した座標にある点を生成する
     * @param _x x座標
     * @param _y y座標
     */
    private Point(double _x, double _y){
        m_x = _x;
        m_y = _y;
    }

    /**
     * 点の生成を行うためのstaticファクトリーメソッド
     * @param _x x座標
     * @param _y y座標
     * @return 点のインスタンス
     */
    public static Point create(double _x, double _y){
        return new Point(_x,_y);
    }

    /**
     * 点のx座標を取得する
     * @return x座標
     */
    public double getX(){
        return m_x;
    }

    /**
     * 点のx座標を取得する
     * @return y座標
     */
    public double getY(){
        return m_y;
    }

    /**
     * この点ともう一つの点を t : ( 1 - t ) で内分 ( t < 0 または t > 1 の場合は外分 ) する
     * @param _other もう一つの点
     * @param t 比のパラメータ
     * @return 内分点（外分点）
     */
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
