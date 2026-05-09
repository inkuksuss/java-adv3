package parallel;

import parallel.forkjoin.SumTask;
import util.MyLogger;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class PorkJoinMain3 {

    public static void main(String[] args) {
        int processorCount = Runtime.getRuntime().availableProcessors();
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        log("processorCnt: " + processorCount + ", commonPool: " + commonPool.getParallelism());


        long start = System.currentTimeMillis();
        int sum = IntStream.rangeClosed(1, 8)
                .parallel()
                .map(HeavyJob::heavyTask)
                .reduce(0, Integer::sum);

        long end = System.currentTimeMillis();
        MyLogger.log("time = " + (end - start) + " result: " + sum);
    }
}
