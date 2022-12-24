package Java8.functionalinterfaces;

import Java8.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {



    static List<Student> getNames()   {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("arvind","bhatt"));
        studentList.add(new Student("rajani","bhatt"));
        studentList.add(new Student("delhi","bombay"));

        return studentList;
    }


    public static void main(String[] args) {
        Consumer<Student> c1 = (student) -> System.out.print(student.getName()+ " ");
        Consumer<Student> c2 = (student) -> System.out.println(student.getLastName());
        Consumer<Student> c3 = (student) -> System.out.println(student);

        List<Student> names = ConsumerExample.getNames();
        names.forEach(c1);
        System.out.println("--------");
        names.forEach(c2);
        System.out.println("--------");
        names.forEach(c3);

        names.forEach(c1);

        names.forEach(c1.andThen(c2));

        names.forEach((student)->{
            c1.accept(student);
            c2.accept(student);
        });


        names.forEach((student) -> {
            if(student.getName()!="arvind")
                c1.andThen(c2).accept(student);


        });
    }


}
