package KoonFungYee;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        long start=System.currentTimeMillis();
        ReadPDF.read();

        List<Row> list= ReadPDF.rows;
        WordNChar task=new WordNChar(list,0,list.size());
        ForkJoinPool pool= new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        pool.invoke(task);

        do {
            System.out.printf(Thread.currentThread().getName()+"- Parallelism:%d\n",pool.getParallelism());
            System.out.printf(Thread.currentThread().getName()+"- Active Thread:%d\n",pool.getActiveThreadCount());
            System.out.printf(Thread.currentThread().getName()+"- Task Count: %d\n",pool.getQueuedTaskCount());
            System.out.printf(Thread.currentThread().getName()+"- Pool size: %d\n", pool.getPoolSize());
            TimeUnit.MILLISECONDS.sleep(5);
        }while (!task.isDone());

        pool.shutdown();

        if (task.isCompletedNormally()){
            System.out.println("The process has completed normally.");
        }

        WordNChar.result();
        System.out.println("End of the program");
        long end=System.currentTimeMillis();
        long duration=end-start;
        System.out.println("Running is: "+duration+"ms.");

    }
}
