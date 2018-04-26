import java.io.IOException;
import java.util.ArrayList;

public class mian {
    public static void main(String args[])
            throws IOException
    {
        String fileName = "/Users/liubonan/Downloads/adaboost/src/adaboost.txt";
        Instance.loadDataSet(fileName);
        Instance.loadLabel(fileName);
        ArrayList<Stump> G = new Adaboost().AdaboostTrain(Instance.dataSet,Instance.labelList);
        ViewResult vr = new ViewResult();
        vr.ViewResult(G);
    }
}
