package parallel;

import static util.MyLogger.log;

public class ParallelMain2 {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        SumTask sumTask1 = new SumTask(1, 4);
        SumTask sumTask2 = new SumTask(5, 8);

        Thread t1 = new Thread(sumTask1);
        Thread t2 = new Thread(sumTask2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        int sum = sumTask1.result + sumTask2.result;

        long end = System.currentTimeMillis();
        log("time: " + (end - start) + "ms, sum: " + sum);
    }

    static class SumTask implements Runnable {
        int startV;
        int endV;
        int result = 0;

        public SumTask(int startV, int endV) {
            this.startV = startV;
            this.endV = endV;
        }

        @Override
        public void run() {
            log("task start");
            int sum = 0;
            for (int i = startV; i <= endV; i++) {
                sum += HeavyJob.heavyTask(i);
            }
            result = sum;
            log("task end result = " + result);
        }
    }
}
