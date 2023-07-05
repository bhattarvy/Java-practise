package concurrecnyparallesim;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        HelloWorldService hws= new HelloWorldService();
        /*
        CompletableFuture.supplyAsync(()-> {
            try {
                return hws.helloWorld();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).thenAccept((e)->{
            System.out.println("result " + e);
        });

        System.out.println("Main Thread " + Thread.currentThread());
        Thread.sleep(2000);*/


        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()-> {
            try {

                return hws.hello();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(()-> {
            try {

                return hws.world();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        String ans = hello.thenCombine(world, (x,y)-> x+y).thenApply((e)-> e.toUpperCase()).join();
        System.out.println(ans);

    }



}

class HelloWorldService {

    ExecutorService executorService = Executors.newFixedThreadPool(4);

    public String helloWorld() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Hello world " + Thread.currentThread());
        return "Hellow World";
    }

    public String hello() throws InterruptedException {
        Thread.sleep(1000);
        return "Hello";
    }

    public String world() throws InterruptedException {
        Thread.sleep(1000);
        return "world";
    }
}
