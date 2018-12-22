package RepoG5;

import java.util.concurrent.Callable;

public class StandardDeviation implements Callable { // Calculation of standard deviation
    @Override
    public Double call() throws Exception {
        int sum = 0;
        for (int i=0;i<WordNChar.characters.size();i++){
            sum+=WordNChar.characters.get(i).getNumber(); // Add all value into sum
        }
        double mean=sum/WordNChar.characters.size(); // Calculate mean
        double sumData = 0;
        for (int j=0;j<WordNChar.characters.size();j++){
            sumData+=Math.pow(WordNChar.characters.get(j).getNumber()-mean,2); // Sum of x-mean
        }
        double standardDeviation=Math.sqrt(sumData/WordNChar.characters.size()); // Calculate standard deviation
        return standardDeviation;
    }
}
