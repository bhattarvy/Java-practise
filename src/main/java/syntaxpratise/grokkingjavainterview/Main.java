package syntaxpratise.grokkingjavainterview;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.calStaticMethods();

    }

    void calStaticMethods(){

        A.staticMethod();
        B.staticMethod();
    }

}


class A {
    public static final void staticMethod(){
        System.out.println("Static method of A");
    }

    public void nonStatic(){
        System.out.println("A non static method");
    }
    public final void finalMethod(){
        System.out.println("A final Method");
    }
}

class B extends  A {

    /*public static void staticMethod(){
        System.out.println("Static method of B");
    }*/

//    public static void nonStatic(){
//        System.out.println("B non static method");
//    }


    public static void normalMethod(){
        System.out.println("Normal Method");
    }
}


