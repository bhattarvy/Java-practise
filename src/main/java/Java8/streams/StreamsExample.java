package Java8.streams;

import Java8.streams.beans.PhoneInfo;
import Java8.streams.beans.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsExample {


    public static void main(String[] args) {


        StreamsExample streamsExample = new StreamsExample();
        streamsExample.findFirstStream();


        /*List<Integer> studentList = Arrays.asList(1,2,3);

        int t =studentList.stream().filter((e)-> e==4).findFirst().get();

        System.out.println(t);*/



        /*
        student student = new student();
        List<student> studentList = student.getStudents();


        *//*Map<String, List<String> > map =studentList.stream().
                filter((student1 -> student1.getGradeLevel()>3))
                .collect(Collectors.toMap(StreamsExample.student::getName, StreamsExample.student::getActivities));
        System.out.println(map);*//*

        List<String> list1 = studentList.stream().filter(student1 -> student1.getGradeLevel()>3).sorted((student1,student2)-> {
                    if(student1.getGradeLevel()>student2.getGradeLevel())
                        return 1;
                    else
                        return 0;
                }).peek(student1 -> System.out.println(student1.getName()))
                        .map(student1 -> student1.getName()).collect(Collectors.toList());




        list1.forEach((key)->{
            System.out.println(key);
        });*/

    }

    public void findFirstStream(){

        /*Student s1 = new Student();
        s1.setName("Arvind");
        s1.setRollNo(123);
        List<PhoneInfo> phoneInfoList = Arrays.asList(new PhoneInfo("123",true), new PhoneInfo("234",true));
        phoneInfoList.get(0).setCheckInfo(null);
        phoneInfoList.get(1).setCheckInfo(true);
        s1.setPhoneInfoList(phoneInfoList);
        //s1.setPhoneInfoList(null);


        System.out.println("-----");
        nullSafeCollection(s1.getPhoneInfoList()).stream().filter(e->(e.getCheckInfo()!=null && e.getCheckInfo())).peek((e)-> System.out.println(e)).findFirst().ifPresent((e)-> e.setPresentInNDNCList(true));

        System.out.println("-----");
        s1.getPhoneInfoList().forEach((e)->{
            System.out.println(e.toString());
        });*/
    }


    public static <T> List<T> nullSafeCollection(Collection<T> collection) {

        return collection != null ? new ArrayList<T>(collection) : new ArrayList<T>();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class student{

        String name;
        double gradeLevel;
        List<String> activities;

        List<student> getStudents(){

            List<student> studentList = new ArrayList<>();

            studentList.add(new student("arvind", 2, Arrays.asList("dancing","rapping","blinking")));
            studentList.add(new student("rohit", 3.9, Arrays.asList("dancing","batting","blinking")));
            studentList.add(new student("virat", 4,  Arrays.asList("dancing","cricket","blinking")));

            return studentList;
        }
    }

}




