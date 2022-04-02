package thread;

public class ThreadMain {

    public static void main(String[] args) {

        System.out.println("it is main thread");

        Thread threadInst = new Thread1();
        threadInst.run();


        System.out.println("this is main after thread run method");

    }
}
