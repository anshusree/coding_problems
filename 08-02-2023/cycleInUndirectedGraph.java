class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int visited[] = new int[V];
        for(int i=0; i<V; i++){
            visited[i]=0;
        }
        for(int i=0; i<V; i++){
            if(visited[i]==0){
                if(bfs(i,V,visited,adj)==true) return true;
            }
        }
        return false;
    }
    public boolean bfs(int source, int V, int[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[source]=1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(source,-1));
        while(!queue.isEmpty()){
            int node = queue.peek().first;
            int parent = queue.peek().second;
            queue.poll();
            for(int neigh:adj.get(node)){
                if(visited[neigh]==0){
                    visited[neigh]=1;
                    queue.add(new Pair(neigh,node));
                }
                else if(neigh!=parent) return true;
            }
        }
        return false;
    }
}
