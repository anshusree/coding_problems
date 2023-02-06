class Solution {
    public void dfs(int source, boolean[] visited, ArrayList<Integer> res, ArrayList<ArrayList<Integer>> adj){
        visited[source] = true;
        res.add(source);
        for(int neigh:adj.get(source)){
            if(!visited[neigh]){
                dfs(neigh,visited,res,adj);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        dfs(0,visited,res,adj);
        return res;
    }
}
