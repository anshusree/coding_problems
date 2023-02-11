class Solution {
    private int timer = 1;
    public void dfs(int source, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] dist, int[] low, List<List<Integer>> bridges){
        visited[source] =1;
        dist[source] = low[source] = timer;
        timer++;
        
        for(Integer neigh:adj.get(source)){
            if(neigh == parent) continue;
            if(visited[neigh] ==0){
                dfs(neigh,source,adj,visited,dist,low,bridges);
                low[source] = Math.min(low[source],low[neigh]);
            }
            if(low[neigh] > dist[source]){
                bridges.add(Arrays.asList(neigh,source));
            }
            else{
                low[source]=Math.min(low[source],low[neigh]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(List<Integer> neigh:connections){
            int u = neigh.get(0);
            int v = neigh.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] visited =new int[n];
        int[] dist = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,adj,visited,dist,low,bridges);
        return bridges;
    }
}
