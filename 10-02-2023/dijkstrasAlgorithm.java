class Solution
{
    public int minDistance( int dist[], boolean visited[],int V)
    {
        int min = Integer.MAX_VALUE;
        int min_index = 0;
        for (int i=0; i<V; i++){
            if (visited[i] == false && dist[i]<=min){
                min = dist[i]; 
                min_index = i;
            }
        }
        return min_index;
    }
    
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) 
    {
        int [][] res = new int[V][V];
        for(int i=0; i<V; i++){
            for(int j=0; j<adj.get(i).size(); j++){
                res[i][adj.get(i).get(j).get(0)] = adj.get(i).get(j).get(1);
            }
        }
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        for (int i=0; i<V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[S] = 0;
        for (int count=0; count<V-1; count++)
        {
            int u = minDistance(dist,visited,V);
            visited[u] = true;
            for (int v=0; v<V; v++)
            {
                if (!visited[v] && res[u][v] !=0 && dist[u] != Integer.MAX_VALUE 
                                            && dist[u]+res[u][v] < dist[v])
                    dist[v] = dist[u] + res[u][v];
            }
        }
        return dist;
    }
}
