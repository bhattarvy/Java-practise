package Java8.functionalinterfaces;

import Java8.Student;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {

        BiConsumer<String, String> biConsumer = (a,b) -> System.out.println("a : "+a+" b: "+b);

        List<Student> studentList = Student.getStudents();
        // studentList.forEach((student -> biConsumer.accept(student.getName(),student.getLastname())));
    }
}
