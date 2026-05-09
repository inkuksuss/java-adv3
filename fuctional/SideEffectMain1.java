package fuctional;

import java.util.function.Function;

public class SideEffectMain1 {

    public static int cnt = 0;

    public static void main(String[] args) {
        System.out.println("before = " + cnt);

        Function<Integer, Integer> f = x -> {
            cnt++;
            return x * 2;
        };
        f.apply(5);
        System.out.println("after = " + cnt);

    }
}
