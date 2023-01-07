package thread.course1;

import jogamp.nativewindow.NWJNILibLoader;
import lombok.extern.slf4j.Slf4j;

import java.io.Console;
import java.util.logging.ConsoleHandler;

@Slf4j
public class main {

    public static void main(String[] args) throws InterruptedException {

        /*Thread thread = new Thread(()->{
            System.out.println("Thread name :" + Thread.currentThread().getName() + "Thread Priority" +
                               Thread.currentThread().getPriority());
//            throw new RuntimeException("Intentional Exception");
        });

        System.out.println("sjdfbgjfdbs");

        thread.setPriority(Thread.MAX_PRIORITY);
        try {
            thread.start();
        } catch (RuntimeException e){
            log.info("Exception :: {}", e);
            System.out.println("Exception occured");
        }
        System.out.println("Main Thread " + Thread.currentThread().getName() + "Thread Priority : " +
                           Thread.currentThread().getPriority());

        NewThread newThread = new NewThread();
        newThread.start();


        BlockingTask blockingTask = new BlockingTask();
        Thread thread2 = new Thread(blockingTask);
        thread2.start();*/


        Thread thead3 = new Thread(new BlockingTask());
        thead3.start();
        try {
            thead3.interrupt();
        } catch (Exception e){
            System.out.println("Thead3 is finished here");
        }

        System.out.println("Main is terminating here");
        Thread.sleep(5000);
        System.out.println("Main is still running");
    }

    public static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("New Thread is runnning : "+ Thread.currentThread().getName());
            newThreadRandomFunction();
        }
        public void newThreadRandomFunction() {
            System.out.println("New thread random function");
        }
    }

    public static class BlockingTask implements Runnable {
        @Override
        public void run() {

            try {
                System.out.println("Logng Blocking task is running");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Blocking Task Thread : " + Thread.currentThread().getName());
        }
    }
}
