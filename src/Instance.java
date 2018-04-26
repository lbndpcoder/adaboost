import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Instance
{
    public static double weight;
    public static ArrayList<Double> weights;
    public static ArrayList<ArrayList<Double>> dataSet;

    public static ArrayList<Double> getWeights() {
        return weights;
    }

    public static  ArrayList<Integer> labelList;

    public static void IniteWeights(int n)
    {
        weight = 1.0/n;
        ArrayList<Double> initialWeights = new ArrayList<>();
        for(int i = 0;i < n;i++)
        {
            initialWeights.add(weight);
        }
        weights = initialWeights;
    }

    public static void freshWeights(Stump stump)
    {
        double Z = 0;
        int sampleNumber = labelList.size();
        ArrayList<Double> newWeights = new ArrayList<>();
        for(int i = 0;i < sampleNumber;i++)
        {
            Z  += weights.get(i)*Math.pow(Math.E,-stump.factor * labelList.get(i) * stump.lablelist.get(i));
        }

        for(int i = 0;i < sampleNumber;i++)
        {
            weight = weights.get(i) * Math.pow(Math.E,-stump.factor * labelList.get(i) * stump.lablelist.get(i)) / Z;
            newWeights.add(weight);
        }
        weights = newWeights;
    }
    public static void loadDataSet(String fileName)
            throws IOException
    {
        ArrayList<ArrayList<Double>> dataMatrix = new ArrayList<>();
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while((line = br.readLine()) != null)
        {
            ArrayList<Double> data = new ArrayList<>();
            String[] s = line.split(" ");
            for(int i = 0;i < s.length - 1;i++)
            {
                data.add(Double.parseDouble(s[i]));
            }
            dataMatrix.add(data);
        }
        dataSet = dataMatrix;
    }
    public static void loadLabel(String fileName)
            throws IOException
    {
        ArrayList<Integer> labels = new ArrayList<>();
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while((line = br.readLine()) != null)
        {
            String[] s = line.split(" ");
            int size = s.length;
            labels.add(Integer.parseInt(s[size - 1]));
        }
        labelList = labels;
    }
}
