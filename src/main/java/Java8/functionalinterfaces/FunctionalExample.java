package Java8.functionalinterfaces;

import javax.lang.model.element.NestingKind;
import java.util.function.Function;

public class FunctionalExample {

    static Function<String,String> toUpperCase = (name) -> {return name.toUpperCase();};
    static Function<String, String> concatString = (name) -> {return name.toUpperCase().concat("lastname");};

    public static void main(String[] args) {

        String name ="Arvind";
        System.out.println(toUpperCase.apply(name));
        System.out.println(toUpperCase.andThen(concatString).apply(name));
        System.out.println(toUpperCase.compose(concatString).apply(name));
    }

}
