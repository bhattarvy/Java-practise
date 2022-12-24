package concurrecnyparallesim;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class Client {

    public List<String> getInfo() throws InterruptedException {
        Thread.sleep(1000);

        List<String> t = new ArrayList<>();
        for(int i=0; i<5; i++) {
            t.add("String no : " +i);
        }
        return t;
    }

    public List<String> getInfo2() throws InterruptedException {
        Thread.sleep(1000);

        List<String> t= new ArrayList<>();
        for(int i=0; i<5; i++) {
            t.add("2nd Thread getInfo"+ i);
        }
        return t;
    }

    public String helloWorld() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Hello world");

        return "Hello World";
    }



    public static void main(String[]  args) throws ExecutionException, InterruptedException, TimeoutException {

        long t =System.currentTimeMillis();



        Client client = new Client();

        /*ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<List<String>> f = executorService.submit(()-> {
            return client.getInfo();
        });

        Future<List<String> >  f2= executorService.submit(()->{
            return client.getInfo2();
        });

        System.out.println(System.currentTimeMillis()-t);



        List<String> ans = new ArrayList<>();
        List<String> ans2 = new ArrayList<>();
        try {
            ans = f.get(2, TimeUnit.SECONDS);
            ans2 = f2.get(2,TimeUnit.SECONDS);

        } catch (TimeoutException e){
            log.info("Timeout exception occured");
            executorService.shutdown();
        }
        System.out.println("time taken : "+  (System.currentTimeMillis()-t));
        System.out.println(ans);
        System.out.println(ans2);
        log.info("Time takes : {}" + (t -System.currentTimeMillis()));

        executorService.shutdown();*/


        CompletableFuture.supplyAsync(()->{
            try {
                return client.helloWorld();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).thenAccept((result)->{
            System.out.println("result generated " +  result);
        }).join();

        System.out.println("done");
        //Thread.sleep(2000);


    }


}
