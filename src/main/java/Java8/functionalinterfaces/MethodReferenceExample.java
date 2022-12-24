package Java8.functionalinterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MethodReferenceExample
{


    static Function<String,String> toUpperCase = (s) -> {s=s.toUpperCase(); return s;};
    static Function<String,String> toUpperCaseMethodReference = String::toUpperCase;


    public static void main(String[] args) {



        List<String> tempStrings = new ArrayList<>(Arrays.asList("sdfn","sfnds","jfnsdf"));

        System.out.println(toUpperCase.apply("sjdfnds"));
        System.out.println(toUpperCaseMethodReference.apply("jsdbd"));


        tempStrings.forEach((name)->{
            name = toUpperCase.apply(name);
        });
        System.out.println(tempStrings);


    }

}
