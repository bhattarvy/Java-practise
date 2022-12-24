package Java8.streams;

import Java8.Student;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMapExample {

    public static List<String> getNamesList() {
        List<Student> studentList = Student.getStudents();
        List<String> studentNames = studentList.stream().map(Student::getName).collect(Collectors.toList());
        return studentNames;
    }

    public static Set<String> getNamesSet() {
        List<Student> studentList = Student.getStudents();
        Set<String> namesSet = studentList.stream().map(Student::getName).map(String::toUpperCase).collect(Collectors.toSet());
        return namesSet;
    }


    public static void main(String[] args) {

        System.out.println(getNamesList());
        System.out.println(getNamesSet());

    }
}
