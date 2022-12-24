package leet;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.temporal.ChronoField;
import java.util.*;
import java.io.InputStream;
import java.util.stream.Collectors;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void solve2180() {
        int n = sc.nextInt();
        int countEven = 0;
        for (int i = 1; i <= n; i++) {
            int x = i;
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            if (sum % 2 == 0) {
                countEven++;
            }
        }
        System.out.println(countEven);
    }

    public static void solve2220() {
        int start, end;
        start = sc.nextInt();
        end = sc.nextInt();

        int count = 0;
        while (start > 0 || end > 0) {
            if ((start & 1) != (end & 1)) {
                count++;
            }

            start = (start >> 1);
            end >>= 1;
            System.out.println(start + " " + end);
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

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }


        for (int j = n - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        System.out.println(nums[0]);

    }


    public static void solve2222() {
        String s = sc.next();

        int size1endson1 = 0;
        int size1endson0 = 0;
        int size2endson1 = 0;
        int size2endson0 = 0;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') {
                count += size2endson0;
                size1endson1++;
                size2endson1 += size1endson0;

            } else {
                count += size2endson1;
                size1endson0++;
                size2endson0 += size1endson1;
            }
        }

        System.out.println(count);
    }


    public static void solve1() {
        /*int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];*/

        int[][] nums = new int[][] { {3,1,2,4,5}, {1,2,3,4},{3,4,5,6}};

        int n=nums.length;
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums[i].length; j++)
                System.out.println(nums[i][j]);

        }
       /* for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = sc.nextInt();
            }
        }*/

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (mp.containsKey(nums[i][j])) {
                    mp.put(nums[i][j], mp.get(nums[i][j])+1);
                } else {
                    mp.put(nums[i][j], 1);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (Integer e : mp.keySet()) {
            if (mp.get(e) == n) {
                ans.add(e);
            }
        }

        Collections.sort(ans);

        System.out.println(ans);


    }




    public static void test() {

        /*Map<String, Customer> customerMap=  new HashMap<>();
        customerMap.put("Arvind", new Customer("Arivnd", "Bhatt","12"));

        customerMap = new HashMap<>();


        if(customerMap.isEmpty()) {
            System.out.println("this is empty");
        }*/

        /*Map<String, Map<String,String>> map = new HashMap<>();
        Map<String,String> t = new HashMap<>();
        t.put("1","1");
        map.put("Arvind",t);
        System.out.println(map);

        Map<String,String> test = map.getOrDefault("unknown", new HashMap<>());
        Map<String,String> test2 = map.get("unknown");

        System.out.println(test);
        System.out.println(test2);*/

        List<String> stringList = new ArrayList<>();
        stringList.add("Arvind");
        stringList.add("Toremove");
        stringList.add("bhatt");
        stringList.add("Toremove");


       /* for(String s : stringList) {
            if(s=="Toremove") {
                stringList.remove(s);
            }
        }*/
        Iterator iterator = stringList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("Toremove"))
                iterator.remove();
        }
        System.out.println(stringList);


        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Arvind", "Bhatt", "1"));
        customerList.add(new Customer("Toremove", "Toremove", "Toremove"));
        customerList.add(new Customer("Bhatt", "Bhatt", "2"));
        customerList.add(new Customer("Toremove", "Toremove", "Toremove"));

       /* for(Customer c : customerList) {
            if(c.getName().equals("Toremove")) {
                customerList.remove(c);
            }
        }*/

        Iterator<Customer> iterator1 = customerList.iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next().getName() == "Toremove") {
                iterator1.remove();
                break;
            }
        }
        System.out.println(customerList);


    }

    public static  void solve2() {

        int[][] circles = new int[][]{ {2,2,2}, {3,4,1}};

        int ans=0;
        for(int i=0; i<=200; i++){
            for(int j=0; j<=200; j++){
                for(int k=0; k<circles.length; k++){
                    if(Math.abs((circles[k][0]-i)*(circles[k][0]-i)) + Math.abs((circles[k][1]-j)*(circles[k][1]-j)) <=
                            circles[k][2]*circles[k][2]) {
                        ans++;
                        System.out.println(i+ " " + j);
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static void solve3() {

        int[] nums =new int[]{4,4,4,2,2,1,3,3,1,5};

        Map<Integer,Integer> mp =new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(mp.containsKey(nums[i])) {
                mp.put(nums[i],mp.get(nums[i])+1);
            } else
                mp.put(nums[i],1);
        }

        int[][] ans=new int[mp.size()][2];

        int i=0;
        for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
            System.out.println(entry.getKey() +  " : " + entry.getValue());
            ans[i][0]=entry.getValue();
            ans[i][1]=entry.getKey();
            i++;
        }

        for(i=0; i<ans.length; i++) {
            for(int j=i+1; j<ans.length; j++){
                if(ans[i][0]<ans[j][0]){
                    int t =ans[i][0];
                    ans[i][0]=ans[j][0];
                    ans[j][0]=t;
                    t=ans[i][1];
                    ans[i][1]=ans[j][1];
                    ans[j][1]=t;
                }
                if(ans[i][0]==ans[j][0]){
                    if(ans[i][1]<ans[j][1]){
                        int t =ans[i][0];
                        ans[i][0]=ans[j][0];
                        ans[j][0]=t;
                        t=ans[i][1];
                        ans[i][1]=ans[j][1];
                        ans[j][1]=t;
                    }
                }
            }
        }

        List<Integer> finalAns = new ArrayList<>();
        for(i=0; i<ans.length; i++) {
            finalAns.add(ans[i][1]);
        }
        System.out.println(finalAns);


    }


    public static void solve1051() {

        int[] heights = new int[]{5,1,2,3,4};
        int[] duplicate = new int[heights.length];


        for(int i=0; i<heights.length; i++)
        {
            duplicate[i]=heights[i];
        }

        Arrays.sort(duplicate);

        int count=0;
        for(int i=0; i<heights.length; i++) {
            if(heights[i]!=duplicate[i])
                count++;
        }

        System.out.println(count);
    }

    public static Boolean solve2160() {
        int[] nums = new int[]{1,2,3,1};

        Map<Integer,Integer> mp =new HashMap<>();
        for(int i=0 ;i<nums.length; i++) {
            if(mp.containsKey(nums[i])){
                mp.put(nums[i],mp.get(nums[i])+1);
            } else{
                mp.put(nums[i],1);
            }
        }

        for(int  i :mp.values()) {
            if(i>1){
                return true;
            }
        }
        return false;
    }



    public static void solve2231() {

        int num=1234;
        List<Integer> numArr = new ArrayList<>();
        List<Integer> oddArr = new ArrayList<>();
        List<Integer> evenArr = new ArrayList<>();

        while(num>0){
            int x = num%10;
            numArr.add(x);
            if(x%2==0){
                evenArr.add(x);
            } else {
                oddArr.add(x);
            }
            num=num/10;
        }

        Collections.reverse(numArr);
        Collections.sort(evenArr);

        int oddIndex=0,evenIndex=0;

        for(int i=0; i<numArr.size(); i++ ){
            if(numArr.get(i)%2==0){
                numArr.set(i,evenArr.get(evenIndex));
                evenIndex++;
            } else{
                numArr.set(i,oddArr.get(oddIndex));
                oddIndex++;
            }
        }
        int ans=0;
        for(int x:numArr){
            ans=ans*10+x;
        }
        System.out.println(ans);

    }


    public static void solve1337(){
        int[][] mat = new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,1,1,0}};
        Map<Integer,Integer> rowMap = new TreeMap<>();

        for(int i=0; i<mat.length; i++) {
            int[] temp =mat[0];

            int first=0;
            int second =mat[0].length;
            int ans=-1;
            while(first<=second) {
                int mid =(first+second)/2;
                if(mat[i][mid]==0){
                    second=mid-1;
                } else {
                    if((mid+1)<=mat[0].length) {
                        if(mat[i][mid+1]==0){
                            ans=mid;break;
                        } else {
                            first=mid+1;
                        }
                    } else{
                        ans=mid;break;
                    }

            }
            rowMap.put(ans,i);
        }

        List<Integer> finalAns = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : rowMap.entrySet()) {
            System.out.println(entry.getKey()+ " "+ entry.getValue());
            finalAns.add(entry.getValue());
        }
        System.out.println("-------");
        for(int j: finalAns)
            System.out.println(j);
    }

    }

    private static void solve_3(){
        String s="abcabcbb";

        Map<Character,Integer> characterIntegerMap = new HashMap<>();

        int i=0,j=0;
        int ans=0;
        while(j<s.length()) {
            System.out.println(s.charAt(j) + " " + characterIntegerMap.get(s.charAt(j)));
            while(characterIntegerMap.get(s.charAt(j))!=null && characterIntegerMap.get(s.charAt(j))==1){
                characterIntegerMap.put(s.charAt(i),0);
                i++;
            }
            characterIntegerMap.put(s.charAt(j),1);
            ans = Math.max(ans,j-i+1);
            j++;
        }
        System.out.println(ans);
    }

    public static void solve2255() {
        String[] words = new String[] {"a","a"};
        String s ="aa";

        Set<String> stringSet = new HashSet<>();

        StringBuffer temp =new StringBuffer();

        int count=0;
        for(int i=0; i<s.length(); i++) {
            temp.append(s.charAt(i));
            stringSet.add(temp.toString());
        }
        for(String t:words){
            if(stringSet.contains(t)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void solve2256() {
        int[] nums = new int[]{4,2,0};
        int sumAllElements =0;
        for(int i:nums){
            sumAllElements+=i;
        }
        int ind=0,avg=Integer.MAX_VALUE;
        int firstValueSum=0;
        for(int i=0; i<(nums.length); i++) {
            firstValueSum+=nums[i];
            sumAllElements-=nums[i];
            System.out.println((firstValueSum/(i+1))  + " "  + (sumAllElements/((nums.length-1-i)==0?1:(nums.length-1-i))));
            int temp = Math.abs(Math.round(firstValueSum/(i+1)) - Math.round(sumAllElements/((nums.length-1-i)==0?1:(nums.length-1-i))));
            if(temp<avg)
            {
                avg=temp;
                ind=i;
            }
        }
        System.out.println(ind);
    }

    public static void solveTest(){
        /* 1266
        int[][] points = new int[][] {{}};
        int ans=0;
        for(int i=1; i<points.length; i++)
        {
            ans= ans + Math.max(Math.abs(points[i][0]-points[i-1][0]), Math.abs(points[i][1]-points[i-1][1]));
        }
        System.out.println(ans);

        int[][] indices = new int[][] {{}};*/

        /*
        1252
        int[] row = new int[indices.length];
        int[] col = new int[indices[0].length];

        for(int i=0; i<indices.length; i++) {
            row[indices[i][0]]++;
            col[indices[i][1]]++;
        }
        int count=0;
        for(int i=0; i<row.length; i++)
        {
            for(int j=0; j<col.length; j++)
            {
                if((row[i]+col[j])%2==0)
                    count++;
            }
        }
        System.out.println(count);*/


        /* 1351
        int[][] num =new int[][]{{}};
        int j=num[0].length;
        int ans=0;
        int i=0;
        while(i<num.length && j>=0){
            while(j>=0 && num[i][j]<0){
                j--;
            }
            if(j==-1){
                ans+=(num.length-i)*(num[0].length);
            }
            ans+=(num[0].length-j-1);
            i++;
        }
        System.out.println(ans);*/

        /*905
        int[] A = new int[]{1,2 ,3,4,5, 6};
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for(int i=0; i<A.length; i++) {
            if(A[i]%2==0) {
                even.add(A[i]);
            } else {
                odd.add(A[i]);
            }
        }

        List<Integer> ans = new ArrayList<>();
        System.out.println(even);
        System.out.println(odd);
        ans.addAll(even);
        ans.addAll(odd);
        System.out.println(ans);*/

        /* inplace even odd sort
        int[] A = new int[]{};

        int evenInd=-1;
        int oddInd=-1;

        for(int i=0; i<A.length; i++) {
            if(A[i]%2==0) {

            }


        }*/


        /* 1475
        int[] prices = new int[]{10,1,1,6};
        Stack<Integer> st = new Stack<>();

        int[] ans = new int[prices.length];
        for(int i=prices.length-1; i>=0; i--) {
            while(!st.empty() && st.peek() > prices[i]){
                System.out.println(st.peek());
                st.pop();
            }

            ans[i]=prices[i]-(st.empty()?0:st.peek());
            st.push(prices[i]);
        }
        for(int i :ans)
            System.out.println(i);*/

        /*int[] arr = new int[]{49,18,16};
        int[][] pieces = new int[][]{{16,18,49}};

        Map<Integer, int[]> integerArrMap = new HashMap<>();
        for(int i=0; i< pieces.length; i++){
            integerArrMap.put(pieces[i][0],pieces[i]);
        }

        int i=0;
        int flag=1;
        while(i<arr.length && flag==1) {
            if(integerArrMap.containsKey(arr[i])){
                int[] temp = integerArrMap.get(arr[i]);
                for(int j:temp){
                    if(arr[i]!=j) {
                        flag=0;break;
                    }
                    i++;
                }
            } else flag=0;

        }
        if(flag==1)
            System.out.println("possible");
        else
            System.out.println("not possible");*/


        /*int[] nums = new int[]{-4,-1,0,3,10};
        int i=0,j=nums.length-1;
        List<Integer> ans= new ArrayList<>();
        while(i<=j){
            System.out.println("sfjdn");
            if(Math.abs(nums[i])<=Math.abs(nums[j])){

                ans.add(nums[i]*nums[i]);
                i++;
            } else {
                ans.add(nums[j] * nums[j]);
                j--;
            }
        }
        System.out.println(ans);
        System.out.println(ans.toArray());*/


        /*
        int[] heights = new int[]{};
        int[] temp=heights;
        Arrays.sort(temp);
        int count=0;
        for(int i=0; i<heights.length; i++) {
            if(temp[i]!=heights[i])
                count++;
        }
        System.out.println(count);*/

        /*int[][] mat = new int[][]{{3,7,8},{9,11,13},{15,16,17}};
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        Arrays.fill(row,Integer.MAX_VALUE);
        Arrays.fill(col, Integer.MIN_VALUE);

        System.out.println(row[0]);

        int n=mat.length;
        int m=mat[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                row[i] = Math.min(row[i],mat[i][j]);
            }
        }

        for(int j=0; j<m; j++){
            for(int i=0; i<n; i++){
                col[j]=Math.max(col[j],mat[i][j]);
            }
        }

        List<Integer> ans =new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(row[i]==mat[i][j] && col[j] ==mat[i][j])
                    ans.add(mat[i][j]);
            }
        }

        for(int i:row)
            System.out.println(i);

        System.out.println("----");

        for(int i:col)
            System.out.println(i);
        System.out.println("---");
        System.out.println(ans.toArray());
        System.out.println(ans.size());
        for(Object i:ans.toArray())
            System.out.println(i);*/

        /*int[] nums = new int[]{4,2,5,7};

        List<Integer> oddEvendis = new ArrayList<>();

        for(int i=0; i< nums.length; i++) {
            if(nums[i]%2==0 && i%2==1){
                oddEvendis.add(i);
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2==1 && i%2==0){
                oddEvendis.add(i);
            }
        }

        for(int k: oddEvendis)
            System.out.println(k);
        System.out.println("----");
        int i=0,j=oddEvendis.size()-1;
        while(i<j){
            System.out.println(nums[i] + " " + nums[j]);
            int t= nums[oddEvendis.get(i)];
            nums[oddEvendis.get(i)]=nums[oddEvendis.get(j)];
            nums[oddEvendis.get(j)]=t;
            i++;
            j--;
        }
        for(int k:nums){
            System.out.println(k);
        }*/


        /*int[][] mat = new int[][]{{}};
        int k=3;
        int[] noOfSoliders = new int[mat.length];

        for(int i=0; i<mat.length; i++) {
            int[] temp=mat[i];
            int index=Arrays.binarySearch(temp,1);
            if(index<0){
                noOfSoliders[i]=0;
            } else{
                int no=0;
                while(!(index<-1)){
                    no=index;
                    if(index+1 < mat[i].length)
                        break;
                    index=Arrays.binarySearch(temp,index+1,mat[i].length,1);

                }
                noOfSoliders[i]=no;
            }
        }
        Arrays.sort(noOfSoliders);
        int[] ans =Arrays.copyOfRange(noOfSoliders,0,k-1);
        for(int i:ans)
            System.out.println(i);*/


        /*int[] arr1 = new int[]{};
        int[] arr2 = new int[]{};

        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0; i<arr2.length; i++) {
            mp.put(arr2[i],i);
        }*/


        /*int[] nums = new int[]{4,2,5,7};

        int oddNumberEvenIndex=-1;
        int evenNumberOddIndex=-1;

        for(int i=0; i<nums.length; i++ ){
            if(nums[i]%2==0 && i%2==1 && evenNumberOddIndex==-1)
                evenNumberOddIndex=i;
            if(nums[i]%2==1 && i%2==0 && oddNumberEvenIndex==-1)
                oddNumberEvenIndex=i;
        }

        if(oddNumberEvenIndex==-1){
            System.out.println("every element is present in the right place");
        }

        while(true) {
            int temp = nums[evenNumberOddIndex];
            nums[evenNumberOddIndex]=nums[oddNumberEvenIndex];
            nums[oddNumberEvenIndex]=temp;

            while(evenNumberOddIndex<nums.length) {
                if(nums[evenNumberOddIndex]%2==0 && evenNumberOddIndex%2==1)
                    break;
                evenNumberOddIndex++;
            }

            while(oddNumberEvenIndex<nums.length) {
                if(nums[oddNumberEvenIndex]%2==1 && oddNumberEvenIndex%2==0)
                    break;
                oddNumberEvenIndex++;
            }

            if(evenNumberOddIndex>=nums.length || oddNumberEvenIndex>=nums.length)
                break;;

        }

        for(int i: nums)
            System.out.print(i+ " ");*/


        /*int[] ar= new int[]{1,2,3,4,5};
        List<Integer> ar1 = new ArrayList<>();
        for(int i:ar){
            ar1.add(i);
        }

        ListIterator<Integer> ar1Iterator= ar1.listIterator();

        System.out.println(ar1Iterator.next());
        while (ar1Iterator.hasNext()){
            System.out.println(ar1Iterator);
            System.out.println(ar1Iterator.next());
        }

        System.out.println("--");*/

        /*String[] words = new String[]{"abba","baba","bbaa","cd","cd"};
        List<String> ans= new ArrayList<>();

        ans.add(words[0]);
        for(int i=1; i<words.length; i++) {
            //xor
            Map<Character,Integer> first= new HashMap<>();
            Map<Character,Integer> second= new HashMap<>();

            for(int j=0; j<words[i].length(); j++){
                if(first.containsKey(words[i].charAt(j))) {
                    first.put(words[i].charAt(j),first.get(words[i].charAt(j)));
                } else {
                    first.put(words[i].charAt(j),1);
                }
            }

            for(int j=0; j<words[i-1].length(); j++){
                if(second.containsKey(words[i-1].charAt(j))) {
                    second.put(words[i-1].charAt(j),second.get(words[i-1].charAt(j)));
                } else {
                    second.put(words[i-1].charAt(j),1);
                }
            }

            if(!first.equals(second)) {
                ans.add(words[i]);
            }
        }

        for(String t :ans)
            System.out.print(t + " ");*/

        /*int[] code = new int[]{2,4,9,3};
        int k=-2;

        if(k==0)
        {
            Arrays.fill(code,0);
            System.out.println("---");
            for(int i:code)
                System.out.print(i);
        }

        if(k<0){
            k=Math.abs(k);
            int[] ans = new int[code.length];
            int i=code.length-k; int j=code.length-1;
            int prevKSum=0;
            for(int t=i; t<=j; t++){
                prevKSum+=code[t];
            }
            for(int t=0; t<code.length; t++) {
                ans[t]=prevKSum;
                prevKSum-=code[i];
                i=(i+1)%code.length;
                j=(j+1)%code.length;
                prevKSum+=code[j];
                System.out.println("ans[t]: "+ ans[t]+ " prevKSUm : "+ prevKSum);
            }

            System.out.println("----");
            for(int t:ans)
                System.out.print(t+" ");
        } else {

            int[] ans = new int[code.length];
            int i=1; int j=k;
            int prevKSum=0;
            for(int t=i; t<=k; t++){
                prevKSum+=code[t];
            }
            System.out.println("prevKSum:"+ prevKSum);

            for(int t=0; t<code.length; t++) {
                ans[t]=prevKSum;
                prevKSum-=code[i];
                i=(i+1)%code.length;
                j=(j+1)%code.length;
                prevKSum+=code[j];
                System.out.println("ans[t] : " + ans[t] + " prevKSum : " + prevKSum);
            }
            System.out.println("----");
            for(int t:ans)
                System.out.print(t+" ");

        }*/


        /*int[][] grid = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int k=1;

        int[][] temp = new int[grid.length][grid[0].length];

         for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[i].length; j++) {
                int increments = (j + k)/ (grid[0].length);
                temp[(i+increments)%(grid.length)][(j+increments)%(grid[0].length)]= grid[i][j];
            }
        }

        for(int [] i:temp) {
            System.out.println();
            for(int j:i)
                System.out.print(j+ " ");

        }*/

       /*int[] nums = new int[]{4,3,10,9,8};
       Arrays.sort(nums);

       int sum=0;
       for(int i:nums)
           sum+=i;

       int curSum=0;
       List<Integer> ans = new ArrayList<>();
       for(int j=nums.length-1; j>=0; j--) {
           curSum+=nums[j];
           sum-=nums[j];
           ans.add(nums[j]);
           if(curSum>sum)
               break;
       }

       System.out.println();
       for(int j:ans)
           System.out.print(j + " " );*/

        /*int[] nums = new int[]{-4,-2,1,4,8};
        int ans=Integer.MAX_VALUE;
        int finalAns=-1;
        for(int i:nums) {
            if(ans>=Math.abs(i)) {
                if (ans == Math.abs(i)) {
                    if (finalAns < i)
                        finalAns = i;
                }
                ans = Integer.min(ans, Math.abs(i));
                finalAns=i;
            }
        }
        System.out.println(ans + " ans " + "finalAns " + finalAns);*/


        /*
        * prices[] = {1 2 6 3 4 2 5 6 }
        *               1  4  1    3 1  - 10
        *                  5   1     4   - 10
        * */


        /*int[]  prices = new int[] {};
        int ans=0;
        for(int  i=1; i<prices.length; i++) {
            if(prices[i]-prices[i-1] > 0)
                ans+= prices[i]-prices[i-1];
        }
        System.out.println(ans);*/


        /*int[] g = new int[] {};
        int[] s = new int[] {};

        Arrays.sort(g);
        Arrays.sort(s);

        int ans=0;
        int j=0;
        for(int i=0; i<g.length; i++) {
            int x=g[i];
            while(j<s.length) {
                if(s[j]>=x) {
                    ans++;
                    j++;
                    break;
                }
                j++;
            }
        }
        System.out.println(ans);*/




        /*String s="sdfsd",t="sfd";
        int  j=0;
        int i=0;
        for(i=0; i<s.length(); i++)
        {
            while(j<t.length()){
                if(s.charAt(i)==t.charAt(j)){
                    j++;
                    break;
                }
                j++;
            }
        }
        if(i==s.length()){
            System.out.println("");
        }*/

        /*String n="321";
        int ans=0;
        for(int i=0; i<n.length(); i++) {
            System.out.println(n.charAt(i) + " " + Integer.valueOf(n.charAt(i)) + " " + Integer.parseInt(String.valueOf(n.charAt(i))));
            int x=Integer.parseInt(String.valueOf(n.charAt(i)));
            ans=Math.max(ans,x);
        }
        System.out.println(ans);*/

        /*String s="eccbbbbdec";
        Map<Character,Integer> lastIndex = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            lastIndex.put(s.charAt(i),i);
        }
        int index=0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<s.length(); ) {
            int intialindex=i;
            index = Math.max(index,lastIndex.get(s.charAt(i)));
            while(i<=index) {
                index = Math.max(index, lastIndex.get(s.charAt(i)));
                i++;
            }
            ans.add(index-intialindex+1);
        }
        for(int i:ans)
            System.out.println(i);*/

        /*int[] rowSum = new int[] {3,8};
        int[] colSum = new int[] {4,7};

        int[][] ans = new int[rowSum.length][colSum.length];

        for(int i=0; i<ans.length; i++)
        {
            for(int j=0; j<colSum.length; j++) {

                ans[i][j] = Math.min(rowSum[i],colSum[j]);
                rowSum[i]-=ans[i][j];
                colSum[j]-=ans[i][j];
            }
        }

        for(int[] i:ans){
            for(int j:i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }*/


       /* int num=8;
        int i=1;
        int numberOfBitsOne=0;
        int totalNoBits=0;
        while(i<=num) {
            totalNoBits++;
            if((i&num)==i){
                numberOfBitsOne++;
            }
            i<<=1;
            System.out.println(i);
        }
        System.out.println(totalNoBits+ " " + numberOfBitsOne);
        System.out.println(totalNoBits-1+numberOfBitsOne);*/

        /*
        * 14 -
        *
        * arr[i] xor arr[i+1] xor encoded[i] = encoded[i]
        * arr[i] = encoded[i] xor arr[i+1]
        *
        * encorded[i]  xor arr[i+1 ] xor encorded[i] = arr[i+1]
        *
        * */

        /*int[] encoded = new int[]{1,2,3};
        int first=1;

        int[] ans=  new int[encoded.length+1];
        ans[0]=first;
        for(int i=0; i<encoded.length; i++){
            ans[i+1] = first ^ encoded[i];
            first=ans[i+1];
        }
        for(int i : ans)
            System.out.println(i);*/


        int x=1,y=4;
        int i=1;
        int count=0;
        while(i<=x || i<=y){

            if(!((i&x) == (i&y)))
                count++;
            i<<=2;
        }
        System.out.println(count);

    }

    public static void solve2319(){
        int[][] grid = new int[][]{{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};
        /*
            00 01 02 03
            10 11 12 13
            20 21 22 23
            30 31 32 33
         */

        boolean isValid=true;
        for(int i=0; i<grid.length && isValid!=false; i++) {
            for(int j=0; j<grid[i].length; j++)
            {
                if(((i+j)==(grid.length-1)  || (i==j)) ){
                    if(grid[i][j]==0) {
                        isValid = false;
                        break;
                    }
                } else if(grid[i][j]!=0) {
                    isValid=false;break;
                }
            }
        }
        System.out.println(isValid);
    }


    public static void solve2278() {
        String s="foobar",t="o";

        int count=0;
        for(char i:s.toCharArray()) {
            System.out.println(i + " " + String.valueOf(i) + " " + t);
            if(String.valueOf(i).equals(t)){
                count++;
            }
        }
        System.out.println(count);
        System.out.println((count*100)/s.length());
        int ans = (int) Math.floor((count*100)/s.length());
        System.out.println(ans);
    }

    public static void solve2279() {
        int[] capacity = new int[]{2,3,4,5};
        int[] rocks = new int[]{1,2,4,4};
        int additionalRocks=2;


        int[] diffArray = new int[capacity.length];
        for(int i=0; i<capacity.length; i++) {
            diffArray[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(diffArray);

        int ans=0;
        for(int i=0; i<diffArray.length; i++) {
            if(diffArray[i]>additionalRocks)
                break;
            additionalRocks-=diffArray[i];
            ans++;
        }
        System.out.println(ans);
    }

    public static void solve2280() {
        int[][] stockPrices = new int[][]{{1,1},{500000000,499999999},{1000000000,999999998}};
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0])
                    return 1;
                else
                    return -1;
            }
        };
        Arrays.sort(stockPrices, comp);

        for(int[] t:stockPrices){
            for(int i:t)
                System.out.print(i+ " ");
            System.out.println();
        }

        double prevSlope=Double.MAX_VALUE;
        int ans=1;
        for(int i=1; i<stockPrices.length; i++) {
            int x=stockPrices[i][0],y=stockPrices[i][1];
            int u=stockPrices[i-1][0],v=stockPrices[i-1][1];
            double slope;
            if((u-x)==0){
                slope=Double.MIN_VALUE;
            } else{
                slope = (double) (v-y)/(double) (u-x);
            }
            if(prevSlope!=Double.MAX_VALUE && prevSlope!=slope)
                ans++;
            prevSlope=slope;
        }
        System.out.println(ans);
    }

    public  static void solve2325() {
        String key="the quick brown fox jumps over the lazy dog",message="vkbs bs t suepuv";
        Set<Character> st = new HashSet<>();
        Map<Character,Character> mp =new HashMap<>();
        for(int i=0; i<key.length(); i++){
            if(st.contains(key.charAt(i)) || key.charAt(i)==' ')
                continue;
            st.add(key.charAt(i));
            mp.put(key.charAt(i),(char) (st.size()+96));
        }

        for(Map.Entry<Character,Character> t : mp.entrySet()){
            System.out.println(t.getKey() + ": "+ t.getValue());
        }

        StringBuffer ans  = new StringBuffer();
        for(int i=0; i<message.length(); i++) {
            if(message.charAt(i)==' ')
                ans.append(message.charAt(i));
            else
                ans.append(mp.get(message.charAt(i)));
        }
        System.out.println(ans.toString());
    }

    public static void main(String[] args) {


        List<String> values = Arrays.asList();

        List<String> t = values.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(t);


        /*List<String> values = new ArrayList<>(Arrays.asList("knfdg","dfgkndfg"));
        List<String> t = null;
        values.addAll(t);
        for (String e : values) {
            System.out.println(e);
        }*/

        /*List<String> t = new ArrayList<>();
        t.add("sdfdn");
        System.out.println(t);
        t.set(1,"sfd");
        System.out.println(t);*/

        /*char c= 'a';
        switch (c){
            case 'a':{
                System.out.println("its a");
            }
            break;
            case 'b': {
                System.out.println("its b");
            }
            break;
            case 'c' : {
                System.out.println("its c");
            }
            break;
        }*/

    }

    public static void contest1(){

        /*String s="ilovecodingonleetcode";
        String t = "code";
        Map<Character,Integer> first = new HashMap<>();
        Map<Character,Integer> second = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(first.containsKey(s.charAt(i))) {
                first.put(s.charAt(i), first.get(s.charAt(i)) + 1);
            } else
            {
                first.put(s.charAt(i),1);
            }
        }
        for(int i=0; i<t.length(); i++) {
            if(second.containsKey(t.charAt(i))) {
                second.put(t.charAt(i), second.get(t.charAt(i)) + 1);
            } else {
                second.put(t.charAt(i),1);
            }
        }
        int ans=0;
        Boolean getOut=false;
        while(!getOut) {
            for(Map.Entry<Character,Integer> e : second.entrySet()){
                if(!(first.get(e.getKey())>=e.getValue())){
                    getOut=true;
                    break;
                }
                first.put(e.getKey(),first.get(e.getKey())-e.getValue());
            }
            ans++;
        }
        System.out.println(ans);*/



        String sentence ="1 2 $3 4 $5 $6 7 8$ $9 $10$";

        int discount =100;

        String[] words =sentence.split(" ");

        for(String i:words)
            System.out.println(i);

        Map<String,String> mp = new HashMap<>();

        for(int  i=0; i< words.length; i++) {
            if(checkIfPriceValue(words[i])){
                double t= convertToLong(words[i], discount);
                mp.put(words[i],"$"+String.format("%.2f",t));
            }
        }

        String ans="";
        for(int i=0; i< words.length; i++){
            if(mp.containsKey(words[i])){
                ans+=mp.get(words[i]);
            } else
                ans+=words[i];
            if(!(i+1==words.length))
                ans+=" ";

        }

        System.out.println(ans);



    }

    public  static double convertToLong(String word, int discount) {
        double x=0;
        for(int i=1; i<word.length(); i++) {
            x=x*10+ Integer.parseInt(String.valueOf(word.charAt(i)));
        }

        x= x - ((x*discount)/(100.00));
        return x;
    }
    public static  Boolean checkIfPriceValue(String word) {
        if(word.charAt(0)=='$'){
            if(word.length()==1)
                return false;

            for(int i=1; i<word.length(); i++){
                if(!(word.charAt(i)>='0' && word.charAt(i)<='9'))
                    return false;
            }
            return true;
        }
        return false;
    }





    public static void  testSyntax() {



        StringBuffer t = new StringBuffer();
        System.out.println("sjbdsd --");
        System.out.println(t.toString() + "sads");
        System.out.println("sdfknsdf ---");
    }

    public static void forTesting() {
        Map<String, Customer> customerMap = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            customerMap.put(String.valueOf(i), new Customer("i", "i " + "lastname", "i " + "customerid"));
        }

        // foreach
        //forloop

        for (Customer customer : customerMap.values()) {
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
