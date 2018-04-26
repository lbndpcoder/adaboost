import java.util.ArrayList;

public class getError
{
    public static double getError(ArrayList<Integer> predict,ArrayList<Integer> real)
    {
        double error = 0;
        int n = real.size();
        for(int i = 0;i < n;i++)
        {
            if(predict.get(i) != real.get(i))
            {
                error += Instance.weights.get(i);
            }
        }
        return error;
    }

}
