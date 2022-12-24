package leet.contests;

import org.apache.commons.lang3.ArrayUtils;
import sun.security.util.ArrayUtil;

import java.util.*;

import static java.util.Collections.copy;
import static java.util.Collections.reverseOrder;

public class Contests {


    public void solve2465() {

        int[] nums = new int[]{10,2,2,0,4,0};
        int[] bucket = new int[101];

        for(int i=0; i<nums.length; i++) {
            bucket[nums[i]]++;
        }
        int firstP=0;
        int secondP=100;

        Set<Double> st = new HashSet<>();

        while(firstP<=secondP){
            while(firstP<=100 && bucket[firstP]<=0)
                firstP++;
            while (secondP>=0 && bucket[secondP]<=0)
                secondP--;

            if(firstP>secondP)
                break;
            System.out.println(bucket[firstP] + " " + bucket[secondP]);
            st.add(((double)(firstP + secondP))/2);
            bucket[firstP]--;
            bucket[secondP]--;
        }
        st.forEach((e)->{
            System.out.println(e);
        });
        System.out.println(st.size());
    }

    public void solve2466(){

        int low=3, high=3, zero=1, one=1;

        long mod = (long) (1e9 + 7);

        int []dp = new int[100000+1];
        dp[zero]++;
        dp[one]++;
        long count=0;
        for(int i=1; i<=(Math.min(100000,high)); i++) {
            if(i-zero>=0)
                dp[i]+=dp[i-zero];
            if(i-one>=0)
                dp[i]+=dp[i-one];

            if(i>=low && i<=high)
                count=(count+dp[i])% mod;

        }
        System.out.println(count);
    }

    public void solve2500(){
        int[][] grid = new int[][]{{1,2,4},{3,3,1}};
        int[][] tempGrid = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            int[] rowArray = grid[i];
            Arrays.sort(rowArray);
            reverse(rowArray);
            for(int j=0; j<rowArray.length; j++){
                tempGrid[i][j]=rowArray[j];
            }
        }

        for(int[] i:tempGrid){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        int ans=0;
        for(int i=0; i<tempGrid[0].length; i++) {
            long maxm=0;
            for(int j=0; j<tempGrid.length; j++) {
                maxm = Math.max(maxm, tempGrid[j][i]);
            }
            ans+=maxm;
        }
        System.out.println(ans);
    }

    public void solve2501(){
        int[] nums = new int[]{4,3,6,16,8,2};

        Map<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());

        for(int i:nums){
            map.putIfAbsent(i,0);
        }

        map.forEach((x,y)->{
            System.out.println(x+" -> "+ y);
        });

        int ans=0;
        map.forEach((key,value)->{
            int x = (int)Math.sqrt((double)(key));
            if(x*x == key) {
                if(map.containsKey(x))
                    map.put(x,map.get(key)+1);
            }
        });

        map.forEach((x,y)->{
            System.out.println(x+ " -> " + y);
        });

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            ans= Math.max(e.getValue(),ans);
        }
        System.out.println(ans+1);

    }


    public  void solve846(){

        int[] hand = new int[]{1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        Map<Integer, Integer > map = new TreeMap<Integer,Integer>();


        for(int i=0; i<hand.length; i++)
        {
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }

        map.forEach((key,value)->{
            System.out.println(key+ "-> "+value);
        });


        boolean ans= true;
        while(!map.isEmpty()){

            int x= groupSize;
            List<Integer> ls = new ArrayList<>();

            Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();

            while(it.hasNext()){
                Map.Entry<Integer,Integer> e = it.next();
                ls.add(e.getKey());
                if(e.getValue()==1)
                    it.remove();
                else {
                    e.setValue(e.getValue()-1);
                }
                x--;
                if(x==0)
                    break;
            }
            if(x!=0)
                ans=false;
            for(int i=1; i<ls.size(); i++){
                if(ls.get(i)!=ls.get(i-1)+1)
                    ans=false;
            }
            if(!ans)
                break;
        }
        System.out.println(ans);

    }


    public void reverse(int[] arr){
        int i=0;
        while(i<(arr.length-1-i)){
            int x= arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=x;
            i++;
        }
    }


}
