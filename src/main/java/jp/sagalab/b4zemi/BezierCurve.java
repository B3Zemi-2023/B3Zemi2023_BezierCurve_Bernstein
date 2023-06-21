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
     * 制御点列のコピーを取得する
     * @return 制御点列のコピー
     */
    public List<Point> getControlPoints(){
        return new ArrayList<Point>(m_controlPoints);
    }

    /**
     * 次数を取得する
     * @return 次数
     */
    public int getDegree(){
        return m_controlPoints.size()-1;
    }

    /**
     * パラメータ t に対応する評価点を De Casteljau のアルゴリズムで評価する
     * @param _t 閉区間 [ 0, 1 ] 内のパラメータ
     * @return パラメータ t に対応する評価点
     */
    public Point evaluate1(double _t){
        if(m_controlPoints.size()==1){
            return m_controlPoints.get(0);
        }
        else {
            List<Point> dividePoints = new ArrayList<>();
            for (int n = 0; n < m_controlPoints.size()-1; n++) {
                Point i;
                i = m_controlPoints.get(n).divide(m_controlPoints.get(n + 1), _t);
                dividePoints.add(i);
            }
            return BezierCurve.create(dividePoints).evaluate1(_t);
        }
    }

    /**
     * 階乗を計算する
     * @param n 階乗する値
     * @return 階乗した結果
     */
    public static double factorial(double n){
        double a =1.0;
        for(int i=1; i < n; i++){
            a = a * (i+1);
        }
        return a;
    }

    /**
     * Bernstein多項式
     * @param _i　制御点のインデックス
     * @param _t パラメータ
     * @return Bernstein多項式
     */
    public double Bernstein(int _i,double _t){
        double b = factorial(m_controlPoints.size()-1)/(factorial(_i)*factorial(m_controlPoints.size()-1-_i));
        return b * Math.pow(_t,_i)*Math.pow(1-_t,m_controlPoints.size()-1-_i);
    }

    public Point evaluate2(double _t){
        List<Double> blist = new ArrayList<>();
        double x =0.0;
        double y =0.0;
        for(int i=0; i <= m_controlPoints.size()-1; i++){
           x += m_controlPoints.get(i).getX()*Bernstein(i,_t);
           y += m_controlPoints.get(i).getY()*Bernstein(i,_t);
        }
        return Point.create(x,y);

    }
}
