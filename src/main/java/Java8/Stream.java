package Java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
class Product {

    int id;
    String name;
}

public class Stream {


    public static void main(String[] args) {

        Product[] p = new Product[5];
        for(int i=0 ;i<5; i++){
            p[i]= new Product(i,(String)("yeah"+i));
        }

        List<Product> p1 = new ArrayList<>();
        for(int i=0; i<5; i++) {
            p1.add(new Product(i,"yeah"+i));
        }

        List<String> p2 = p1.stream().filter( (t) -> t.id >2).map( (t) -> t.name).collect(Collectors.toList());
        p2.forEach( t -> {
            System.out.println(t);
        });

        p1.stream().filter( t -> t.id>=2).forEach( t -> {
            System.out.println(t);
        });
    }
}
