class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        for(int i=0; i<V; i++){
            if(visited[i]==0){
                if(dfs(i,-1,visited,adj)==true) return true;
            }
        }
        return false;
    }
    public boolean dfs(int source, int parent, int[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[source]=1;
        for(int neigh:adj.get(source)){
            if(visited[neigh]==0){
                if(dfs(neigh,source,visited,adj)==true) return true;
            }
            else if(neigh!=parent) return true;
        }
        return false;
    }
}
