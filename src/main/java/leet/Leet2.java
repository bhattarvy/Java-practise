package leet;

import com.sun.org.apache.xpath.internal.operations.Bool;


import java.sql.Timestamp;
import java.text.CharacterIterator;
import java.text.SimpleDateFormat;
import java.util.*;

public class Leet2 {

    Scanner sc = new Scanner(System.in);

    public char solve2351(){
        String s ="abcdd";
        HashSet<Character> map = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            if(map.contains(s.charAt(i)))
                return s.charAt(i);
            else
                map.add(s.charAt(i));
        }
        return ' ';
    }

    public int solve2352() {
        int[][] grid = new int[][]{{3,2,1},{1,7,6},{2,7,7}};
        int ans=0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0; i<rows; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<cols; j++) {
                list.add(grid[i][j]);
            }

            int index=0;
            for(int k=0; k<cols; k++){
                index=0;
                for(int l=0; l<rows; l++) {
                    if(grid[l][k]==list.get(index)){
                        index++;
                    } else
                        break;
                }
                if(index==list.size())
                    ans++;
            }
        }
        return ans;
    }



    public String solve2347() {
        int[] ranks = new int[]{13,2,3,1,9};
        char[] suits = new char[]{'a','a','a','a','a'};

        Boolean isFlush= true;
        for(int i=1; i<suits.length; i++) {
            if (suits[i] != suits[i - 1]) {
                isFlush = false;
                break;
            }
        }
        if(isFlush)
            return "Flush";

        Map<Integer,Integer> mp =new HashMap<>();

        for(int i=0; i<ranks.length; i++) {
            if(mp.containsKey(ranks[i])){
                mp.put(ranks[i],mp.get(ranks[i])+1);
            } else
                mp.put(ranks[i],1);
        }

        Boolean isSecond = false;
        Boolean isThird = false;

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()) {
            if(entry.getValue()>=3)
                isSecond=true;
            if(entry.getValue()>=2)
                isThird=true;
        }

        if(isSecond)
            return "Three of a Kind";
        if(isThird)
            return "Pair";

        return "High Card";
    }

    public  long solve2348() {
        int[] nums = new int[]{2,10,2019};
        long countZeros=0;
        long ans=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0)
                countZeros++;
            else
                countZeros=0;
            ans+=countZeros;
        }
        return ans;
    }


    public int solve2349(){

        Map<Integer, Set<Integer>> mp =  new HashMap<>();

        for(int i=0; i<10; i++) {
            if(mp.containsKey(i)) {
                Set<Integer> st = mp.get(i);
                st.add(i);
                mp.put(i,st);
            } else {
                Set<Integer> st = new TreeSet<>();
                st.add(i);
                mp.put(i,st);
            }
        }



        return 1;

    }


    public void solvePramod() {
        int n= sc.nextInt();
        int[] nodes = new int[n];
        for(int i=0; i<n; i++)
            nodes[i] =sc.nextInt();

        Map<Integer,List<Integer>> adjList = new HashMap<>();
        int edges = sc.nextInt();
        for(int i=0; i<edges; i++){
            int x,y;
            x=sc.nextInt();
            y=sc.nextInt();
            if(adjList.containsKey(y)){
                List<Integer> l =adjList.get(y);
                l.add(x);
                adjList.put(y,l);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(x);
                adjList.put(y,l);
            }
        }
        int source=sc.nextInt(),destination=sc.nextInt();
        Set<Integer> ans = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for(int i : adjList.getOrDefault(destination, new ArrayList<>())) {
            dfs(adjList,ans,visited,i,source,i);
        }

        for(int i:ans)
            System.out.print(i+ " ");

    }

    public void dfs(Map<Integer,List<Integer>> adjList, Set<Integer> ans, Set<Integer> visited, int node, int source, int connected) {
        if(visited.contains(node))
            return;
        if(node==source){
            ans.add(source);
            return;}
        visited.add(node);
        for(int i: adjList.getOrDefault(node,new ArrayList<>()) ) {
            if(i==source) {
                ans.add(connected);
            } else if(!visited.contains(i)) {
                dfs(adjList,ans,visited,i,source,connected);
            }
        }
    }


    public static void main(String[] args) {
        testTimeZone();
    }

    public static void calenderFunctionality() {

        // This Month
        //1st date timestamp
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH,1);
        calendar1.set(Calendar.HOUR_OF_DAY,00);
        calendar1.set(Calendar.MINUTE,00);
        calendar1.set(Calendar.SECOND,59);
        System.out.println(new Timestamp(calendar1.getTime().getTime()).getTime());

        // last data timestamp
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH,calendar2.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar2.set(Calendar.HOUR_OF_DAY,23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND,59);
        System.out.println(new Timestamp(calendar2.getTime().getTime()).getTime());

        // Next Month
        // 1st date
        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(Calendar.MONTH,1);
        calendar3.set(Calendar.DAY_OF_MONTH,1);
        calendar3.set(Calendar.HOUR_OF_DAY,00);
        calendar3.set(Calendar.MINUTE,00);
        calendar3.set(Calendar.SECOND,59);
        System.out.println(new Timestamp(calendar3.getTime().getTime()).getTime());

        // last data timestamp
        Calendar calendar4 = Calendar.getInstance();
        calendar4.add(Calendar.MONTH,1);
        calendar4.set(Calendar.DAY_OF_MONTH,calendar4.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar4.set(Calendar.HOUR_OF_DAY,23);
        calendar4.set(Calendar.MINUTE, 59);
        calendar4.set(Calendar.SECOND,59);
        System.out.println(new Timestamp(calendar4.getTime().getTime()).getTime());

        // Today


        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));


        Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
        System.out.println(timestamp.getTime());
        System.out.println(timestamp);
        System.out.println(new Timestamp(calendar.getTime().getTime()));
        System.out.println(new Timestamp(calendar.getTime().getTime()));



        System.out.println("---");


        /*Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH,5);
        System.out.println(calendar1.get(Calendar.MONTH));
        System.out.println(calendar1.get(Calendar.YEAR));
        System.out.println(calendar1.getActualMinimum(Calendar.DAY_OF_MONTH));
        System.out.println(calendar1.getActualMaximum(Calendar.DAY_OF_MONTH));*/

    }

    private static void testTimeZone(){
        Calendar calendar = Calendar.getInstance();

        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(calendar.getTime());

        calendar.setTimeZone(TimeZone.getTimeZone("PST"));
        System.out.println(calendar.getTimeZone());
        System.out.println(calendar.getTime());


        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.setTimeZone(TimeZone.getTimeZone("PST"));

        System.out.println(calendar.getTimeZone());
        System.out.println(calendar.getTime());
        System.out.println(dateFormat.format(calendar.getTime()));

        String[] zones = TimeZone.getAvailableIDs();
        for (String t : zones) {
            System.out.println(t);
        }
    }

    private static String toDate(long timestamp) {
        Date date = new Date(timestamp * 1000);
        System.out.println(date);
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }


}
