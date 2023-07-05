package concurrecnyparallesim.executorservice;



import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ExecutorServiceExample {

    static ExecutorService executorService = Executors.newFixedThreadPool(4);
    public static void main(String[] args) throws InterruptedException, ExecutionException {



        /*
        // Example using Future in Executor Service
        Future<String> result;
        result = executorService.submit(()->{
            try {
                return helloWorldReturnFuture();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("From Main Thread " + Thread.currentThread());
        System.out.println(result.get());*/


        // Example executor service not returning anything
        executorService.submit(()->{
            try {
                helloWorld();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("From Main Thread " + Thread.currentThread());


        executorService.shutdown();

    }


    public static String helloWorldReturnFuture() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("helloWorldReturnFuture " + Thread.currentThread());
        return "hello world return future";
    }

    public static void helloWorld() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("helloWorldReturnFuture " + Thread.currentThread());
    }

}
