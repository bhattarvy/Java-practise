package concurrecnyparallesim;

import lombok.AllArgsConstructor;

import javax.swing.plaf.TableHeaderUI;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

    ExecutorService executorService = Executors.newFixedThreadPool(4);


    AgentInsight getAgentInsight(){

        System.out.println("main thread "+ Thread.currentThread());

        executorService.submit(()->{
            try {
                Thread.sleep(3000);
                System.out.println("this is executor service thread "+ Thread.currentThread());

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return new AgentInsight("Arvind","Bhatt");
    }

    void testThisScenario() throws InterruptedException {

        Map<String,AgentInsight> mp = new HashMap<>();
        //Map<String,AgentInsight> mp = Collections.synchronizedMap(new HashMap<String,AgentInsight>());

        List<Future> futureList = new ArrayList<>();

        long t= System.currentTimeMillis();
        for(int i=0; i<4; i++) {

            futureList.add(executorService.submit(()->{
                try{
                    Thread.sleep(1000);
                    System.out.println("this is " + Thread.currentThread());
                    mp.put(String.valueOf(Thread.currentThread()),new AgentInsight("fname"+String.valueOf(Thread.currentThread()),
                            "lname"+String.valueOf(Thread.currentThread())));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }));
        }

        Optional<Future> result = futureList.stream().filter((e)->{return !e.isDone();}).findAny();
        while(result.isPresent())
            result = futureList.stream().filter((e)->{return !e.isDone();}).findAny();
        /*executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }*/

        System.out.println("Time in ms : " + (System.currentTimeMillis()-t));
        for(Map.Entry<String,AgentInsight> e : mp.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue().fName+ " " +e.getValue().lName);
        }
    }




    public static void main(String[] args) throws InterruptedException {

        ExecutorServiceExample executorServiceExample = new ExecutorServiceExample();
        executorServiceExample.testThisScenario();
    }

}

@AllArgsConstructor
class AgentInsight {
    String fName,lName;

}
