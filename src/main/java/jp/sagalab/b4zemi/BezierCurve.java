package jp.sagalab.b4zemi;
import java.util.ArrayList;
import java.util.List;

public class BezierCurve {
    private final List<Point> m_controlPoints;

    private BezierCurve(List<Point> _controlPoints){
        m_controlPoints = _controlPoints;
    }

    public static BezierCurve create(List<Point> _controlPoints){
        return new BezierCurve(_controlPoints);
    }

    public List<Point> getControlPoints(){
        return new ArrayList<Point>(m_controlPoints);
    }

    public int getDegree(){
        return m_controlPoints.size()-1;
    }
    
}
