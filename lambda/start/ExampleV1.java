package lambda.start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleV1 {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-3, -2, -1, 1, 2, 3, 5));
        MyFilter myFilter = new MyFilter();

        // get minus
//        List<Integer> minus = myFilter.filter(list, (v) -> v < 0);
        List<Integer> minus = myFilter.filter(list, v -> new MinusPredicate().test(v));
        System.out.println("minus = " + minus);

        // get even
//        List<Integer> even = myFilter.filter(list, (v) -> v % 2 == 0);
        List<Integer> even = myFilter.filter(list, v -> new EvenPredicate().test(v));
        System.out.println("even = " + even);

    }


    private static class MyFilter {
        public List<Integer> filter(List<Integer>list, MyPredicate predicate) {
            return list.stream()
                    .filter(predicate::test)
                    .toList();
        }
    }

    static class EvenPredicate implements MyPredicate {
        public boolean test(Integer v) {
            return v % 2 == 0;
        }
    }

    static class MinusPredicate implements MyPredicate {
        public boolean test(Integer v) {
            return v < 0;
        }
    }
}
