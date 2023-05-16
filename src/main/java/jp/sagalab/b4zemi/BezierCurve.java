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
    public Point evaluate(double _t){
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
            return BezierCurve.create(dividePoints).evaluate(_t);
        }
    }
}
