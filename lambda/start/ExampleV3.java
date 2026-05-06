package lambda.start;


import java.util.ArrayList;
import java.util.List;

public class ExampleV3 {


    public static MyTransformer compose(MyTransformer f1, MyTransformer f2) {
        return input -> f2.transform(f1.transform(input));
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        List<String> result = map(list, input -> input.toString());
        System.out.println(result);
    }

    public static List<String> map(List<Integer> list, MyMap<Integer, String> myMap) {
        ArrayList<String> result = new ArrayList<>();
        for (Integer o : list) {
            String map = myMap.map(o);
            result.add(map);
        }
        return result;
    }


    @FunctionalInterface
    interface MyMap<T, R> {
        R map(T input);
    }
}
