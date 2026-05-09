package fuctional;

import java.util.function.Function;

public class SideEffectMain2 {


    public static void main(String[] args) {

        Function<Integer, Integer> f = x -> {
            int result = x * 2;
            System.out.println("result = " + result * 2);
            return result;
        };
        f.apply(5);
        f.apply(5);

    }
}
