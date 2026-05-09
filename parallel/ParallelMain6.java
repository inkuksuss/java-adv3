package parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain6 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService requestPool = Executors.newFixedThreadPool(100);
        ExecutorService logicPool = Executors.newFixedThreadPool(400);

        int nThreads = 3;
        for (int i = 1; i <= nThreads; i++) {
            String request = "request" + i;
            requestPool.submit(() -> logic(request, logicPool));
            Thread.sleep(100);
        }

        requestPool.close();
    }

    private static void logic(String request, ExecutorService logicPool) {
        log("[" + request + "] START");
        long start = System.currentTimeMillis();

        Future<Integer> f1 = logicPool.submit(() -> HeavyJob.heavyTask(1, request));
        Future<Integer> f2 = logicPool.submit(() -> HeavyJob.heavyTask(2, request));
        Future<Integer> f3 = logicPool.submit(() -> HeavyJob.heavyTask(3, request));
        Future<Integer> f4 = logicPool.submit(() -> HeavyJob.heavyTask(4, request));

        int sum = 0;
        try {
            sum = f1.get() + f2.get() + f3.get() + f4.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        log("[" + request + "] time: " + (end - start) + " sum: " + sum);
        logicPool.close();
    }
}
