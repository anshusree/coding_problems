class Solution
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,visited,stack,adj);
            }
        }
        int[] res = new int[V];
        int i=0;
        while(!stack.isEmpty()){
            res[i++]=stack.peek();
            stack.pop();
        }
        return res;
    }
    static void dfs(int source, int[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj){
        visited[source]=1;
        for(int neigh:adj.get(source)){
            if(visited[neigh]==0){
                dfs(neigh,visited,stack,adj);
            }
        }
        stack.push(source);
    }
}
