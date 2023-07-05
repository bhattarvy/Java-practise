package Java8.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsExample2 {

    public static void main(String[] args) {

        reduceMin();
        /*
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("arvind",32, Arrays.asList("sfjd","sknf","sjfbaifsf")));
        studentList.add(new Student("jack",12, Arrays.asList("ssffjd","sfdfknf","sjaafbaifsf")));
        studentList.add(new Student("harry",52, Arrays.asList("sqwefjd","sktrtnf","sqwjeqfbaifsf")));

        *//*Set<String> names =
                studentList.stream().map(Student::getName).map(String::toUpperCase).collect(Collectors.toSet());
        names.forEach((e)->{
            System.out.println(e);
        });*//*


        List<String> namesList =
                studentList.stream().map(Student::getActivites).flatMap(List::stream).sorted((String t1, String t2 )->{
                    return (Integer.compare(t1.length(), t2.length()));
                }).collect(Collectors.toList());

        namesList.forEach((e)->{
            System.out.println(e);
        });*/
    }

    private static void reduceExample(){
        List<Integer> numbers = Arrays.asList(1,3,4,5,6,7,8,9);
        Optional<Integer> optionalInteger = numbers.stream().reduce((a,b)->{
            System.out.println("a : "+a +" , b: "+b);
            if(b%2==1){
                return a+b;
            } else {
                return a;
            }
        });

        List<Integer> numbersList = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> optionalNumbers = numbersList.stream().reduce((a,b)->{
            return a+b;
        });
        if(optionalNumbers.isPresent()){
            optionalInteger.get();
        }

    }

    private static void reduceMax(){
        List<Integer> numbers = Arrays.asList(4,2,5,2,5,7,3);
        Optional<Integer> min = Optional.of(numbers.stream().reduce(Integer.MIN_VALUE, (a, b) -> (a >= b ? a : b)));
        if (min.isPresent()) {
            System.out.println(min.get());
        }
    }

    private static void reduceMin(){
        List<Integer> numbers = Arrays.asList(1,4,3,2,5,2,7,-1,3);
        Optional<Integer> ans = Optional.of(numbers.stream().reduce(Integer.MAX_VALUE, (a, b) -> {
            return (a >= b ? b : a);
        }));
        if (ans.isPresent()) {
            System.out.println(ans.get());
        }
    }


}

@Data
@AllArgsConstructor
@RequiredArgsConstructor
class Student{
    final String name;
    final int rollno;

    List<String> activites;
}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String s, String t1) {
        if(s.length()>t1.length())
            return 1;
        else if(s.length()<t1.length())
            return -1;
        else
            return 0;
    }
}