package methodref.start;

import java.util.function.BinaryOperator;

public class MethodRefStartV1 {

    public static void main(String[] args) {
        BinaryOperator<Integer> add1 = MethodRefStartV1::add;
        BinaryOperator<Integer> add2 = MethodRefStartV1::add;

        Integer apply1 = add1.apply(1, 2);
        System.out.println("apply1 = " + apply1);
        Integer apply2 = add2.apply(2, 2);
        System.out.println("apply2 = " + apply2);
    }

    static int add(int x, int y) {
        return x + y;
    }
}
