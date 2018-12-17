package KoonFungYee;

import java.util.concurrent.Callable;

public class StandardDeviation implements Callable {
    @Override
    public Double call() throws Exception {
        int sum = 0;
        for (int i=0;i<WordNChar.characters.size();i++){
            sum+=WordNChar.characters.get(i).getNumber();
        }
        double mean=sum/WordNChar.characters.size();

        double sumData = 0;
        for (int j=0;j<WordNChar.characters.size();j++){
            sumData+=Math.pow(WordNChar.characters.get(j).getNumber()-mean,2);
        }

        double standardDeviation=Math.sqrt(sumData/WordNChar.characters.size());

        return standardDeviation;
    }
}
