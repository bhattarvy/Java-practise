package leet.graphs;

import java.util.*;

public class Leet1 {

    public void solve733(){
        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int sr=1,sc=1,color=2;
        int[][] vis = new int[3][3];
        dfs(image,vis,sr,sc,color);
    }

    public void solve116(){
        Node root = new Node();
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        int count=1;

    }

    public void solve2367(){
        int[] nums = new int[]{0,1,4,6,7,10};
        int diff=3;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int x = nums[j]-nums[i];
                if(x==diff)
                    map.put(i,map.getOrDefault(i,0)+1);
            }
        }
        int ans=0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++) {
                int x=nums[j]-nums[i];
                if(x==diff)
                    ans+=map.getOrDefault(j,0);
            }
        }
        System.out.println(ans);

    }

    public void solve804() {
        String[] words = new String[]{"a"};
        String[] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
                "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> st= new HashSet<>();

        Map<Character,Integer> mp = new HashMap<>();

        for(String t : words){
            StringBuffer transformed = new StringBuffer();
            for(int i=0; i<t.length(); i++){
                int x=  t.charAt(i)-97;
                transformed.append(codes[x]);
            }
            st.add(transformed.toString());
        }
        System.out.println(st.size());
    }

    public void solve2418(){
        String[] names = new String[]{"Mary","John","Emma"};
        int[] heights = new int[]{180,165,170};

        Map<Integer,String> map = new TreeMap<>(Collections.reverseOrder());
        for(int i=0; i<names.length; i++){
            map.put(heights[i],names[i]);
        }

        List<String> ansList = new ArrayList<>();
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            ansList.add(entry.getValue());
        }

        String[] ans = ansList.toArray(new String[0]);
        for (String t : ans) {
            System.out.println(t);
        }
    }




    // Private Functions


    private void connect(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int x=1;
        int count = 1;
        while(count>0) {
            x=count;
            count=0;
            while (x > 0) {
                Node temp = queue.remove();
                temp.next = queue.peek();
                if (temp.left != null) {
                    count++;
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    count++;
                    queue.add(temp.right);
                }
                x--;
            }
        }


    }

    private void dfs(int[][] image, int[][] vis, int sr, int sc, int color){


    }

}
