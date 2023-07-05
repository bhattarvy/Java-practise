package leet;

import org.apache.zookeeper.server.ServerCnxn;
import org.graalvm.compiler.nodes.extended.ArrayRangeWrite;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.Map.Entry;

class Pair{
    char first;
    char second;
    Pair(char first, char second){
        this.first=first;
        this.second=second;
    }

    public static Pair of(char x, char y){
        return new Pair(x,y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair pair = (Pair) o;
        return first == pair.first && second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}


class CustomComparator implements Comparator<Character> {



    @Override
    public int compare(Character t2, Character t1) {
        if (t2 > t1) {
            return 1;
        } else
            return -1;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }
}
public class Contests {


    public static void main(String[] args) {

        Contests contests = new Contests();


    }


    /*

        838
        Approach-1
        - given dominoes
        - onyl . are effected, other than that wont be effected
        - when there is . - we have to process the consective . as well and do it with two pointer.
        - for ex L...R...L
           - only one case when there will be conflict - R....L



        Approach-2 Mutli Source BFS



     */


    public String solve838(String dom){

        char first =dom.charAt(0);
        char[]  ans = new char[dom.length()];

        for(int i=0; i<dom.length(); i++)
            ans[i]=dom.charAt(i);

        int firstIndex=0;
        char second;
        for(int i=1; i<dom.length(); i++){
            second = dom.charAt(i);
            if(first=='R' && second == 'L'){
                int x= i-firstIndex-1;
                if(x%2==1){
                    int y=x/2;
                    for(int j=i+1; j<=i+y; j++)
                        ans[j]=first;
                    for(int j=i+y+2; j<=i-1; j++)
                        ans[j]=second;

                    ans[i+y+1]='.';


                } else{
                    int y=x/2;
                    for(int j=i; j<=i+y; j++)
                        ans[j]=first;
                    for(int j=i+y+1; j<=i-1; j++)
                        ans[j]=second;

                }
            }
            if(second!='.') {
                first = second;
                firstIndex = i;
            }
        }

        // left

        for(int i=0; i<ans.length; i++){
            if(ans[i]=='R') {
                if (i + 1 < ans.length && ans[i] == '.') ans[i + 1] = 'R';
            }
        }

        for(int i= ans.length-1; i>=0; i--){
            if(ans[i]=='L'){
                if(i-1 >= 0 && ans[i-1]=='.')
                    ans[i-1]='L';
            }
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

        String finalAns = new String(ans);
        System.out.println(finalAns);
        return finalAns;
    }



    /*
        523
        Apporach-1 Map
        - Map<modulos, index>
        -

     *//*

    public boolean checkSubArray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum=0;
        for(int i=0; i<nums.length; i++) {
            sum+= nums[i];
            int x = sum%k;
            if(map.containsKey(x)){

                if(i-map.get(x)+1 >=2)
                    return true;

            } else{
                map.put(x, i);
            }
        }

        map.forEach((key,value)->{
            System.out.println(key + " " +value);
        });

        return false;
    }
    */


    /*public void solve179(){
        int[] nums =new int[]{3,30,34,5,9};
        Integer[] nums2 = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(nums2,(o1,o2)->{
          return -1*((String.valueOf(o1)+String.valueOf(o2)).compareTo(String.valueOf(o2)+String.valueOf(o1)));
        });

        nums = Arrays.stream(nums2).mapToInt(e->e).toArray();

        for (int i : nums) {
            System.out.println(i);
        }
        StringBuffer ans = new StringBuffer();
        for(int i:nums)
            ans.append(String.valueOf(i));

    }

    *//*
        Apporoach-1 - customer compartor
        o1+o2 compare with o2+o1


     */



   /*

    public void solve28(){
        String hayStack="", needle = "";


    }
    *//*
        Approach1 - brute force



        Apporach-2 -

     */


    public int[][] solve56(int[][] intervals){

        Arrays.sort(intervals, (int[] i, int[] j)->{
           if(i[0]>j[0])
               return 1;
           else if(i[0]<j[0])
               return -1;
           else {
               if(i[1]>j[1])
                   return 1;
               else
                   return -1;
           }
        });


        for (int[] i : intervals) {
            System.out.println(i[0] + " " +i[1]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        int start=intervals[0][0],end=intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]>=end){
                ans.add(Arrays.asList(start,end));
                start =intervals[i][0];
                end= intervals[i][1];
                continue;
            }

            end = intervals[i][1];
            System.out.println("startend "+ start + " "+end);
        }
        ans.add(Arrays.asList(start,end));
        ans.forEach((e)-> System.out.println(e.get(0)+ " "+e.get(1)));


        int[][] finalAns = new int[ans.size()][2];
        /*ans.stream().forEach((e)->{
            finalAns[finalAns.length][0] =e.get(0);
            finalAns[finalAns.length][1]=e.get(1);
        });*/

        int k=0;
        for(List<Integer> i : ans){
            finalAns[k][0]=i.get(0);
            finalAns[k][1] = i.get(1);
            k++;
        }

        System.out.println("----");

        for(int[] i: finalAns){
            System.out.println(i[0] + " " + i[1]);
        }

        return finalAns;
    }

    public int solve150(){
        String[] tokens = new String[]{"2","1","+","3","*"};
        Stack<Integer> stack = new Stack<>();
        Set<String> st = new HashSet<>(Arrays.asList("+","-","*","/"));

        for(int i=0; i<tokens.length; i++){
            if(st.contains(tokens[i])){
                if(tokens[i].equals("+")){

                    int x= stack.pop();
                    int y=stack.pop();
                    stack.push(x+y);
                }

                if(tokens[i].equals("-")){
                    int x= stack.pop();
                    int y=stack.pop();
                    stack.push(y-x);
                }

                if(tokens[i].equals("*")){
                    int x= stack.pop();
                    int y=stack.pop();
                    stack.push(x*y);
                }

                if(tokens[i].equals("/")){
                    int x= stack.pop();
                    int y=stack.pop();
                    stack.push(y/x);
                }

            } else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }

       return stack.pop();

    }

    public void solve1356(){
        List<Integer> ans = Arrays.asList(1,2,3,4,5);
        int[] ans1=ans.stream().mapToInt(e->e).toArray();
        System.out.println(ans1);
        for (int i : ans1) {
            System.out.println(i+  " ");
        }

    }

    public void solve1090(){
        int[] values = new int[]{};
        int[] lables = new int[]{};
        int numWanted;
        int useLimit;

        Map<Integer,List<Integer>> map = new TreeMap<>((o1,o2)->{
           return o2-o1;
        });


    }

    public void solve1337(){
        Scanner sc = new Scanner(System.in);
        int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int k=3;

        Queue<List<Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.get(0) > o2.get(0)) {
                return -1;
            } else if (o1.get(0) < o2.get(0)) {
                return 1;
            } else {
                if(o1.get(1)>o2.get(1))
                    return -1;
                else
                    return 1;
            }
        });

        int ind=0;
        for(int[] i: mat){
            int x = findLastIndexof1(i);
            pq.add(Arrays.asList(x+1,ind));
            if(pq.size()>k)
                pq.poll();
            ind++;
        }
        List<Integer> finalAns = new ArrayList<>();
        while(!pq.isEmpty()){
            finalAns.add(pq.peek().get(1));
            pq.poll();
        }
        Collections.reverse(finalAns);
        finalAns.forEach((e)-> System.out.println(e));
        int[] hey = finalAns.stream().mapToInt(i->i).toArray();
    }
    private int findLastIndexof1(int[] nums){
        int i=0;
        int j=nums.length-1;
        int mid=0;
        int ans=-1;
        while(i<=j){
            mid = (i+j)/2;
            if(nums[mid]==0)
                j=mid-1;
            else {
                ans = mid;
                i = mid + 1;
            }
        }
        if(ans==-1)
            return 0;
        else
            return ans;
    }

    private void display(Queue<Integer> queue){
        Integer[] arr = queue.stream().toArray(Integer[]::new);
        for (int i : arr) {
            System.out.print(i+ " ");
        }
    }

    public void solve977(){
        int[] nums = {-4,-1,0,3,10};

        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr,(o1,o2)->{
            return 1;
        });
        nums = Arrays.stream(arr).mapToInt(i->i).toArray();
        for (int i : nums) {
            System.out.print(i+ " ");
        }
    }


    public void solve905(){
        int[] nums = new int[]{3,1,2,4};

        Integer[] t = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        for (int i : t) {
            System.out.println(i + " -> ");
        }
        Arrays.sort(t,(o1,o2)->{
            System.out.println(o1 +" -> " + o2);
            if(o1%2==0 && o2%2==1)
                return -1;
            else return 1;
        });

        int[] ans = Arrays.stream(t).mapToInt(i->i).toArray();
        for (int i : ans) {
            System.out.println(i+ "==");
        }

        for (int i : t) {
            System.out.println(i);
        }

    }


    public void solve1598(){

        String[] logs = new String[]{"d1/","d2/","../","d21/","./"};
        Stack<String> st = new Stack<>();
        for(String s : logs){
            if(s.equals("../")){
                System.out.println("smfd");
                System.out.println(st.size());

                if(!st.isEmpty())
                    st.pop();
                System.out.println(st.size());
                continue;
            }
            if(s.equals("./")){
                continue;
            }
            st.push(s);
        }

        System.out.println(st);
        Iterator<String> it = st.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(st.size());
    }

    public void solve496(){
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};

        Set<Integer> st = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums1.length; i++)
            st.add(nums1[i]);

        for(int i=nums2.length-1; i>=0; i--){

            if(st.contains(nums2[i])){
                while(!stack.isEmpty() && stack.peek()<=nums2[i]){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    map.put(nums2[i],stack.peek());
                } else {
                    map.put(nums2[i],-1);
                }
                stack.push(nums2[i]);
            } else{
                while(!stack.isEmpty() && stack.peek()<=nums2[i]){
                    stack.pop();
                }
                stack.push(nums2[i]);
            }

        }
        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i]=map.get(nums1[i]);
        }
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }



    public void solve1614(){
        String s = "(1+(2*3)+((8)/4))+1";
        Stack<Character> stack = new Stack<>();
        int ans=0;
        for(int i=0 ;i<s.length() ; i++){
            if(s.charAt(i)=='('){
                stack.push('(');
                ans = Math.max(ans,stack.size());
            } else if(s.charAt(i)==')') {
                stack.pop();
            }
        }
        System.out.println(ans);
    }

    public void solve1021(){

        String s = "";
        Stack<Character> st = new Stack<>();
        StringBuffer ans = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            } else {
                if(s.charAt(i)==')'){
                    st.pop();
                    if(st.isEmpty())
                        ans.append(s.charAt(i));

                } else {
                    ans.append(s.charAt(i));
                }
            }
        }

        System.out.println(ans.toString());

    }

    public void solve2553() {
        int[] nums = new int[]{13,25,83,77};
        List<Integer> ans = new ArrayList<>();
        for(int i:nums){
            List<Integer> digits = new ArrayList<>();
            while(i>0){
                digits.add(i%10);
                i=i/10;
            }
            Collections.reverse(digits);
            for(int j:digits){
                ans.add(j);
            }
            System.out.println("");
        }
        System.out.println("");
        for (int i : ans) {
            System.out.print(i);
        }
        Integer[] finalAns = (Integer[]) ans.toArray();
    }

    public void playGround(){
       Integer[] arr = new Integer[]{1,2,3,5};
       List<Integer> arrList = Arrays.asList(arr);
       for(int  i: arrList){
           System.out.println(i);
       }

    }



    public void solve424(){
        String s ="ABAB";
        int k=2;
        Comparator comparator = new CustomComparator();
        TreeMap<Character, Integer> map = new TreeMap<>(comparator);
        map.put(s.charAt(0),1);
        int i=0,j=0;
        int ans=1;
        while(i<s.length() && j<s.length()){

            int value=0;
            for(int  val:map.values()){
                value = Math.max(value,val);
            }
            if(((j-i)+1)-value > k){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),1)-1);
                i++; j=(j<i?i:j);
            } else {
                ans = Math.max(ans,(j-i)+1);
                j++;
                if(j>=s.length())
                    break;
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            }
        }
        System.out.println(ans);



    }


    public void solve2546(){
        String s="00000100000";
        String target="11011011011";

        Map<Pair,Integer> map = new HashMap<>();


        for(int i=0; i<s.length(); i++){
            Pair p = new Pair(s.charAt(i),target.charAt(i));
            map.put(p,map.getOrDefault(p,0)+1);
        }

        map.forEach((key,value)->{
            System.out.println(key.first+ "-> "+ key.second + " = " + value);
        });
        boolean ans=true;
        Pair oneZero =Pair.of('1','0');
        Pair zeroOne =Pair.of('0','1');
        Pair oneOne =Pair.of('1','1');
        if(map.getOrDefault(oneZero,0)!=0 && map.getOrDefault(zeroOne,0)!=0){
            ans=true;
        }
        int x =(map.getOrDefault(oneZero,0)==0?map.getOrDefault(zeroOne,0):map.getOrDefault(oneZero,0));
        if(x>map.getOrDefault(oneOne,0)){
            ans= false;
        }
        System.out.println(ans);

    }

    public void solve2545(){

        int[][] score = new int[][]{{10,6,9,1},{7,5,11,2},{4,8,3,15}};

        int k=2;

        Map<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i=0; i<score.length; i++){
            map.put(score[i][k],i);
        }

        int[][] ans = new int[score.length][score[0].length];
        int ansIndex=0;
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            int x= e.getValue();
            for(int i=0; i<score[0].length; i++){
                ans[ansIndex][i]=score[x][i];
            }
            ansIndex++;
        }

        for(int[] i: ans) {
            System.out.println("");
            for (int j : i) {
                System.out.print(j + " ");
            }
        }
    }

    public void solve2544(){
        int n=111;
        List<Integer> numbers = new ArrayList<>();
        while(n>0){
            numbers.add(n%10);
            n=n/10;
        }
        Collections.reverse(numbers);
        int ans=0;
        int parity=0;
        for(int i:numbers){
            if(parity==0){
                ans+=i;
            } else{
                ans-=i;
            }
            parity = (parity==0?1:0);
        }
        System.out.println(ans);
    }


    public void solve2520(){
        long num=121;

        Set<Integer> st = new HashSet<>();
        long x =num;
        while(x>0){
            int y = (int)num%10;
            if(num%y==0)
                st.add(y);
            x/=10;
        }
        System.out.println(st.size());
    }
    public void solve2383(){
        int initialEnergy=5;
        int initialExp = 3;
        int n=4;
        int energy[] = new int[]{1,4,3,2};
        int exp[] = new int[]{2,6,3,1};

        int hours=0;
        for(int i=0; i<n; i++) {
            if(!(initialEnergy > energy[i])){
                hours+= energy[i]-initialEnergy+1;
                initialEnergy=energy[i]+1;
            }
            if(!(initialExp > exp[i])){
                hours+= exp[i]-initialExp+1;
                initialExp=exp[i]+1;
            }
            initialEnergy-=energy[i];
            initialExp+=exp[i];
        }
        System.out.println(hours);
    }


    public String solve2384(){

        String num = "6006";
        Map<Character, Integer> treeMap = new TreeMap<>(Comparator.<Character>reverseOrder());
        for (int i = 0; i < num.length(); i++) {
            if (treeMap.containsKey(num.charAt(i))) {
                treeMap.put(num.charAt(i), treeMap.get(num.charAt(i)) + 1);
            } else {
                treeMap.put(num.charAt(i), 1);
            }
        }
        treeMap.forEach((key, value)->{
            System.out.println(key+ " = " + value);
        });

        final Character[] singleDigit = { '0' };
        final boolean[] updated = { false };
        StringBuffer ans = new StringBuffer();
        if(treeMap.get('0')==num.length()) {
            ans.append("0");
            return ans.toString();
        }

        treeMap.forEach((key,value)->{
            if(value%2!=0) {
                singleDigit[0] = (singleDigit[0] < key ? key : singleDigit[0]);
                updated[0] =true;
            }

            if (!(key == '0' && !(ans.length() > 0))) {
                for (int i = 0; i < (value % 2 == 0 ? value : value - 1) / 2; i++) {
                    ans.append(key);
                }
            }
        });

        System.out.println(singleDigit[0]+ " --- " + ans.toString() );
        StringBuffer revans = new StringBuffer(ans);
        revans.reverse();
        System.out.println(revans);
        if(updated[0])
            ans.append(singleDigit[0]);
        System.out.println(ans);

        ans.append(revans);
        System.out.println(ans.toString());
        return ans.toString();
    }

    public void solve1796(){
        String s="dfa12321afd";
        /*int a=-1,b=-1;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                if(Integer.parseInt(String.valueOf(s.charAt(i))) > a){
                    b=a;
                    a= Integer.parseInt(String.valueOf(s.charAt(i)));
                } else if (Integer.parseInt(String.valueOf(s.charAt(i))) < a && Integer.parseInt(String.valueOf(s.charAt(i))) > b)
                    b= Integer.parseInt(String.valueOf(s.charAt(i)));
            }
        }
        System.out.println(b);*/

        Map<Character, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
        }

        for(Map.Entry<Character,Integer> e :map.entrySet()){
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        int ans=-1;
        int count=0;
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            count++;
            if(count==2) {
                System.out.println(e.getKey() + " -- " + e.getValue());
                System.out.println(ans + "  " + e.getKey());
                ans = Integer.parseInt(String.valueOf(e.getKey()));
                System.out.println(ans);
                break;
            }
        }
        System.out.println("kdfngfdg " + ans);


    }

    @FunctionalInterface
    public interface functionInterface{
        void getName();
    }

}
