package parallel.forkjoin;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static util.MyLogger.log;

public class CompletableFutureMain {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> log("ForkJoin"));

        ExecutorService es = Executors.newFixedThreadPool(100);
        CompletableFuture.runAsync(() -> log("Custom pool"), es);
        Thread.sleep(100);
        es.close();
    }
}
