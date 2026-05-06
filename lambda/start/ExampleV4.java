package lambda.start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExampleV4 {

    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        List<Integer> result = list.filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .toList();

        System.out.println("result = " + result);
    }

    static class MyList<T> {

        private List<T> list;

        public MyList(List<T> list) {
            this.list = list;
        }

        public MyList<T> filter(Predicate<T> predicate) {
            List<T> result = new ArrayList<>();
            for (T i : this.list) {
                if (predicate.test(i)) result.add(i);
            }
            this.list = result;
            return this;
        }

        public MyList<T> map(Function<T, T> function) {
            List<T> result = new ArrayList<>();
            for (T i : this.list) {
                result.add(function.apply(i));
            }
            this.list = result;
            return this;
        }

        public List<T> toList() {
            return this.list;
        }
    }
}
