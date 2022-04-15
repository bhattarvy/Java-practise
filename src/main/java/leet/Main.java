package leet;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
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

    public static void solve2221() {

        int n=sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i]=sc.nextInt();
        }



        for(int j=n-1; j>0; j--) {
            for(int i=0; i<j; i++){
                nums[i]=(nums[i]+nums[i+1])%10;
            }
        }
        System.out.println(nums[0]);

    }


    public static void solve2222() {
        String s=sc.next();

        int size1endson1=0;
        int size1endson0=0;
        int size2endson1=0;
        int size2endson0=0;

        int count =0;
        for(int i=0; i<s.length(); i++) {

            if(s.charAt(i)=='1'){
                count += size2endson0;
                size1endson1++;
                size2endson1+=size1endson0;

            } else {
                count += size2endson1;
                size1endson0++;
                size2endson0+=size1endson1;
            }
        }

        System.out.println(count);
    }




    public static void main(String[] args) {

        forTesting();
    }


    public static void forTesting() {
        Map<String, Customer> customerMap = new HashMap<>();

        for(int i=0; i<5; i++) {
            customerMap.put(String.valueOf(i),new Customer("i","i "+"lastname","i "+"customerid"));
        }

        // foreach


        //forloop

        for(Customer customer : customerMap.values()) {
            customer.setName("Arvind");
        }

        System.out.println(customerMap.toString());



    }

    @AllArgsConstructor
    @Data
    static class Customer {
        String name;
        String lastName;
        String customerId;

    }

}
