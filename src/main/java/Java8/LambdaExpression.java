package Java8;


import java.util.function.Function;

interface FunctionalInterface {
    void show();
}

public class LambdaExpression {

    public static void main(String[] args) {

        FunctionalInterface fn1 = new FunctionalInterface() {
            @Override
            public void show() {
                System.out.println("its show time");
            }
        };

        FunctionalInterface fn2 = () -> {
            System.out.println("its fn2 show time");
        };

        fn1.show();
        fn2.show();


    }
}
