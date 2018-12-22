package RepoG5;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

public class App{
    public static void main( String[] args )  throws IOException, InterruptedException, ExecutionException {
        try {
            // All declaration of variables
            long start = System.currentTimeMillis();
            ReadPDF.read(); // Access into ReadDPF java file
            List<Row> list = ReadPDF.rows;
            WordNChar task = new WordNChar(list, 0, list.size());
            ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
            pool.invoke(task);
            System.out.println("*** The main program starts now... ***\n");
            Thread.sleep(1000); // 1 second
            do {
                System.out.printf(Thread.currentThread().getName() + "- Parallelism:%d\n", pool.getParallelism());
                System.out.printf(Thread.currentThread().getName() + "- Active Thread:%d\n", pool.getActiveThreadCount());
                System.out.printf(Thread.currentThread().getName() + "- Task Count: %d\n", pool.getQueuedTaskCount());
                System.out.printf(Thread.currentThread().getName() + "- Pool size: %d\n", pool.getPoolSize());
            } while (!task.isDone());
            pool.shutdown();
            System.out.println(" ");
            Thread.sleep(1000); // 1 second
            if (task.isCompletedNormally()) {
                System.out.println("*** The process has completed normally. ***\n"); // Show task variable process ended
            }
            Thread.sleep(1000); // 1 second
            // Show result of words and characters
            WordNChar.result();
            Thread.sleep(1000); // 1 second
            // Display standard deviation part
            ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            Future<Double> standardDeviation = service.submit(new StandardDeviation());
            System.out.println("*** Standard deviation value ***");
            System.out.println(standardDeviation.get() +"\n"); // Retrieve standard deviation from StandardDeviation.java
            Thread.sleep(1000); // 1 second
            // Result of z scores
            Zscore.ZscoreResult();
            Thread.sleep(1000); // 1 second
            // Display normalization graph part
            final Normalization_Graph graph = new Normalization_Graph();
            graph.go();
            System.out.println("*** Normalization graph displayed ***\n");
            Thread.sleep(1000); // 1 second
            // Display box plot
            new Boxplot().showInFrame();
            System.out.println("*** Box plot displayed ***\n");
            Boxplot_Info display = new Boxplot_Info();
            display.boxplotCalNDisplay(); // Display 1st quartile, median and 3rd quartile of current box plot
            Thread.sleep(1000); // 1 second
            System.out.println("*** Overall process duration: ***");
            // Calculation of duration of process in main program
            long end = System.currentTimeMillis();
            long duration = end - start;
            System.out.println(duration + "ms.\n"); // Display duration output
            Thread.sleep(1000); // 1 second
            // End of the program
            System.out.println("*** End of the program ***");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
