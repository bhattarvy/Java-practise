package Java8.optional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class Main {


    public static void main(String[] args) {

        StudentService service = new StudentService();
        /*List<Student> studentList = service.getSomeStudentsWhenNull();
        studentList.forEach(e->{
            System.out.println(e.getName() + " " + e.getRollNo());
        });*/

        Optional<List<Student>> studentListOptional = service.getSomeStudentsWhenNull();
        studentListOptional.ifPresent((e)->{
            for (Student t : e) {
                System.out.println(t.getName() +  " " + t.getRollNo());
            }
        });

        if(studentListOptional.isPresent()){
            List<Student> students = studentListOptional.get();
            students.forEach((e)->{
                System.out.println(e.getName()+" "+e.getRollNo());
            });
        }

    }
}
