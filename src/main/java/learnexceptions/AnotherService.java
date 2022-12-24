package learnexceptions;

public class AnotherService {



    int  callService2(){
        return Service2.divideByZero();
    }

    int getException() throws IllegalAccessException {
        try {
            throw new IllegalAccessException();
        } catch (IllegalAccessException e) {
            System.out.println("Another Service Exception : "+ e);
            throw e;
        }
    }

}
