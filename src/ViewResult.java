import java.util.ArrayList;

public class ViewResult {
    public static void ViewResult(ArrayList<Stump> EnsembleClassifiers)
    {
        for(Stump G:EnsembleClassifiers)
        {
            System.out.println(G.showInfo());
        }
    }
}
