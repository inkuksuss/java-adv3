package parallel;

import parallel.forkjoin.SumTask;
import util.MyLogger;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class PorkJoinMain1 {

    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 8)
                .boxed()
                .toList();

        long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool(10);

        SumTask sumTask = new SumTask(list);
        Integer result = pool.invoke(sumTask);

        long end = System.currentTimeMillis();
        MyLogger.log("time = " + (end - start) + " result: " + result);

        pool.close();
    }
}
