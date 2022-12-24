package leet.hashmaps;

import javafx.util.Pair;
import leet.Leet2;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String,Integer> mp = new HashMap<>();
        System.out.println(mp.get("afsd"));
        return;

        /*Leet1 leet1 = new Leet1();
        leet1.solve2349();*/
    }

    public static void checkMap(){

        Map<Character,Integer> map1=  new HashMap<>();
        Map<Character,Integer> map2=  new HashMap<>();

        for(char i='a' ; i<='c'; i++){
            map1.put(i,1);
            map2.put(i,1);
        }

        map2.put('d',1);
        map2.put('d',map2.get('d')-1);

        map1.forEach((entry,value)->{
            System.out.println(entry + " -> " +value);
        });

        map2.forEach((entry,value)->{
            System.out.println(entry + " -> " +value);
        });

        map2.remove('d',0);

        System.out.println(map2.equals(map1));
    }


    public static void checkPairEquals(){
        Pair<Integer,Integer> p1= new Pair<>(3,5);
        Pair<Integer,Integer> p2= new Pair<>(3,5);
        System.out.println(p1.equals(p2));

        Map<Pair<Integer,Integer>, Integer> map = new HashMap<>();
        map.put(p1,1);
        map.put(p2,2);
        System.out.println("---");
        map.forEach((e,v)->{
            System.out.println(e.getKey() + "-> "+ e.getValue()  + " -> " + v);
        });
    }


}
