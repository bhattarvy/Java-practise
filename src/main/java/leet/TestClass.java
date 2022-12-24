package leet;

import java.util.*;

public class TestClass {

    Scanner sc = new Scanner(System.in);

    public void solvePramod() {
        int n= sc.nextInt();
        int[] nodes = new int[n];
        for(int i=0; i<n; i++)
            nodes[i] =sc.nextInt();

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int edges = sc.nextInt();
        for(int i=0; i<edges; i++){
            int x,y;
            x=sc.nextInt();
            y=sc.nextInt();
            if(adjList.containsKey(x)){
                List<Integer> l =adjList.get(x);
                l.add(y);
                adjList.put(x,l);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(y);
                adjList.put(x,l);
            }
        }
        int source=sc.nextInt(),destination=sc.nextInt();
        Set<Integer> ans = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        dfs(adjList,ans,visited,source,destination);

        for(int i: ans)
            System.out.println(i+" ");



    }

    public void dfs(Map<Integer,List<Integer>> adjList, Set<Integer> ans, Set<Integer> visited, int node, int destination) {
        if(visited.contains(node))
            return;
        visited.add(node);
        for(int i: adjList.getOrDefault(node,new ArrayList<>()) ) {
            if(i==destination) {
                ans.add(node);
            } else if(!visited.contains(i)) {
                dfs(adjList,ans,visited,i,destination);
            }
        }
    }

    public static void main(String[] args) {
        TestClass t = new TestClass();
        t.solvePramod();
    }
}
