import java.util.ArrayList;

public class Stump
{
    public int dim;
    public double thresh;
    public String condition;
    public double error;
    public ArrayList<Integer> lablelist;
    double factor;
    public String showInfo()
    {
        return "dim is"+dim+"\nthresh"+thresh+"\nfactor is"+factor+"END";
    }
}
