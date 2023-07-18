package jp.sagalab.b4zemi;
import java.util.ArrayList;
import java.util.List;

public class BezierCurve {
    private final List<Point> m_controlPoints;

    /**
     * 制御点列を指定してBezier曲線オブジェクトを生成する
     * @param _controlPoints 制御点列
     */
    private BezierCurve(List<Point> _controlPoints){
        m_controlPoints = _controlPoints;
    }


    /**
     * Bezier曲線の生成を行うためのstaticファクトリーメソッド
     * @param _controlPoints 制御点列
     * @return Bezier曲線のインスタンス
     */
    public static BezierCurve create(List<Point> _controlPoints){
        return new BezierCurve(_controlPoints);
    }

    /**
     * 階乗を計算する
     * @param n 階乗する値
     * @return 階乗した結果
     */
    public double factorial(double n){
        //階乗を計算する処理を記述してください
        double x = 1;
        int i =1;
        while(i <= n) {
            x = x * i;
            i++;
        }
        return x;
    }

    /**
     * Bernstein多項式
     * @param _i　制御点のインデックス
     * @param _t パラメータ
     * @return Bernstein多項式
     */
    public double Bernstein(int _i,double _t){
        //Bernstein多項式Bの計算する処理を記述してください
        double a = factorial(m_controlPoints.size() - 1) / (factorial(_i) * factorial((m_controlPoints.size() - 1) - _i));
        double B = a * Math.pow(_t, _i) * Math.pow(1 - _t, m_controlPoints.size() - 1 - _i);
        return B;
    }

    /**
     * Bernstein多項式表現
     * @param _t パラメータ
     * @return Bernstein多項式表現
     */
    public Point evaluate(double _t){
        //Bernstein多項式を用いてBernstein多項式表現の計算処理を記述してください
        //Point.javaにあるcreateメソッドを使えばポイントのインスタンスを作ることが出来ます。
        double sumx = 0;
        double sumy = 0;

        for(int i = 0; i <= m_controlPoints.size() - 1; i++){
            sumx += (m_controlPoints.get(i).getX()) * Bernstein(i, _t);
            sumy += (m_controlPoints.get(i).getY()) * Bernstein(i, _t);
        }

        return Point.create(sumx, sumy);
    }

}
