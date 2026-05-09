package fuctional;

import java.util.function.Function;

public class PureFunctionMain1 {

    public static void main(String[] args) {
        Function<Integer, Integer> square = x -> x * 2;
        System.out.println(square.apply(5));
    }
}
