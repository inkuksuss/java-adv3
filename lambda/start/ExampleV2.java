package lambda.start;


public class ExampleV2 {


    public static MyTransformer compose(MyTransformer f1, MyTransformer f2) {
        return input -> f2.transform(f1.transform(input));
    }

    public static void main(String[] args) {
        MyTransformer toUpper = s -> s.toUpperCase();
        MyTransformer addDeco = s -> "**" + s + "**";

        String input = "input";

        String result = compose(toUpper, addDeco).transform(input);
        System.out.println("result = " + result);
    }
}
