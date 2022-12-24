package learnexceptions;

import java.sql.SQLOutput;

public class ExceptionExample1 {


    int testException() {
        AnotherService anotherService = new AnotherService();
        return anotherService.callService2();
    }

    int testException2() {
        try {
            return (10 / 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("exception occured");
            System.out.println(e);
        }
        System.out.println("after  try catch");
        return 0;
    }

    int testException3() {
        AnotherService anotherService = new AnotherService();
        try {
            anotherService.getException();
        } catch (IllegalAccessException e) {
            System.out.println("ExceptionExample1 testExeption3 :"+ e);
        }
        return 0;
    }

    void testException4() throws CustomException1 {
        try{
            throw new CustomException1("Custome Exception 1");
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    void testException5() {
        try {
            throw new CustomException2("Custom Exception 2");
        } catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }

    public static void main(String[] args) {

        ExceptionExample1 exceptionExample1 = new ExceptionExample1();
//        System.out.println(exceptionExample1.testException());
        exceptionExample1.testException3();

    }

}
