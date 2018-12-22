package RepoG5;

import java.util.Arrays;

import static RepoG5.Zscore.callZscore;

public class Boxplot_Info {
    public void boxplotCalNDisplay() {
        try {
            int count = 0;
            for (ZscoreValue size : callZscore()) {
                count++; // Get size for double type array
            }
            double[]box = new double[count];
            int i = 0;
            for (ZscoreValue value : callZscore()) {
                double zScore = value.getzScore(); // Retrieve z score value from ZscoreValue.java
                box[i] = zScore; // Assign current z score value into specific index of array
                i++;
            }
            Arrays.sort(box); // Sort from lowest to highest value of z score
            System.out.println("Sorted z score value (from lowest to highest)");
            for(int j = 0; j<box.length; j++){
                System.out.println((j+1)+". "+box[j]); // Display sorted z score value
            }
            int first = box.length*25/100; // Get 1st quartile location
            double firstQ =  box[first]; // Assign 1st quartile value into firstQ
            double median; // Determine whether array size is even number or odd number
            if (box.length % 2 == 0) {
                median = (box[box.length / 2] + box[box.length / 2 - 1]) / 2; // For even size
            }
            else {
                median = (box[box.length / 2]); // For odd size
            }
            int third = box.length*75/100; // Get 3rd quartile location
            double thirdQ = box[third]; // Assign 3rd quartile value into thirdQ
            // Display 1st quartile, median and 3rd quartile
            System.out.println("\n1st Quartile: "+firstQ);
            System.out.println("Median: "+median);
            System.out.println("3rd Quartile: "+thirdQ+"\n");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
