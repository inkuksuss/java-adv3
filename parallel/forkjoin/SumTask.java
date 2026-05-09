package parallel.forkjoin;

import parallel.HeavyJob;

import java.util.List;
import java.util.concurrent.RecursiveTask;

import static util.MyLogger.*;

public class SumTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;

    private final List<Integer> list;

    public SumTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {
        if (list.size() <= THRESHOLD) {
            log("task start " + list);
            int sum = list.stream()
                    .mapToInt(HeavyJob::heavyTask)
                    .sum();
            log("task end = " + list + " -> sum: " + sum);
            return sum;
        }
        else {
            int mid = list.size() / 2;
            List<Integer> left = list.subList(0, mid);
            List<Integer> right = list.subList(mid, list.size());

            SumTask leftT = new SumTask(left);
            SumTask rightT = new SumTask(right);

            leftT.fork();
            Integer rightRs = rightT.compute();
            Integer leftRs = leftT.join();

            log("ls: " + leftRs + " rs: " + rightRs);
            return leftRs + rightRs;
        }
    }
}
