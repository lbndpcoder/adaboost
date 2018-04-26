import java.util.ArrayList;

public class ClError
{
    public static ArrayList<Double> initErrorList(int n)
    {
        ArrayList<Double> ErrorList = new ArrayList<>();
        for(int i = 0;i < n;i++)
        {
            ErrorList.add(0.0);
        }
        return ErrorList;
    }

    public static ArrayList<Double> accWeightedError(ArrayList<Double> ErrorList,Stump stump)
    {
        ArrayList<Integer> t = stump.lablelist;
        ArrayList<Double> newWeightedErrors = new ArrayList<>();

        double factor = stump.factor;

        for(int i = 0;i < t.size();i++)
        {
            double newWeightedError = ErrorList.get(i) + factor * t.get(i);
            newWeightedErrors.add(newWeightedError);
        }
        return newWeightedErrors;
    }
    public static double calculateErrorRate(ArrayList<Double> ErrorList,ArrayList<Integer> labelList)
    {
        ArrayList<Integer> a = new ArrayList<>();
        int wrongNumber = 0;
        for(int i = 0;i < ErrorList.size();i++)
        {
            if(ErrorList.get(i) > 0)
            {
                if(labelList.get(i) == -1)
                {
                    wrongNumber++;
                }
            }
            else if (ErrorList.get(i) <= 0)
            {
                if(labelList.get(i) == 1)
                {
                    wrongNumber++;
                }
            }
        }
        double errorRate = wrongNumber*1.0/ErrorList.size();
        return errorRate;
    }
}
