import java.util.ArrayList;

public class Predict {
    public static ArrayList<Integer> Predict
            (ArrayList<ArrayList<Double>> dataSet, int feature, double thresh, String condition) {
        ArrayList<Integer> labelList = new ArrayList<Integer>();
        if (condition.compareTo("lt") == 0) {
            for (ArrayList<Double> data : dataSet) {
                if (data.get(feature) <= thresh) {
                    labelList.add(1);
                } else {
                    labelList.add(-1);
                }
            }
        } else {
            for (ArrayList<Double> data : dataSet) {
                if (data.get(feature) >= thresh) {
                    labelList.add(1);
                } else {
                    labelList.add(-1);
                }
            }
        }
        return labelList;
    }
}

