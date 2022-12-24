package Java8;


import Java8.streams.StreamsExample;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {


    String name;
    double gradeLevel;
    List<String> activities;

    String lastName;

    public Student(String name,String lastName) {
        this.name =name;
        this.lastName =lastName;
    }

    public static List<Student> getStudents(){

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("arvind", 2, Arrays.asList("dancing","rapping","blinking"),""));
        studentList.add(new Student("rohit", 3.9, Arrays.asList("dancing","batting","blinking"),""));
        studentList.add(new Student("virat", 4,  Arrays.asList("dancing","cricket","blinking"),""));

        return studentList;
    }


}
