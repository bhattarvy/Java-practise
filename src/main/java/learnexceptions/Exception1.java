package learnexceptions;

import java.io.IOException;

public class Exception1 {

    public static Exception1  getException1() {
        return new Exception1();
    }

    public void exceptionCase1() {

        System.out.println("reached here so far");
        int x=23;
        try {
            int y= x/0;
        } catch (NullPointerException e) {
            System.out.println(e);

        }
        finally {
            System.out.println("finally block is getting executed");
        }

        m();

/*        int[] num= null;
        System.out.println(num.length);

        System.out.println("after exception gen");*/
    }


    public  void m(){
        n();
    }
    public void n()  {

        throw new java.lang.ArithmeticException("sdf");
    }
}
