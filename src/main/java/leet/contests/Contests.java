package leet.contests;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.Pair;
import sun.security.util.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;
import static java.util.Collections.copy;
import static java.util.Collections.reverseOrder;

public class Contests {



    public void solve1351(){

        int[] prices = new int[]{8,4,6,2,3};
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[prices.length];
        for(int i=prices.length-1; i>=0; i--){
            if(stack.isEmpty()){
                ans[i]=prices[i];
                stack.push(prices[i]);
            } else{
                System.out.println(stack.peek());
                ans[i]=prices[i]-(stack.peek()>prices[i]?0:stack.peek());

                while (!stack.isEmpty() && stack.peek() >= prices[i]) {
                    stack.pop();
                }
                stack.push(prices[i]);
            }
        }
        for (int i : ans) {
            System.out.print(i);
        }
    }

    public void solve905(){
        int[] arr = new int[]{1,3,4,2492,2493,3351,1010,3049};
        Integer[] arr2 = ArrayUtils.toObject(arr);
       Arrays.sort(arr2, (first, second) -> {
              if(first%2!=0 && second%2==0)
                  return 1;
              else return -1;
       });



        for(int i:arr2)
            System.out.print(i+ " ");
/*
        int[] ans = Arrays.stream(arr).boxed().sorted(new Comparator<Integer>(){
            @Override
            public int compare(Integer first, Integer second) {
                if(first%2==0 && second%2!=0)
                    return -1;
                return 0;
            }
        }).mapToInt((e)->e.intValue()).toArray();

        int pointerEvenNumber =-1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2==0){
                pointerEvenNumber=i;
                break;
            }
        }
        if(pointerEvenNumber!=-1) {
            for (int i = 0; i < arr.length && pointerEvenNumber<arr.length ; i++) {
                if (pointerEvenNumber < i && arr[i] % 2 == 1) {
                    while (pointerEvenNumber < arr.length) {
                        if (arr[pointerEvenNumber] % 2 == 0 && pointerEvenNumber > i) {pointerEvenNumber = i;
                        break;}
                        pointerEvenNumber++;
                    }
                }
                if (pointerEvenNumber < arr.length && arr[i] % 2 == 1) {
                    int x = arr[i];
                    arr[i] = arr[pointerEvenNumber];
                    arr[pointerEvenNumber] = x;
                    while(pointerEvenNumber<arr.length){
                        if(arr[pointerEvenNumber]%2==0)
                            break;
                        pointerEvenNumber++;
                    }
                }
            }
        }
        for (int i : arr) {
            System.out.print(i+ " ");
        }*/


        /*System.out.println("");
        for(int i:ans)
        {
            System.out.print(i+ " ");
        }*/

        /*

        for(int i:arr){
            System.out.println(i);
        }

        int j=0;
        for(int i=0; i<arr.length && j<arr.length; i++){
            if(arr[i]%2==0)
                continue;
            else{
                while(j<arr.length){
                    if(arr[j]%2==0)
                        break;
                    j++;
                }
                if(j<arr.length){
                    int x= arr[i];
                    arr[i]=arr[j];
                    arr[j]=x;
                } else {
                    break;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i+ " ");
        }*/


    }

    public void solve2521(){
        int[] nums = new int[]{2,4,3,7,10,6};
        int[] primeNumbers = new int[1001];
        Arrays.fill(primeNumbers,1);

        primeNumbers[0]=0;
        primeNumbers[1]=0;
        primeNumbers[2]=1;
        for(int i=2; i<1001; i++){
            if(primeNumbers[i]==1){
                for(int j=2; j*i<1001; j++){
                    primeNumbers[j*i]=0;
                }
            }
        }

        System.out.println("");
        for (int i : primeNumbers) {
            System.out.print(i+ " ");
        }
        System.out.println("");

        Set<Integer> st = new HashSet<>();

        for(int i=2; i<1001; i++){
            if(primeNumbers[i]==1){
                for(int j=0; j<nums.length; j++){
                    while(nums[j]%i==0) {
                        nums[j] /= i;
                        st.add(i);
                    }
                }
            }
        }
        System.out.println("000-89938");
        System.out.println(st.size());


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
    public void solve1254(){
        int[][] grid = new int[][]{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1
                ,1,1,0}};

        int count=0;
        int[][] vis = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(vis[i][j]==0 && grid[i][j]==0)
                    if(dfs1254(grid,vis,i,j))
                        count++;
            }
        }
        System.out.println(count);
    }

    public boolean dfs1254(int[][] grid, int[][] vis, int i, int j){
        if(!validCordinates(i,j,grid.length,grid[0].length) || vis[i][j]==1)
            return true;

        vis[i][j]=1;
        if(grid[i][j]==1)
            return true;

        if(cornerCordinates(i,j,grid.length,grid[0].length)){
            return false;
        }
        boolean x = dfs1254(grid, vis, i+1,j);
        boolean y = dfs1254(grid, vis, i-1,j);
        boolean u = dfs1254(grid, vis, i,j+1);
        boolean v = dfs1254(grid, vis, i,j-1);

        return x && y && u && v;
    }

    public boolean cornerCordinates(int i, int j, int n, int m){
        return i==0 || i==n-1 || j==0 || j==m-1;
    }

    public void solve1905(){
        int[][] grid1 = new int[][]{{1,0,1,0,1},{1,1,1,1,1},{0,0,0,0,0},{1,1,1,1,1},{1,0,1,0,1}};
        int[][] grid2 = new int[][]{{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}};

        int n= grid1.length;
        int m = grid1[0].length;
        int[][] vis = new int[grid2.length][grid2[0].length];

        Boolean isSubIsland = Boolean.TRUE;
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(grid2[i][j]==1 && vis[i][j]==0) {
                    if(dfs1905(grid1, grid2, vis, true, i, j))
                        count++;
                }
            }
        }
        System.out.println(count);
    }

    public Boolean dfs1905(int[][] grid1, int[][] grid2, int[][] vis, Boolean isSubIsland, int i, int j) {
        if(!validCordinates(i,j, grid1.length, grid1[0].length) || vis[i][j]==1) {
            return true;
        }
        vis[i][j] = 1;
        if(grid2[i][j]==0)
            return true;
        if (grid1[i][j]==0)
            isSubIsland=false;

        Boolean x = dfs1905(grid1, grid2, vis, isSubIsland, i + 1, j);
        Boolean y = dfs1905(grid1, grid2, vis, isSubIsland, i - 1, j);
        Boolean u = dfs1905(grid1, grid2, vis, isSubIsland, i, j + 1);
        Boolean v = dfs1905(grid1, grid2, vis, isSubIsland, i, j - 1);

        return   isSubIsland && x && y && u && v;
    }

    public void solve1992(){

        int[][] land = new int[][]{{1,0,0},{0,1,1},{0,1,1}};
        int[][] vis = new int[land.length][land[0].length];

        List<int[]> ans = new ArrayList<>();
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++) {
                if(land[i][j]==1){
                    Integer startX=i,startY=i,endX=i,endY=i;
                    dfs(land,vis,startX,startY,endX,endY,i,j);
                    ans.add(new int[]{startX,startY,endX,endY});
                }
            }
        }
        int[][] finalAns = (int[][]) ans.stream().toArray();
    }

    public void dfs(int[][] land, int [][]vis, Integer startX, Integer startY, Integer endX, Integer endY, int x,int y){
        if(!validCordinates(x,y,land.length,land[0].length))
            return;
        if(vis[x][y]==0 && land[x][y]==1){
            vis[x][y]=1;
            if(x<startX){
                startX=x;startY=y;
            } else if(x==startX && y<startY){
                startY=y;
            }

            if(x>endX)
            {
                endX=x;endY=y;
            } else if(x==endX && y>endY)
                endY=y;

            dfs(land,vis,startX,startY,endX,endY,x+1,y);
            dfs(land,vis,startX,startY,endX,endY,x-1,y);
            dfs(land,vis,startX,startY,endX,endY,x,y+1);
            dfs(land,vis,startX,startY,endX,endY,x,y-1);
        } else
            return;
    }

    public void solve2512(){

        String[] positive_feedback = new String[]{"smart","brilliant","studious"};
        String[] negative_feedback = new String[]{"not"};
        String[] report = new String[]{"this student is studious","the student is smart"};
        int[] student_id = new int[]{1,2};
        int k = 2;

        Queue<Pair<Integer,Integer>> queue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                if(p1.getValue()>p2.getValue())
                    return 1;
                if(p1.getValue()==p2.getValue() && p1.getKey()>p2.getKey())
                    return 1;
                return 0;
            }
        });

        Set<String>  positive = new HashSet<>();
        Set<String> negative = new HashSet<>();

        positive = Arrays.stream(positive_feedback).distinct().collect(Collectors.toSet());
        negative = Arrays.stream(negative_feedback).distinct().collect(Collectors.toSet());

        for(int i=0; i<student_id.length; i++ ){

            String t = report[i];

            int count=0;
            String[] words = t.split(" ");
            for(String word : words) {
                if(positive.contains(word))
                    count+=3;
                if(negative.contains(word))
                    count-=1;
            }
            if(queue.size()>k){
                Pair<Integer,Integer> lastItem = queue.peek();
                if(lastItem.getValue()< count){
                    queue.poll();
                    queue.add(lastItem);
                } else if(lastItem.getValue()==count && lastItem.getKey()>student_id[i]){
                    queue.poll();
                    queue.add(Pair.of(student_id[i],count));
                }
            } else {
                queue.add(Pair.of(student_id[i],count));
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        queue.forEach((e)->{
            ans.add(e.getKey());
        });
        ans.forEach((e)->{
            System.out.println(e);
        });
    }

    public void solve2251(){
        int[] forts = new int[]{1,0,0,-1,0,0,0,0,1};
        int maxIndex=-1;
        int minIndex=Integer.MAX_VALUE;
        int maxIndexminus1=-1;
        int minIndexminus1=Integer.MAX_VALUE;
        for(int i=0; i<forts.length; i++) {
            if(forts[i]==1){
                minIndex = min(minIndex,i);
                maxIndex = min(maxIndex,i);
            }
            if(forts[i]==-1){
                minIndexminus1 = min(minIndexminus1,i);
                maxIndexminus1 = min(maxIndexminus1,i);
            }
        }

        int ans=0;
        int count=0;
        for(int i=minIndex; i<=maxIndexminus1; i++)
        {
            if(forts[i]==0)
                count++;
        }
        ans=max(ans,count);
        for(int i=maxIndex; i>=minIndexminus1; i--)
        {
            if(forts[i]==0)
                count++;
        }
        ans=max(ans,count);

        System.out.println(ans);
    }

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
        for(int i = 1; i<=(min(100000,high)); i++) {
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
                maxm = max(maxm, tempGrid[j][i]);
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
            int x = (int) sqrt((double)(key));
            if(x*x == key) {
                if(map.containsKey(x))
                    map.put(x,map.get(key)+1);
            }
        });

        map.forEach((x,y)->{
            System.out.println(x+ " -> " + y);
        });

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            ans= max(e.getValue(),ans);
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
    public boolean validCordinates(int x, int y, int row, int col) {
        return x>=0 && x<row && y>=0 && y<col;
    }
}
