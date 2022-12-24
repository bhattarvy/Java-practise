package string;

import java.util.*;
import java.util.stream.Collectors;

public class Basic {


    public static void main(String[] args) {

        StringBuffer t = new StringBuffer();
        System.out.println("---");
        System.out.println(t.reverse().toString());
        System.out.println("----");

        Map<String, String> mp = new HashMap<>();
        mp.put("sfd","dealerud");

        List<String> t1 = Arrays.asList("sfd","dgfngj","fgnjf");

        List<String> t2= t1.stream().map((e)->{return mp.getOrDefault(e,e);}).collect(Collectors.toList());
        System.out.println(t2);
    }

}
