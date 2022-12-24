package thread;

public class ThreadMain {

    public static void main(String[] args) {

        System.out.println("it is main thread");

        Thread threadInst = new Thread1();
        threadInst.start();
        System.out.println(threadInst.getState());


        Thread t2 = new Thread("new thread");
        t2.start();
        System.out.println(t2.getState());

        new Thread() {
            @Override
            public void run() {
                System.out.println("this is annonymous class thread");
            }
        }.start();

    }
}
