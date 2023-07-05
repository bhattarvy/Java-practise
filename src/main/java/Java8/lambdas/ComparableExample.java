package Java8.lambdas;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample implements Comparable<Student>{

    Student student;

    public static void main(String[] args) {


        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("arvind",34));
        studentList.add(new Student("hack",19));
        studentList.add(new Student("Pack",20));
        Collections.sort(studentList);

        System.out.println(studentList);
    }

    @Override
    public int compareTo(Student student) {
       if(student.getAge() == this.student.getAge())
           return 0;
       else if(student.getAge() > this.student.getAge())
           return 1;
       else if (student.getAge() < this.student.getAge())
           return -1;
       return 0;
    }
}


@Data
@AllArgsConstructor
class Student implements Comparable<Student> {
    String name;
    int age;

    @Override
    public int compareTo(Student student) {
        if(student.getAge() == this.getAge())
            return 0;
        else if(student.getAge() > this.getAge())
            return 1;
        else if (student.getAge() < this.getAge())
            return -1;
        return 0;
    }
}
