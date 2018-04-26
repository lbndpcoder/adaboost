
import java.util.ArrayList;

public class Adaboost {
    public  static ArrayList<Stump> AdaboostTrain(ArrayList<ArrayList<Double>> dataSet,ArrayList<Integer> labelList)
    {
        int SampleNumber = labelList.size();
        Instance.IniteWeights(SampleNumber);
        ArrayList<Stump> G = new ArrayList<>();
        ClError error = new ClError();
        ArrayList<Double> errorList = error.initErrorList(SampleNumber);
        int n = 1;
        while(true)
        {
            CreateTree ct = new CreateTree();
            Stump stump = ct.buildStump(dataSet,labelList,n);
            G.add(stump);
            Instance.freshWeights(stump);
            errorList = error.accWeightedError(errorList,stump);
            double errorRate = error.calculateErrorRate(errorList,labelList);
            System.out.println(errorRate);
            if(errorRate < 0.01)
            {
                break;
            }
            n++;
            if(n > 100)
            {
                break;
            }
        }
        return G;
    }

}
