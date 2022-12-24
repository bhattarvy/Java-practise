package thread.course1;


import java.lang.Thread.UncaughtExceptionHandler;

public class main {

    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            System.out.println("Thread name :" + Thread.currentThread().getName() + "Thread Priority" +
                               Thread.currentThread().getPriority());
//            throw new RuntimeException("Intentional Exception");
        });

        // thread.setPriority(Thread.MAX_PRIORITY);
        /*thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " Uncaught Exception Occured");
            }
        });*/

        thread.start();
        /*try {
            thread.start();
        } catch (RuntimeException e){
            System.out.println("Exception occured");
        }*/
        /*System.out.println("Main Thread " + Thread.currentThread().getName() + "Thread Priority : " +
                           Thread.currentThread().getPriority());

        NewThread newThread = new NewThread();
        newThread.start();*/
    }

    public static class NewThread extends Thread {

        @Override
        public void run() {
            System.out.println("This Thead is class based " + Thread.currentThread().getName());
        }
    }
}
