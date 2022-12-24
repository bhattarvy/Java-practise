package oops;

class TestDemo {
    int a;
    public int b;
    private int c;

    private static String name = "Arvind";

    static {
        name = "name is changes now what you gonna do";
    }

    public static String getStaticName() {
        System.out.println("Static function is called");
        return name;
    }

    TestDemo() {
        a=1;b=2;c=3;
    }
}

public class Test {

    public static void main(String[] args) {
        TestDemo  testDemo = new TestDemo();
        System.out.println(testDemo.a + " " + testDemo.b);

        System.out.println(TestDemo.getStaticName());

    }

}

