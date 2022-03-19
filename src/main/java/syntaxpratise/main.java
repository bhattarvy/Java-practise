package syntaxpratise;

import java.util.Scanner;

public class main {

    private static Scanner sc = new Scanner(System.in);

    public static void testCode() {
        int[] test=  new int[6];
        for(int i=0; i<test.length; i++) {
            System.out.println(test[i]);
        }
    }

    public static void solve1() {
        int n=sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i]=sc.nextInt();
        }
        int[] prefix =new int[n];
        for(int i=0; i<n; i++) {
            if(i==0)
                prefix[i]=arr[i];
            else
                prefix[i]=arr[i]+prefix[i-1];
        }

        for(int i=0; i<n; i++)
            System.out.println(prefix[i]);

        System.out.println("ajsdb");
        int sum=0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j+=2) {

                int x=i-1;
                if(x<0){
                    sum+=prefix[j];
                } else{
                    sum+=(prefix[j]-prefix[x]);
                }
                System.out.println(sum);
            }
        }
        System.out.println(sum);
    }

    public static void solve1266() {

        int n=sc.nextInt();
        int[][] points = new int[n][2];

        for(int i=0; i<n; i++) {
            points[i][0]=sc.nextInt();
            points[i][1]=sc.nextInt();
        }

        int sum=0;
        for(int i=0; i<n; i++) {
            sum+=Math.max(Math.abs(points[i+1][0]-points[i][0]), Math.abs(points[i+1][1]-points[i][1]));
        }
        System.out.println(sum);

    }

    public static void main(String[] args) {
        System.out.println("this is coming");
        solve1266();
    }

}
