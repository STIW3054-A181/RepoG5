package KoonFungYee;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        long start=System.currentTimeMillis();
        ReadPDF.read(); // Access into ReadDPF java file

        List<Row> list= ReadPDF.rows;
        WordNChar task=new WordNChar(list,0,list.size());
        ForkJoinPool pool= new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        pool.invoke(task);

        do {
            System.out.printf(Thread.currentThread().getName()+"- Parallelism:%d\n",pool.getParallelism());
            System.out.printf(Thread.currentThread().getName()+"- Active Thread:%d\n",pool.getActiveThreadCount());
            System.out.printf(Thread.currentThread().getName()+"- Task Count: %d\n",pool.getQueuedTaskCount());
            System.out.printf(Thread.currentThread().getName()+"- Pool size: %d\n", pool.getPoolSize());
        }while (!task.isDone());

        pool.shutdown();

        if (task.isCompletedNormally()){
            System.out.println("The process has completed normally.");
        }

        WordNChar.result();
        ExecutorService service= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<Double> standardDeviation=service.submit(new StandardDeviation());
        System.out.println("Standard Deviation is: "+standardDeviation.get());

        System.out.println("End of the program");
        long end=System.currentTimeMillis();
        long duration=end-start;
        System.out.println("Total running time is: "+duration+"ms.");

    }
}
