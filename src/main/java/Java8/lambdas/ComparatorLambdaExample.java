package Java8.lambdas;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;






public class ComparatorLambdaExample {

    public static void main(String[] args) {


        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0; i<10; i++) {
            mp.put(i,i);
        }

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               if(mp.get(o1)>mp.get(o2))
                   return 100;
               else
                   return -100;
            }
        };

        Comparator<Integer> comp1 = (o1,o2)->{
            return Integer.compare(o1,o2);
        };
        System.out.println("Result of comparator : " + comp1);

        int[] arr = new int[]{3,2,1,4,5};


    }
}
