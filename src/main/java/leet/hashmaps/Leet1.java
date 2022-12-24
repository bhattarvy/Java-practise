package leet.hashmaps;



import javafx.util.Pair;
import lombok.Data;

import java.util.*;

public class Leet1 {


    public void solve567() {
        String s1 = "ab",s2="eidbaooo";
        boolean ans=false;
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for(int i=0; i<s1.length(); i++) {
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
        }
        int leftPointer=0;
        int rightPointer = s1.length()-1;
        while(rightPointer<s2.length()) {

            if(map2.isEmpty()){
                for(int i=leftPointer; i<=rightPointer; i++){
                    map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);
                }
            }
            if(map2.equals(map1)) {
                ans = true;
                break;
            }
            map2.put(s2.charAt(leftPointer),map2.get(s2.charAt(leftPointer))-1);
            map2.remove(s2.charAt(leftPointer),0);
            leftPointer++;
            rightPointer++;
            if(!(rightPointer<s2.length())){
                break;
            }
            map2.put(s2.charAt(rightPointer),map2.getOrDefault(s2.charAt(rightPointer),0)+1);
        }
        System.out.println(ans);
    }

    public void solve447(){

        int[][] points = new int[][] {{1,1}};
        int ans=0;
        for(int i=0; i<points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            Map<Integer,Integer> countMap = new HashMap<>();

            int distance=0;
            for(int j=0; j<points.length; j++) {
                if(j==i)
                    continue;
                distance = (points[j][0]-x)*(points[j][0]-x) + (points[j][1]-y)*(points[j][1]-y);
                countMap.put(distance,countMap.getOrDefault(distance,0)+1);
            }
            for(int value : countMap.values()){
                if(value>=2){
                    ans+= (value)*(value-1);
                }
            }
        }
        System.out.println(ans);
    }

    public static void solve1657(){
        String word1="uau",word2="ssx";


        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for(int i=0; i<word1.length(); i++){
            map1.put(word1.charAt(i),map1.getOrDefault(word1.charAt(i),0)+1);
        }

        for(int i=0; i<word2.length(); i++){
            map2.put(word2.charAt(i),map2.getOrDefault(word2.charAt(i),0)+1);
        }

        boolean ans=true;
        for(char i ='a'; i<='z'; i++){
            if((map1.getOrDefault(i,0)==0 && map2.getOrDefault(i,0)!=0) || (map1.getOrDefault(i,0)!=0 && map2.getOrDefault(i,0)==0)){
                ans=false;
                System.out.println(ans);
                return;
            }
            if(map1.getOrDefault(i,0)==map2.getOrDefault(i,0))
                continue;
            else
                ans=false;
        }
        if(!ans) {
            List<Integer> list1 = new ArrayList<>(map1.values());
            List<Integer> list2 = new ArrayList<>(map2.values());
            Collections.sort(list1);
            Collections.sort(list2);

            if (list1.equals(list2))
                ans = true;
            else
                ans = false;
        }
        System.out.println(ans);
    }

    public void solve2103(){
        String rings ="B0B6G0R6R0R6G9"; // String pool

        Map<Integer,Set<Character>> map  = new HashMap<>();

        for(int i=1; i<rings.length(); i++){

            if(map.containsKey(Integer.valueOf(rings.charAt(i)))){
                Set<Character> t = map.get(Integer.valueOf(rings.charAt(i)));
                t.add(rings.charAt(i-1));
                map.put(Integer.valueOf(rings.charAt(i)),t);
            } else {
                Set<Character> t= new HashSet<>();
                t.add(rings.charAt(i-1));
                map.put(Integer.valueOf(rings.charAt(i)),t);
            }
        }

        int count=0;
        for(Set<Character> t: map.values()){
            if(t.size()==3)
                count++;
        }
        System.out.println(count);
    }

    public void solve2341(){
        int[] nums = new int[]{1,3,2,1,3,2,2};

        Map<Integer, Integer> map= new HashMap<>();

        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }



        int count=0;
        for(int i : map.values()){
            System.out.println(i);
            if(i%2!=0)
                count++;
        }

        int[] ans = new int[2];
        ans[0]= (nums.length-count)/2;
        ans[1]=count;
        System.out.println(ans[0]+ " " +ans[1]);
    }

    public void solve1941(){

        String s = "abacbc";

        Map<Character,Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        int count=-1;
        boolean ans=true;
        for(Map.Entry<Character,Integer> e : map.entrySet()) {
            if (count == -1) count = e.getValue();
            else if (count != e.getValue()) {
                ans = false;
                break;
            }
        }
        System.out.println(ans);
    }

    public void solve1370(){
        String s ="aaaabbbbcccc";

        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }


        boolean dir=true;
        StringBuffer ans = new StringBuffer();
        while(ans.length()<s.length()){

            if(dir==true){
                for(char i ='a'; i<='z'; i++){
                    if(map.getOrDefault(i,0)>0) {
                        ans.append(i);
                        map.put(i,map.get(i)-1);
                    }
                }
                dir = false;
            } else {
                for(char i='z'; i>='a'; i--){
                    if(map.getOrDefault(i,0)>0) {
                        ans.append(i);
                        map.put(i,map.get(i)-1);
                    }
                }
                dir=true;
            }
        }
        System.out.println(ans);
    }

    public void solve2442(){

        int[] nums = new int[]{1,13,10,12,31};

        Set<Integer> st = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            int x = reverseNumber(nums[i]);
            st.add(x);
            st.add(nums[i]);
        }
        System.out.println(st.size());

    }

    /*public void solve811(){
        String[] cpDomains = new String[]{"9001 discuss.leetcode.com"};

        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<cpDomains.length; i++) {

            String[] pair = StringUtils.splitString(cpDomains[i]," ");
            int count = Integer.valueOf(pair[0]);
            String domain = pair[1];
            String[] domains = StringUtils.splitString(domain,".");
            for(String t : domains){
                map.put(t,map.getOrDefault(t,0)+1);
            }
        }

        List<String> ans = new ArrayList<>();
        for(Map.Entry<String,Integer> e : map.entrySet()) {
            StringBuffer t = new StringBuffer();
            t.append(e.getValue());
            t.append(" ");
            t.append(e.getKey());
            ans.add(t.toString());
        }
        for (String t : ans) {
            System.out.println(t);
        }
    }*/


    public void solve2405() {

        String s = "abacaba";
        int count=0;
        Set<Character> st = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            st.clear();
            for(int j=i; j<s.length(); j++) {
                st.add(s.charAt(i));
                if(st.size()!=(j-i+1)) {
                    i = j - 1;
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }


    public void solve1418() {

        List<List<String>> orders  = new ArrayList<>(Arrays.asList(Arrays.asList("David","3","Ceviche"),
                Arrays.asList("Corina","10","Beef Burrito"), Arrays.asList("David","3","Fried Chicken"),
                Arrays.asList("Carla","5","Water"), Arrays.asList("Carla","5","Ceviche"), Arrays.asList("Rous","3","Ceviche")));

        Set<String> foodItems = new TreeSet<>();
        Set<Integer> tables = new TreeSet<>();

        Map<Pair<String, String>, Integer> map = new HashMap<>();

        for(List<String> i : orders) {
            foodItems.add(i.get(2));
            tables.add(Integer.valueOf(i.get(1)));
            map.put(new Pair<>(i.get(1),i.get(2)), map.getOrDefault(new Pair<>(i.get(1),i.get(2)),0)+1);
        }

        map.forEach((e,y)->{
            System.out.println(e.getKey()+ " " + e.getValue() + " " + y);
        });

        List<String> headers  = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        headers.add("Table");
        for(String i : foodItems){
            headers.add(i);
        }
        ans.add(headers);


        foodItems.forEach((e)-> System.out.println(e));
        System.out.println("----");
        tables.forEach(e-> System.out.println(e));

        for(int i : tables){
            List<String> t = new ArrayList<>();
            t.add(String.valueOf(i));
            for(String  j : foodItems) {
                System.out.println(map.get(new Pair<>(String.valueOf(i),j)));
                t.add(String.valueOf(map.getOrDefault(new Pair<>(String.valueOf(i),j),0)));
            }
            ans.add(t);
        }


        ans.forEach((e)->{
            e.forEach(t->{
                System.out.print(t + " ");
            });
            System.out.println("");
        });
    }

    public void solve2266() {

        String pressedKeys ="222222222222222222222222222222222222";

        Long mod = Long.valueOf((long) (1e9 + 7));
        Map<Long,Long> map = new HashMap<>();

        Long sum=Long.valueOf(0);
        for(Long i=Long.valueOf(1); i<=100000; i++) {
            if(i==1) {
                map.put(Long.valueOf(i), Long.valueOf(1));
                sum=Long.valueOf(1);
            }
            else {
//                System.out.println("-- "+ sum + "----" + (sum+1)%mod);
                map.put(i, (sum + 1)%mod);

                sum+=map.get(i);
            }
        }

        System.out.println(map.get(pressedKeys.length()));

        Long ans=Long.valueOf(1);
        for(int i=0; i<pressedKeys.length(); i++){
            int j=i;
            for(;j<pressedKeys.length(); j++){
                if(pressedKeys.charAt(j)!=pressedKeys.charAt(i)) {
                    j--;
                    break;
                }
            }
            if(j==pressedKeys.length())
                j--;
            Long x =Long.valueOf(j-i+1);
            System.out.println(x);
            i=j;
            ans = (ans*map.get(x))%mod;
        }
        System.out.println(ans);

    }

    public void solve2349(){
        NumberContainers  numberContainers = new NumberContainers();
        numberContainers.change(1,5);
        numberContainers.change(2,6);
        numberContainers.change(3,7);
        numberContainers.change(1,4);
        numberContainers.getMap().forEach((e,y)-> System.out.println(e+ " "+ y));
        System.out.println("mapSet");
        numberContainers.getMapSet().forEach((e,y)->{
            y.forEach((x)-> System.out.println(x));
        });

        numberContainers.find(4);
    }

    // Private

    private int reverseNumber(int x) {
        int ans=0;
        while(x>0){
            ans=ans*10 + (x%10);
            x/=10;
        }
        return ans;
    }


    @Data
    private class NumberContainers {

        Map<Integer,Integer> map = null;
        Map<Integer, Set<Integer>> mapSet = null;

        public NumberContainers() {
            map = new HashMap<>();
            mapSet = new HashMap<>();
        }

        public void change(int index, int number) {

            if(map.containsKey(index)){
                int x= map.get(index);
                map.put(index,number);
                Set<Integer> st = mapSet.get(x);
                if (st != null) {
                    for (Integer e : st) {
                        System.out.println(e);
                    }
                } else {
                    System.out.println("empty");
                }
                mapSet.get(x).remove(index);

            } else
                map.put(index,number);
                mapSet.put(number,new HashSet<>(Arrays.asList(index)));
        }

        public int find(int number) {
            System.out.println("find");
            mapSet.forEach((e,y)->{
                System.out.println(e+"---");
                for (Integer x : y) {
                    System.out.println(x);
                }
            });
            return mapSet.get(number).iterator().next();
        }
    }


}
