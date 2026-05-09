package parallel;

import java.util.concurrent.*;

import static util.MyLogger.log;

public class ParallelMain3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(4);

        SumTask sumTask1 = new SumTask(1, 4);
        SumTask sumTask2 = new SumTask(5, 8);

        Future<Integer> f1 = es.submit(sumTask1);
        Future<Integer> f2 = es.submit(sumTask2);

        int sum = f1.get() + f2.get();

        long end = System.currentTimeMillis();
        log("time: " + (end - start) + "ms, sum: " + sum);

        es.close();
    }

    static class SumTask implements Callable<Integer> {
        int startV;
        int endV;

        public SumTask(int startV, int endV) {
            this.startV = startV;
            this.endV = endV;
        }

        @Override
        public Integer call() throws Exception {
            log("task start");
            int sum = 0;
            for (int i = startV; i <= endV; i++) {
                sum += HeavyJob.heavyTask(i);
            }
            return sum;
        }
    }
}
