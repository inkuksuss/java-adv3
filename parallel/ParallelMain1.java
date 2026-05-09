package parallel;

import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain1 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int sum = IntStream.rangeClosed(1, 8)
                .map(i -> HeavyJob.heavyTask(i))
                .reduce(0, Integer::sum);

        long end = System.currentTimeMillis();
        log("time: " + (end - start) + "ms, sum: " + sum);
    }
}
