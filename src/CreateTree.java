import java.util.ArrayList;

public class CreateTree {

    public static double getMin(ArrayList<ArrayList<Double>> dataSet,int index)
    {
        double min = 999.0;
        for(ArrayList<Double> data:dataSet)
        {
            if(data.get(index) < min)
            {
                min = data.get(index);
            }
        }
        return min;
    }

    public static double getMax(ArrayList<ArrayList<Double>> dataSet,int index)
    {
        double max = -999.0;
        for(ArrayList<Double> data:dataSet)
        {
            if(data.get(index) > max)
            {
                max = data.get(index);
            }
        }
        return max;
    }

    public static Stump buildStump(ArrayList<ArrayList<Double>> dataSet,ArrayList<Integer> lableList,int n)
    {
        int featureNUmber = dataSet.get(0).size();
        int rowNumber = dataSet.size();
        double minError = 999.0;
        Stump stump = new Stump();
        for(int i = 0;i < featureNUmber;i++)
        {
            double featureMin = getMin(dataSet,i);
            double featureMax = getMax(dataSet,i);
            double sketech = (featureMax - featureMin)/rowNumber;

            for(double j = featureMin - sketech;j <= featureMax + sketech;j = j + sketech)
            {
                String[] conditions = {"lt","gt"};
                for(String condition:conditions)
                {
                    ArrayList<Integer> predicetLabelsList = new Predict().Predict(dataSet,i,j,condition);
                    for(int k = 0;k < rowNumber;k++)
                    {
                        System.out.println(j+"begin"+predicetLabelsList.get(k)+"end"+k);
                    }
                    double error = new getError().getError(predicetLabelsList,lableList);
                    System.out.println(error);
                    if(error < minError)
                    {
                        minError = error;
                        stump.dim = i;
                        stump.condition = condition;
                        stump.error = minError;
                        stump.thresh = j;
                        stump.lablelist = predicetLabelsList;
                        stump.factor = 0.5*(Math.log((1-error)/error));
                    }
                }
            }

        }
        return stump;
    }
}
