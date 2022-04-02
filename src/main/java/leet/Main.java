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

    public static void main(String[] args) {
        solve2180();

    }

}
