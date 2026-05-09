package parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain5 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");

        ExecutorService es = Executors.newFixedThreadPool(100);
        int nThreads = 20;
        for (int i = 1; i <= nThreads; i++) {
            String request = "request" + i;
            es.submit(() -> logic(request));
            Thread.sleep(100);
        }

        es.close();
    }

    private static void logic(String request) {
        log("[" + request + "] START");
        long start = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 4)
                .parallel()
                .map(i -> HeavyJob.heavyTask(i, request))
                .reduce(0, Integer::sum);


        long end = System.currentTimeMillis();

        log("[" + request + "] time: " + (end - start) + " sum: " + sum);
    }
}
