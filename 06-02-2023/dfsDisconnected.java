import java.util.ArrayList;

public class Solution {
    public static void dfs(int source, boolean[] visited, ArrayList<Integer> res, ArrayList<ArrayList<Integer>> graph){
        visited[source] = true;
        res.add(source);
        for(int neigh:graph.get(source)){
            if(!visited[neigh]){
                dfs(neigh,visited,res,graph);
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(v);
        for(int i=0; i<v; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<e; i++){
            int v1 = edges.get(i).get(0);
            int v2 = edges.get(i).get(1);
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        boolean[] visited = new boolean[v];
        for(int i=0; i<v; i++){
            if(!visited[i]){
                ArrayList<Integer> res = new ArrayList<>();
                dfs(i,visited,res,adjList);
                components.add(res);
            }
        }
        return components;
    }
}
