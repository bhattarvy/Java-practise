package Java8.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {


    public List<Student> getSomeStudents() {
      List<Student> students = new ArrayList<>();
      populateStudent(students);
      return students;
    }

    public Optional<List<Student>> getSomeStudentsWhenNull() {
        List<Student> students = null;
        populateStudent(students);

        return Optional.ofNullable(students);
    }


    private void populateStudent(List<Student> students) {
        if(students!=null) {
            for (int i = 0; i < 5; i++) {
                students.add(new Student("name" + i, i));
            }
        }
    }
}
