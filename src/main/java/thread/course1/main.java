package thread.course1;

import lombok.extern.slf4j.Slf4j;

import java.io.Console;
import java.util.logging.ConsoleHandler;

@Slf4j
public class main {

    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            System.out.println("Thread name :" + Thread.currentThread().getName() + "Thread Priority" +
                               Thread.currentThread().getPriority());
            throw new RuntimeException("Intentional Exception");
        });

        thread.setPriority(Thread.MAX_PRIORITY);
        try {
            thread.start();
        } catch (Exception e){
            log.info("Exception :: {}", e);
            System.out.println("Exception occured");
        }
        System.out.println("Main Thread " + Thread.currentThread().getName() + "Thread Priority : " +
                           Thread.currentThread().getPriority());
    }
}
