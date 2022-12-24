package testing;


public class ClassToBeTest {

    public String someMethod(int a, int b, String name) {
        System.out.println("a : " + a + " b :"+  b + " name: " + name);
        return "some method";
    }

    public void voidMethod(){
        System.out.println("void method");
    }
}
