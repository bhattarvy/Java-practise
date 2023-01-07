package syntaxpratise.collections.PriorityQueue;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Main {

    private final static Random random = new Random();

    public static void main(String[] args) {
        System.out.println(Main.class.getName());
        testPriorityQueue();
    }

    private static void randomeTests() {
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer integer, Integer t1) {
                int x= Main.random.nextInt();
                System.out.println(x);
                return x%2;
            }
        });

        Queue<Pair<Integer,Integer>> queuePair = new PriorityQueue<Pair<Integer,Integer>>(new Comparator(){

            @Override
            public int compare(Object o, Object t1) {
                Pair<Integer,Integer> p1 = (Pair<Integer,Integer>)o;
                Pair<Integer,Integer> p2 = (Pair<Integer,Integer>)t1;
                System.out.println(p1.getKey() + " : " +p1.getValue() + " --- " + p2.getKey() + ": " +p2.getValue() );
                System.out.println(getCompareResult(p1,p2));
                return getCompareResult(p1,p2);
            }

            public int getCompareResult(Pair<Integer, Integer> p1, Pair<Integer,Integer> p2 ){
                if(p1.getValue() > p2.getValue()){
                    return 1;
                } else if(p1.getValue()==p2.getValue()){
                    if(p1.getKey()>p2.getKey())
                        return 1;
                    else
                        return 1;
                } else {
                    return 0;
                }
            }
        });
        for(int i=0; i<=5; i++){
            if(i==5)
                queuePair.add(Pair.of(3,5));
            else
                queuePair.add(Pair.of(i,i+1));
        }

        queuePair.forEach((e )->{
            System.out.println(e.getKey() + " : " + e.getValue());
        });


        for(int i=1; i<=5; i++){
            queue.add(i);
        }

        queue.forEach((e)->{
            System.out.println(e);
        });
    }

    public static void testPriorityQueue() {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<5; i++)
            pq.add(i);

        pq.forEach((e)->{
            System.out.println(e);
        });

        System.out.println("----");

        /*System.out.println(pq.peek());
        System.out.println(pq.poll());
        pq.forEach((e)->{
            System.out.println(e);
        });
        */

        for(int i=5; i<=10; i++){
            if(pq.size()==5){
                System.out.println(pq.peek());
                if(pq.peek()<i){
                    pq.poll();
                    pq.add(i);
                }
            }
        }
        pq.forEach((e)->{
            System.out.print(e+ " ");
        });
    }
}
