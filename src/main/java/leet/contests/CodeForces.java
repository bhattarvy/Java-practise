package leet.contests;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeForces {


    public void solve1703A(){

        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();

        Set<String> st = new HashSet<>();

        while(t-- > 0){
            String s = sc.next();
            s = s.toUpperCase();
            if (s.equals("YES")) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void main(String[] args) {
        CodeForces codeForces = new CodeForces();
        codeForces.solve1703A();
    }
}

