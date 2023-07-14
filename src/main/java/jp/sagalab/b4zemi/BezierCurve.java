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
        return 0;
    }

    /**
     * Bernstein多項式
     * @param _i　制御点のインデックス
     * @param _t パラメータ
     * @return Bernstein多項式
     */
    public double Bernstein(int _i,double _t){
        //Bernstein多項式Bの計算する処理を記述してください
        return 0;
    }

    /**
     * Bernstein多項式表現
     * @param _t パラメータ
     * @return Bernstein多項式表現
     */
    public Point evaluate(double _t){
        //Bernstein多項式を用いてBernstein多項式表現の計算処理を記述してください
        return null;
    }

}
