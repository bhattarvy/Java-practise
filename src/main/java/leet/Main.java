package leet;

import java.util.Scanner;

public class Main {

    public static Scanner sc=new Scanner(System.in);

    public static void solve2180(){
        int n= sc.nextInt();
        int countEven=0;
        for(int i=1; i<=n; i++) {
            int x=i;
            int sum=0;
            while(x>0) {
                sum+=x%10;
                x/=10;
            }
            if(sum%2==0) {
                countEven++;
            }
        }

        System.out.println(countEven);
    }

    public static void solve2220() {
        int start , end;
        start=sc.nextInt();
        end =sc.nextInt();

        int count =0;
        while(start>0 || end>0) {
            if((start&1) != (end&1)){
                count++;
            }

            start=(start>>1);
            end>>=1;
            System.out.println(start+" "+end);
        }
        System.out.println(count);

        /*
        * 10 7
        * 3
        *
        *
        * */
    }

    public static void main(String[] args) {
        solve2220();

    }

}
