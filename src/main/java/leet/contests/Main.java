package leet.contests;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        /*Contests contests = new Contests();
        contests.solve905();*/
        //solveCodeForces();
        Integer i = 4;
        callByValue(i);
        System.out.println(i);
    }

    public static void callByValue(Integer i) {
        i=6;
        System.out.println(i);
    }
    public static void solveCodeForces(){
        CodeForces codeForces = new CodeForces();
        codeForces.solve1703A();
    }


}
