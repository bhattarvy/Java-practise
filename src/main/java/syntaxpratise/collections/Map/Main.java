package syntaxpratise.collections.Map;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        test1();

        /*Map<String, Object> mapStringObject = getMapStringObject();
        System.out.println(mapStringObject);
        Map<String, List<String> > map = mapStringObject.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
                e->(List<String>)(e.getValue())));
        System.out.println(mapStringObject);
        System.out.println(map);
        map.forEach((e,k)->{
            k.forEach((t)->{
                System.out.println(t);
            });
        });*/
    }

    public static Map<String,Object> getMapStringObject(){
        Map<String,Object> mapStringObject = new HashMap<>();
        mapStringObject.put("sjfnd", Arrays.asList("jsdf","sfnd","sfdnf"));
        mapStringObject.put("arvind", Arrays.asList("jsdf","sfnd","sfdnf"));
        System.out.println();
        return mapStringObject;
    }

    public static void test1(){
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> t = map.getOrDefault(1, new ArrayList<>());
        t.add(1);
        map.put(1,t);
        map.get(1).add(4);
        System.out.println(map.get(1));
    }

}
