package Java8.parallelstream;

import java.util.stream.IntStream;

public class ParallelStreamExample {


    public static void sum_sequential_stream(){
        long time = System.currentTimeMillis();
        System.out.println(IntStream.rangeClosed(1,10000).sum());
        System.out.println("Time Takem : " + (System.currentTimeMillis()-time));
    }


    public static void sum_parallel_stream(){
        long time = System.currentTimeMillis();
        System.out.println(IntStream.rangeClosed(1,10000).parallel().sum());
        System.out.println("Time Takem : " + (System.currentTimeMillis()-time));
    }


    public static void main(String[] args) {
        sum_parallel_stream();
        sum_parallel_stream();
    }

}
