package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {


    public static void main(String[] args) {


        List<String> ls = new ArrayList<>();
        for(int i=0; i<5; i++){
            ls.add("holi"+ i);
        }

        // inner for loop
        // use consumer interface
        ls.forEach(
                (name) -> {
                    System.out.println(name);
                }
        );

    }
}
