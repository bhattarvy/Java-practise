package Java8.lambdas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaVariable implements Runnable {

    int instanceVariable;

    public static void main(String[] args) {


        Student student = new Student("arvind",23);
        Function<Student, Integer> function = (student1 -> {
            return student.rollno;
        });

        System.out.println(function.apply(student));



        /*LambdaVariable lambdaVariable = new LambdaVariable();
        lambdaVariable.instanceVariable=6;

        new Thread(lambdaVariable).start();
        new Thread(lambdaVariable).start();*/

       /* int  i =0;
        Consumer<Integer> integerConsumer = (i1) -> {
            int localVariable = 6;
            System.out.println("lambda Vairbale : " + localVariable);
            localVariable=5;

            System.out.println("lambda variable : " + localVariable);
            System.out.println("Local Variable : "+ (i+i1));
        };
        i=6;
        integerConsumer.accept(4);*/
    }

    @Override
    public void run() {
        int localVar = (int)(Math.random()*1000);
        System.out.println(Math.random());
        instanceVariable = (int)(Math.random()*1000);
        System.out.println("Runnbale Thread " + instanceVariable + " local varibale " + localVar);
    }

    @Data
    @AllArgsConstructor
    static class Student {
        String name;
        int rollno;
    }
}


