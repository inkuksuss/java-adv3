package parallel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain7 {

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

        List<Future<Integer>> futures = IntStream.rangeClosed(1, 4)
                .mapToObj(i -> logicPool.submit(() -> HeavyJob.heavyTask(i, request)))
                .toList();

        int sum = futures.stream()
                .mapToInt((f) -> {
                    try {
                        return f.get();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).sum();

        long end = System.currentTimeMillis();
        log("[" + request + "] time: " + (end - start) + " sum: " + sum);
        logicPool.close();
    }
}
