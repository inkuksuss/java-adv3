package fuctional;

import java.util.function.Function;

public class SideEffectMain3 {


    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x * 2;
        Integer result = f.apply(5);
        System.out.println("result = " + result);
    }
}
