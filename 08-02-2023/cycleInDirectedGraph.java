class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        int[] predecessor = new int[V];
        for(int i=0; i<V; i++){
            if(visited[i]==0){
                if(dfs(i,predecessor,visited,adj)==true) return true;
            }
        }
        return false;
    }
    public boolean dfs(int source, int[] predecessor, int[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[source]=1;
        predecessor[source]=1;
        for(int neigh:adj.get(source)){
            if(visited[neigh]==0){
                if(dfs(neigh,predecessor,visited,adj)==true) return true;
            }
            else if(predecessor[neigh]==1) return true;
        }
        predecessor[source]=0;
        return false;
    }
}
